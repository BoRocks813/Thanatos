// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class moveArm extends CommandBase {
  double fwdSpeed;
  double bckSpeed;
  double speed;

  double currentPosition;

  Arm cArm;
  /** Creates a new moveArm. */
  public moveArm(Arm arm) {
    // Use addRequirements() here to declare subsystem dependencies.
    cArm = arm;

    addRequirements(cArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentPosition = cArm.getPosition();

    fwdSpeed = Constants.moveArmSense * RobotContainer.getController().getRawAxis(Constants.RIGHT_TRIGGER_AXIS);
    bckSpeed = Constants.moveArmSense * RobotContainer.getController().getRawAxis(Constants.LEFT_TRIGGER_AXIS);

    speed = fwdSpeed - bckSpeed;

    cArm.moveArm(speed);

    // if (currentPosition >= Constants.armLower && currentPosition <= Constants.armUpper) {
    //   cArm.moveArm(speed);
    // } else if (currentPosition < Constants.armLower) {
    //   Arm.canIPutMyBallzInYoJaws(20);
    // } else if (currentPosition > Constants.armUpper) {
    //   cArm.canIPutMyBallzInYoJaws(480);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
}
