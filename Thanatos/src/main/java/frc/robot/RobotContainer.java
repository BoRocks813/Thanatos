// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.auton.*;

// This is where the bulk of the robot is declared
public class RobotContainer {
  // Instantiates the Chassis
  public final static Chassis m_Chassis = new Chassis();

  // Instantiates the Controller
  public static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  // Instantiates the Arm
  public final static Arm m_Arm = new Arm();

  // Instantiates the autonomous commands
  private final SequentialCommandGroup autonCommands = new autonCommands(m_Chassis);

  // Creates the RobotContainer
  public RobotContainer() {
    // Configures the button bindings
    // B resets the gyro (if using a navx)
    configureButtonBindings();

    // Sets it so that the Chassis will drive in response to the controller by default
    m_Chassis.setDefaultCommand(new chassisDrive(m_Chassis));
  }

  // Configures
  private void configureButtonBindings() {
    // Instantiates the B button on the Xbox controller
    JoystickButton bButton = new JoystickButton(driverController, XboxController.Button.kB.value);

    // Sets it so that when the B button is pressed, the gyro resets
    bButton.whenPressed(new resetGyro(m_Chassis));
  }

  // Gets the auton commands
  public Command getAutonCommand() {
    return autonCommands;
  }

}
