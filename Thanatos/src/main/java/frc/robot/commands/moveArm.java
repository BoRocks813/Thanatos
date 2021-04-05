// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class moveArm extends CommandBase {
  /** Creates a new moveArm. */
  public moveArm() {
    // Sets the arm as the subsystem
    addRequirements(RobotContainer.m_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called on repeat
  @Override
  public void execute() {
    // Sets the triggers for the command
    double fwdSpeed = RobotContainer.driverController.getTriggerAxis(Hand.kRight);
    double bckSpeed = -RobotContainer.driverController.getTriggerAxis(Hand.kLeft);

    // This code may not work:

    // Moves the arm according to the axis of the triggers (R=fwd, L=bckwd)
    if(fwdSpeed == 0.0) {
      while(bckSpeed != 0.0) {
       RobotContainer.m_Arm.moveArm(bckSpeed);
      }
    } else if(bckSpeed == 0.0) {
      while(fwdSpeed != 0.0) {
        RobotContainer.m_Arm.moveArm(fwdSpeed);
      }
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Arm.moveArm(0.0);
  }
}
