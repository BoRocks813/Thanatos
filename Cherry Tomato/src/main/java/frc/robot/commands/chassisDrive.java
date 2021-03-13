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
    double moveSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = RobotContainer.driverController.getRawAxis(Constants.DRIVER_CONTROLLER_ROTATE_AXIS);

    // Calls the "driveChassis" command with the controller inputs as the commands
    RobotContainer.m_Chassis.driveChassis(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Sets the engine to 0 to brake and avoid drifting
    RobotContainer.m_Chassis.driveChassis(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // We don't use this as this command is used to drive the robot and ends when tele-op is turned off
    return false;
  }
}
