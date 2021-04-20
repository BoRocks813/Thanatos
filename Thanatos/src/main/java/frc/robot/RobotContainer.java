// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.ArrayList;
import frc.robot.auton.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final static Chassis m_Chassis = new Chassis();

  public static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  public final static Arm m_Arm = new Arm();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings (See function below)
    configureButtonBindings();

    // Sets the default command for the chassiss
    m_Chassis.setDefaultCommand(new chassisDrive(m_Chassis));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Add the button bindings here
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public ArrayList<Command> getAutonomousCommands() {
    ArrayList<Command> autonCommands = new ArrayList<Command>();

    // Add auton commands here and make sure to add them to autonCommands
    // Below is an example

    autonCommands.add(new autonDrive(2.0, 0.0, 1.0, m_Chassis));

    return autonCommands;
  }
}
