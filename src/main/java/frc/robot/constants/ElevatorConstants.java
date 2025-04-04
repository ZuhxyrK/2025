package frc.robot.constants;

import com.revrobotics.spark.ClosedLoopSlot;

public class ElevatorConstants {
    // Change device ID's
    public static final int E_LEFT_ID = 25;
    public static final int E_RIGHT_ID = 24;
    public static final int E_STALL_LIMIT = 40; // 40A

    public static final double E_GEAR_RATIO = 1 / ((double)6+(double)2/3);
    public static final double E_PULLEY_LENGTH = 180 / 25.4; // 180 is the circumference in mm ( / 25.4 = in)
    public static final double kConversionFactor = E_GEAR_RATIO * E_PULLEY_LENGTH;

    public static final double kP = 0.035;
    public static final double kI = 0;
    public static final double kD = 0.0004;
    public static final double minOut = -0.25;
    public static final double maxOut = 0.45;
    public static final double kFF = 0.46; // test feed forward to counteract gravity
    public static final ClosedLoopSlot E_SLOT = ClosedLoopSlot.kSlot0;

    // in
    public static final int E_MAXHEIGHT = 80;
    public static final double E_TOLERANCE = 0.5;

    public static final double E_MAXSPEED = 0.25;

    // inches
    public enum ElevatorHeights {
        L2(26.85),
        L3(43.86),
        L4(77.10),
        B(67.17), // barge
        OBIWAN(20), // higher than the ground intake's height to avoid crash
        ZERO(0.7);

        private final double height;

        ElevatorHeights(double height) {
            this.height = height;
        }

        public double getHeight() {
            return height;
        }
    }
}
