// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

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
    double fwdSpeed = Constants.moveArmSense * RobotContainer.driverController.getTriggerAxis(Hand.kRight);
    double bckSpeed = Constants.moveArmSense * RobotContainer.driverController.getTriggerAxis(Hand.kLeft);

    double moveSpeed = fwdSpeed - bckSpeed;

    // This code may not work:
    WPI_TalonFX motor = RobotContainer.m_Arm.getMotor();

    if(motor.getSelectedSensorPosition() >= Constants.armLower && motor.getSelectedSensorPosition() <= Constants.armUpper) {
      RobotContainer.m_Arm.moveArm(moveSpeed);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Arm.moveArm(0.0);
  }
}
