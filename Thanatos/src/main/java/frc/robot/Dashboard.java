package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class Dashboard {
    // Adds the main tab in which data will be displayed
    public static ShuffleboardTab tab = Shuffleboard.getTab("Main");

    // Adds all of the variables that will be sent to the dashboard
    public static NetworkTableEntry rMotorSpeed = tab.add("Right Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry lMotorSpeed = tab.add("Left Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveSpeed = tab.add("Drive Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveRotate = tab.add("Drive Rotate", 0.0).getEntry();
    public static NetworkTableEntry driveTimer = tab.add("Teleop Time", 0.0).getEntry();
    public static NetworkTableEntry ldriveVelocity = tab.add("Left Motor Velocity", 0.0).getEntry();
    public static NetworkTableEntry rdriveVelocity = tab.add("Right Motor Velocity", 0.0).getEntry();
    public static ComplexWidget gyro = tab.add("Gyro", RobotContainer.m_Chassis.getGyro());
    public static NetworkTableEntry armPosition = tab.add("Arm Position", 0.0).getEntry();
    

}
