package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Dashboard extends TimedRobot {
    NetworkTableEntry main;

    public void robotInit() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();

        NetworkTable otherTable = inst.getTable("main");

        main = otherTable.getEntry("test");
    }

    public void teleopPeriodic() {
        main.setValue("The test worked.");
    }
}
