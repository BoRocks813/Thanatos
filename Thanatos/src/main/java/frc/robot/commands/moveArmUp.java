// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class moveArmUp extends CommandBase {
  public Arm cArm;

  double targetPosition;
  double currentPosition;

  /** Creates a new moveArmUp. */
  public moveArmUp(Arm arm, double position) {
    // Use addRequirements() here to declare subsystem dependencies.
    cArm = arm;
    addRequirements(cArm);

    targetPosition = position;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cArm.canIPutMyBallzInYoJaws(targetPosition);   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
