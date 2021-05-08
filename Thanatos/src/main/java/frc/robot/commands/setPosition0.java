// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class setPosition0 extends InstantCommand {
  Arm cArm;
  WPI_TalonFX motor;
  public setPosition0(Arm arm) {
    cArm = arm;
    addRequirements(cArm);
    motor = cArm.getMotor();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motor.setSelectedSensorPosition(0);
  }
}
