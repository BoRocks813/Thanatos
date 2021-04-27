// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Chassis;

public class resetGyro extends InstantCommand {
  Chassis chassis;

  /** Creates a new resetGyro. */
  public resetGyro(Chassis chassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.chassis = chassis;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    chassis.getGyro().reset();
  }
}
