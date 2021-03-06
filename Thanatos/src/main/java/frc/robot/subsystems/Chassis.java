// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Dashboard;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; 
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends SubsystemBase {
  // Initializes the motor variables
  private final WPI_TalonFX rMotor; 
  private final WPI_TalonFX lMotor;

  // Initializes the differential drive
  private final DifferentialDrive diffDrive;

  // Initializes the gyro (if we use one)
  private final AHRS gyro;

  // Creates a new chassis
  public Chassis() {

    // Instantiates the motors
    rMotor = new WPI_TalonFX(Constants.CHASSIS_RIGHT_MOTOR);
    lMotor = new WPI_TalonFX(Constants.CHASSIS_LEFT_MOTOR);

    // Sets the motors to brake by default, removing drifting

    // Instantiates the gyro
    gyro = new AHRS(SPI.Port.kMXP);

    // Instantiates the differential drive
    diffDrive = new DifferentialDrive(lMotor, rMotor);
  }

  // The method used to drive the chassis
  public void driveChassis(double fwdSpeed, double rotAmt) {
    // Uses curvature drive to move the robot
    diffDrive.curvatureDrive(fwdSpeed, rotAmt, true);
  }

  // Should get the velocity in meters/second if I did the math right
  // Most likely gives you a random number :)
  public double getVelocityMeters(double sensorValue) {
    double motorRotations = sensorValue / 2048;
    double wheelRotations = motorRotations / Constants.gearRatio;
    double positionMeters = wheelRotations * (2 * Math.PI * Constants.wheelDiameter);
    return positionMeters;
  }

  // Updates the velocity variables
  @Override
  public void periodic() {
    Dashboard.ldriveVelocity.setDouble(
        lMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter);
    Dashboard.rdriveVelocity.setDouble(
        rMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter);

    Dashboard.lMotorSpeed.setDouble(lMotor.get());
    Dashboard.rMotorSpeed.setDouble(rMotor.get());

    lMotor.feed();
    rMotor.feed();      
    diffDrive.feed();
    diffDrive.feedWatchdog();
  }

  public void disengageBrake() {
    lMotor.setNeutralMode(NeutralMode.Coast);
    rMotor.setNeutralMode(NeutralMode.Coast);
  }

  public void enableBrake() {
    lMotor.setNeutralMode(NeutralMode.Brake);
    rMotor.setNeutralMode(NeutralMode.Brake);
  }

  // A method to get the gyro
  public AHRS getGyro() {
    return gyro;
  }

}
