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

/*

File 1

The RobotContainer class is where the bulk of the robot's functions and subsystems are managed in the
command-based model.

 */

// The import statements above tell WPILib (the library we use) as well as the proprietary motor libraries
// which files we will be using. We do this to reduce the amount of material we want to import to only the
// things we need to use.

public class RobotContainer {

  // The first thing we do is create instances of our subsystems. This creates objects with the properties
  // defined in the subsystem classes. We can then give these objects properties and use commands on them.

  // Creates a "Chassis" object. The chassis controls the wheels and drives the robot. We feed all of the
  // drive inputes to this object.
  public final static Chassis m_Chassis = new Chassis();

  // Creates an "XboxController" object. This object allows us to get all of the inputs from the controller
  // which we then feed to the robot. When defining an XboxController object, we need to give it a port number
  // The port number can be found in the driver station when the controller is connected and usually defaults
  // to 0. We keep this value in the Constants class. This class allows us to keep all of our variable values
  // in one place so we can easily access and change them if necessary.
  private final static XboxController driverController = new XboxController(Constants.DRIVER_CONTROLLER);

  // Creates an "Arm" object. The robot this code was originally for had an intake attached to an arm that would
  // rotate up and down.
  private final Arm m_Arm = new Arm();

  // Creates a grouping of autonCommands. The use of SequentialCommandGroup will be explained later.
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
  public Command getAutonCommands() {
    return autonCommands;
  }

  public Chassis getChassis() {
    return m_Chassis;
  }

  public static XboxController getController() {
    return driverController;
  }
}
