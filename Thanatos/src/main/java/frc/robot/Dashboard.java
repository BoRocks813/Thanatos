package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Dashboard extends TimedRobot {
    NetworkTableEntry time;

    public void robotInit() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();

        NetworkTable otherTable = inst.getTable("other");

        time = otherTable.getEntry("time");
    }

    public void teleopPeriodic() {
        time.setNumber(Robot.teleopTime);
    }
}
