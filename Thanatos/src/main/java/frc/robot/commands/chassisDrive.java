// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
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

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Sets the controller inputs to variables so they can be used easier

    double moveSpeed = 0.2*Constants.linearDriveSense * RobotContainer.driverController.getRawAxis(1);
    double rotateSpeed = 0.2*Constants.lateralDriveSense * RobotContainer.driverController.getRawAxis(4);

    // Calls the "driveChassis" command with the controller inputs as the commands
    cChassis.driveChassis(moveSpeed, rotateSpeed);
  }

}


