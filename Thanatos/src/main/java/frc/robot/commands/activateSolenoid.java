// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class activateSolenoid extends CommandBase {
  /** Creates a new activateSolenoid. */
  public activateSolenoid() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Solenoid);
  }
  boolean isCalled = false;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_Solenoid.startSolenoid();
    isCalled = true;
  }

  @Override
  public boolean isFinished() {
    return isCalled;
  }

}
