
        // Calculate drivetrain commands from Joystick values
        double forward = -Xcontroller.getLeftY() * Constants.Swerve.kMaxLinearSpeed;
        double strafe = -Xcontroller.getLeftX() * Constants.Swerve.kMaxLinearSpeed;
        double turn = -Xcontroller.getRightX() * Constants.Swerve.kMaxAngularSpeed;

        // Read in relevant data from the Camera
        boolean targetVisible = false;
        double targetYaw = 0.0;
        double targetRange = 0.0;
        var results = camera.getAllUnreadResults();
        if (!results.isEmpty()) {
            // Camera processed a new frame since last
            // Get the last one in the list.
            var result = results.get(results.size() - 1);
            if (result.hasTargets()) {
                // At least one AprilTag was seen by the camera
                for (var target : result.getTargets()) {
                    if (target.getFiducialId() == 7) {
                        // Found Tag 7, record its information
                        targetYaw = target.getYaw();
                        targetRange =
                                PhotonUtils.calculateDistanceToTargetMeters(
                                        0.5, // Measured with a tape measure, or in CAD.
                                        1.435, // From 2024 game manual for ID 7
                                        Units.degreesToRadians(-30.0), // Measured with a protractor, or in CAD.
                                        Units.degreesToRadians(target.getPitch()));

                        targetVisible = true;
                    }
                }
            }
        }

        // Auto-align when requested
        if (controller.getAButton() && targetVisible) {
            // Driver wants auto-alignment to tag 7
            // And, tag 7 is in sight, so we can turn toward it.
            // Override the driver's turn and fwd/rev command with an automatic one
            // That turns toward the tag, and gets the range right.
            turn =
                    (VISION_DES_ANGLE_deg - targetYaw) * VISION_TURN_kP * Constants.Swerve.kMaxAngularSpeed;
            forward =
                    (VISION_DES_RANGE_m - targetRange) * VISION_STRAFE_kP * Constants.Swerve.kMaxLinearSpeed;
        }

        // Command drivetrain motors based on target speeds
        drivetrain.drive(forward, strafe, turn);
