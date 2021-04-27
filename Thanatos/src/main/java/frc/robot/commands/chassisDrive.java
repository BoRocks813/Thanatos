// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Dashboard;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;

public class chassisDrive extends CommandBase {

  Chassis cChassis;

  /** Creates a new chassisDrive. */
  public chassisDrive(Chassis chassis) {
    cChassis = chassis;
    // adds a subsystem dependency
    addRequirements(cChassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called periodically while the command is active
  @Override
  public void execute() {
    // Sets the speeds of movement and rotation to inputs from the controller
    double moveSpeed = -Constants.linearDriveSense * RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = Constants.lateralDriveSense * RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_ROTATE_AXIS);

    // Updates the values on the dashboard
    Dashboard.diffDriveRotate.setDouble(rotateSpeed);
    Dashboard.diffDriveSpeed.setDouble(moveSpeed);
    Dashboard.lMotorSpeed.setDouble(Chassis.lMotor.get());
    Dashboard.rMotorSpeed.setDouble(Chassis.rMotor.get());


    // Calls the "driveChassis" command with the controller inputs as the commands
    cChassis.driveChassis(moveSpeed, rotateSpeed);
  }

}


