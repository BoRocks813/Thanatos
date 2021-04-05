// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Arm extends SubsystemBase {
  WPI_TalonFX motor = null;

  /** Creates a new Arm. */
  public Arm() {
    // Sets the motor for the arm
    motor = new WPI_TalonFX(Constants.ARM_MOTOR);
  }

  // Moves the arm
  public void moveArm(double speed) {
    motor.set(speed);
  }
}
