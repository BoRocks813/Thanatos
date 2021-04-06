// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class chassisDrive extends CommandBase {
  /** Creates a new chassisDrive. */
  public chassisDrive() {
    // adds a subsystem dependency
    addRequirements(RobotContainer.m_Chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Sets the controller inputs to variables so they can be used easier

    double moveSpeed = Constants.linearDriveSense * RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = Constants.lateralDriveSense * RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_ROTATE_AXIS);

    // Calls the "driveChassis" command with the controller inputs as the commands
    RobotContainer.m_Chassis.driveChassis(moveSpeed, rotateSpeed);
  }

}


