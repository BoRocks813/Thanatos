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
  public static WPI_TalonFX rMotor = null; 
  public static WPI_TalonFX lMotor = null;
  
  public static DifferentialDrive diffDrive = null;

  public AHRS gyro = null;

  /** Creates a new Chassis. */
  public Chassis() {

    // Names the motors
    rMotor = new WPI_TalonFX(Constants.CHASSIS_RIGHT_MOTOR);
    lMotor = new WPI_TalonFX(Constants.CHASSIS_LEFT_MOTOR);

    gyro = new AHRS(SPI.Port.kMXP);

    rMotor.setNeutralMode(NeutralMode.Brake);
    lMotor.setNeutralMode(NeutralMode.Brake);
    
    diffDrive = new DifferentialDrive(lMotor, rMotor);
  }  

  public void driveChassis(double fwdSpeed, double rotAmt) {
    // Uses the "arcadeDrive" function to move the robot
     diffDrive.curvatureDrive(fwdSpeed, rotAmt, true);
  }

  public double getVelocityMeters(double sensorValue) {
    double motorRotations = sensorValue / 2048;
    double wheelRotations = motorRotations / Constants.gearRatio;
    double positionMeters = wheelRotations * (2 * Math.PI * Constants.wheelDiameter);
    return positionMeters;
  }

  @Override
  public void periodic() {
    Dashboard.ldriveVelocity.setDouble(
      lMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter);
    Dashboard.rdriveVelocity.setDouble(
      rMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter);
  }

  public AHRS getGyro() {
    return gyro;
  }
}
