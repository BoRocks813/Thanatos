package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;

public class Dashboard {
    public static ShuffleboardTab tab = Shuffleboard.getTab("Main");

    public static NetworkTableEntry rMotorSpeed = tab.add("Right Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry lMotorSpeed = tab.add("Left Motor Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveSpeed = tab.add("Drive Speed", 0.0).getEntry();
    public static NetworkTableEntry diffDriveRotate = tab.add("Drive Rotate", 0.0).getEntry();

}
