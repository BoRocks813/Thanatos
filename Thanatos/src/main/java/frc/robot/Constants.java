// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */

 public final class Constants {
    
    /* ***IMPORTANT*** Be sure you know what you're doing when changing these variables as 
    improper use could damage the robot. Make sure to double check they are the right values
    before running the code */
    public static final int CHASSIS_RIGHT_MOTOR = 0;
    public static final int CHASSIS_LEFT_MOTOR = 1;

    // Sets the port on the computer to which the controller is plugged into
    public static final int DRIVER_CONTROLLER = 0;

    public static final int ARM_MOTOR = 2;

    // Sets the axes for the drive system joystick
	public static final int DRIVER_CONTROLLER_ROTATE_AXIS = (int) RobotContainer.driverController.getY(Hand.kLeft);
    public static final int DRIVER_CONTROLLER_MOVE_AXIS = (int) RobotContainer.driverController.getX(Hand.kLeft);

    
    public static boolean autonOn = false; 

    public static int SOLENOID = 0;
}
