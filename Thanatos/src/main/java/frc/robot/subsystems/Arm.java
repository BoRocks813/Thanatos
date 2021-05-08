// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Dashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Arm extends SubsystemBase {
  private static WPI_TalonFX motor;

  double motorPosition;

  /** Creates a new Arm. */
  public Arm() {
    // Sets the motor for the arm
    motor = new WPI_TalonFX(Constants.ARM_MOTOR);

    motor.config_kP(0, 1.0);
    motor.config_kI(0, 0);
    motor.config_kD(0, 0.2);

    motor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    motor.setSelectedSensorPosition(0);

    motor.setNeutralMode(NeutralMode.Brake);
    motor.configPeakOutputForward(1.00);
    motor.configPeakOutputReverse(-1.00);

    motor.setInverted(TalonFXInvertType.CounterClockwise);
  }

  public double getPosition() {
    return motorPosition;
  }

  @Override
  public void periodic() {
    motorPosition = motor.getSelectedSensorPosition();
    Dashboard.armPosition.setDouble(motorPosition);
  }

  // Moves the arm
  public void moveArm(double speed) {
    motor.set(speed);
  }

  public WPI_TalonFX getMotor() {
    return motor;
  }

  public void canIPutMyBallzInYoJaws(double position) {
    motor.set(ControlMode.Position, position);
  }
}
