// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends SubsystemBase {
  // Initializes the motor variables
  WPI_TalonFX rMotor = null; 
  WPI_TalonFX lMotor = null;

  DifferentialDrive diffDrive = null;

  /** Creates a new Chassis. */
  public Chassis() {

    // Names the motors
    rMotor = new WPI_TalonFX(Constants.CHASSIS_RIGHT_MOTOR);
    lMotor = new WPI_TalonFX(Constants.CHASSIS_LEFT_MOTOR); 
  }

  public void driveChassis(double fwdSpeed, double rotAmt) {
    // Uses the "arcadeDrive" function to move the robot
     diffDrive.arcadeDrive(fwdSpeed, rotAmt);
  }

  
}
