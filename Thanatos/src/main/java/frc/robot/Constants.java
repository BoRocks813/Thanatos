// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.util.Units;

// This is a conveniant way to store variables that will be accessed throughout the robot code
 public final class Constants {
    
    /* ***IMPORTANT*** Be sure you know what you're doing when changing these variables as 
    improper use could damage the robot. Make sure to double check they are the right values
    before running the code */
    public static final int CHASSIS_RIGHT_MOTOR = 2;
    public static final int CHASSIS_LEFT_MOTOR = 1;

    // Sets the port on the computer to which the controller is plugged into 
    public static final int DRIVER_CONTROLLER = 0;

    public static final int ARM_MOTOR = 3;

    // Sets the axes for the drive system joystick
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 4;
    public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;

    public static final int LEFT_TRIGGER_AXIS = 2;
    public static final int RIGHT_TRIGGER_AXIS = 3;

    public static boolean autonOn = false; 

    public final static double linearDriveSense = 0.8;
    public final static double lateralDriveSense = 0.7;
    public final static double moveArmSense = 0.1;

    // Note: The following requires testing
    public final static double armLower = -20;
    public final static double armUpper = 512;

    public final static boolean gyro = false;

    // Values important for trajectory-based auton (if we get it to work)
    public final static double trackWidthMeters = Units.inchesToMeters(19.5);
    public final static double gearRatio = 52 / 14 * 52 / 24;
    public final static double wheelDiameter = Units.inchesToMeters(4);

    public final static double carpetLabkS = 0.696;
    public final static double carpetLabkV = 0.854;
    public final static double carpetLabkA = 0.061;
}
