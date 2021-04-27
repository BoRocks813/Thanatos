package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class Dashboard {
    public static ShuffleboardTab tab = Shuffleboard.getTab("Main");

    public static NetworkTableEntry rMotorSpeed = tab.add("Right Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry lMotorSpeed = tab.add("Left Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveSpeed = tab.add("Drive Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveRotate = tab.add("Drive Rotate", 0.0).getEntry();
    public static NetworkTableEntry driveTimer = tab.add("Teleop Time", 0.0).getEntry();
    public static NetworkTableEntry ldriveVelocity = tab.add("Left Motor Velocity", 0.0).getEntry();
    public static NetworkTableEntry rdriveVelocity = tab.add("Right Motor Velocity", 0.0).getEntry();
    public static ComplexWidget gyro = tab.add("Gyro", RobotContainer.m_Chassis.getGyro());
    

}
