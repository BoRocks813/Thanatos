package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Dashboard {
    public static void main(String[] args) {
        new Dashboard().run();    
    }

    public void run() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();

        NetworkTable otherTable = inst.getTable("main");

        NetworkTableEntry main = otherTable.getEntry("test");

        main.setValue("The test worked.");
    }

}
