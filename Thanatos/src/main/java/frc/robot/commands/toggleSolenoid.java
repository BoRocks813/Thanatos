// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class toggleSolenoid extends CommandBase {
  /** Creates a new toggleSolenoid. */
  public toggleSolenoid() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Solenoid);
  }
  boolean isCalled = false;
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (RobotContainer.m_Solenoid.get() == true) {
      RobotContainer.m_Solenoid.stopSolenoid();
      isCalled = true;
    } else if (RobotContainer.m_Solenoid.get() == false) {
      RobotContainer.m_Solenoid.startSolenoid();
      isCalled = true;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isCalled;
  }
}
