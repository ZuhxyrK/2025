package frc.robot.constants;

import com.revrobotics.spark.ClosedLoopSlot;

public class ElevatorConstants {
    // Change device ID's
    public static final int E_LEFT_ID = 25;
    public static final int E_RIGHT_ID = 24;
    public static final int E_STALL_LIMIT = 40; // 40A

    public static final double E_GEAR_RATIO = 1 / 6.666666666666667;
    public static final double E_PULLEY_LENGTH = 180 / 25.4; // 180 is the circumference in mm ( / 25.4 = in)
    public static final double kConversionFactor = E_GEAR_RATIO * E_PULLEY_LENGTH;

    public static final double kP = 0.05;
    public static final double kI = 0;
    public static final double kD = 0.0;
    public static final double kFF = 0.0;
    public static final ClosedLoopSlot E_SLOT = ClosedLoopSlot.kSlot0;

    // in
    public static final int E_MAXHEIGHT = 70;
    public static final double E_TOLERANCE = 0.5;

    public static final double B = 67.17; //barge
    public static final double L2 = 26.85;
    public static final double L3 = 43.86;
    public static final double L4 = 77.10;

    public static final double E_MAXSPEED = 0.25;
}
