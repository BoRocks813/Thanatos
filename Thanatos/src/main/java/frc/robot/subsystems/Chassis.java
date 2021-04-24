// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;


public class Chassis extends SubsystemBase {
  // Initializes the motor variables
  public static WPI_TalonFX rMotor = null; 
  public static WPI_TalonFX lMotor = null;

  Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);

  DifferentialDrive diffDrive = null;

  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Constants.trackWidthMeters);
  DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(getHeading());

  Pose2d pose;

  SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(Constants.physicsLabkS, Constants.physicsLabkV, Constants.physicsLabkA);

  /** Creates a new Chassis. */
  public Chassis() {

    // Names the motors
    rMotor = new WPI_TalonFX(Constants.CHASSIS_RIGHT_MOTOR);
    lMotor = new WPI_TalonFX(Constants.CHASSIS_LEFT_MOTOR);
    
    diffDrive = new DifferentialDrive(lMotor, rMotor);
  }

  public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(-gyro.getAngle());
  }

  

  public void driveChassis(double fwdSpeed, double rotAmt) {
    // Uses the "arcadeDrive" function to move the robot
     diffDrive.curvatureDrive(fwdSpeed, rotAmt, true);
  }

  @Override
  public void periodic() {
    pose = odometry.update(getHeading(), getLMotorSpeed(), getRMotorSpeed());
  }

  public double getLMotorSpeed() {
    return lMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter;
  }
  
  public double getRMotorSpeed() {
    return rMotor.getSelectedSensorVelocity() / 2048 * 1000 / Constants.gearRatio * Math.PI * Constants.wheelDiameter;
  }

}
