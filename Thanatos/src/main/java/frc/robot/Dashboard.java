// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class Dashboard {
    public static boolean autonOn = false;

    public void execute() {
        SmartDashboard.putBoolean("autonOn", autonOn);
        
    }
}
