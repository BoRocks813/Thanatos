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
  private final static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  // Instantiates the Arm
  private final Arm m_Arm = new Arm();

  // Instantiates the autonomous commands
  private final SequentialCommandGroup autonCommands = new autonCommands(m_Chassis, m_Arm);

  // Creates the RobotContainer
  public RobotContainer() {
    // Configures the button bindings
    // B resets the gyro (if using a navx)
    configureButtonBindings();

    // Sets it so that the Chassis will drive in response to the controller by default
    m_Chassis.setDefaultCommand(new chassisDrive(m_Chassis));

    // Sets it so that the arm will move in response to the controller by default
    m_Arm.setDefaultCommand(new moveArm(m_Arm));
  }

  // Configures
  private void configureButtonBindings() {
    // Instantiates the B button on the Xbox controller
    JoystickButton xButton = new JoystickButton(driverController, XboxController.Button.kX.value);
    JoystickButton bButton = new JoystickButton(driverController, XboxController.Button.kB.value);
    JoystickButton aButton = new JoystickButton(driverController, XboxController.Button.kA.value);
    JoystickButton yButton = new JoystickButton(driverController, XboxController.Button.kY.value);

    JoystickButton rBumper = new JoystickButton(driverController, XboxController.Button.kBumperRight.value);
    JoystickButton lBumper = new JoystickButton(driverController, XboxController.Button.kBumperLeft.value);
    

    // Sets it so that when the B button is pressed, the gyro resets
    

    if (Constants.driver == 2) {
      aButton.whileHeld(new moveArmAtSpeed(0.1, m_Arm));
      bButton.whileHeld(new moveArmAtSpeed(-0.1, m_Arm));
      xButton.whenPressed(new yesBrake(m_Chassis));
      yButton.whenPressed(new noBrake(m_Chassis));
    } else {
      rBumper.whileHeld(new moveArmAtSpeed(0.1, m_Arm));
      lBumper.whileHeld(new moveArmAtSpeed(-0.1, m_Arm));
      bButton.whenPressed(new yesBrake(m_Chassis));
      aButton.whenPressed(new noBrake(m_Chassis));
      yButton.whenPressed(new noBrake(m_Chassis));
    }
    
  }

  public static Command getFirstBrake() {
    return new yesBrake(m_Chassis);
  }

  // Gets the auton commands
  public Command getAutonCommand() {
    return autonCommands;
  }

  public Chassis getChassis() {
    return m_Chassis;
  }

  public static XboxController getController() {
    return driverController;
  }
}
