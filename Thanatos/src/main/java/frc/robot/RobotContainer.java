// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.commands.*;
import frc.robot.subsystems.SolenoidMain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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

  public final static SolenoidMain m_Solenoid = new SolenoidMain();

  public final static Arm m_Arm = new Arm();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings (See function below)
    configureButtonBindings();

    // Sets the default command for the chassis
    m_Chassis.setDefaultCommand(new chassisDrive());
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Add the button bindings here
    JoystickButton buttonA = (JoystickButton) new JoystickButton(driverController, XboxController.Button.kA.value);
    JoystickButton buttonB = (JoystickButton) new JoystickButton(driverController, XboxController.Button.kB.value);

    buttonA.whenPressed(new activateSolenoid());
    buttonB.whenPressed(new disengageSolenoid());
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

    Command com1 = new autonDrive(1.0, 0.0, 3.0);
    Command com2 = new autonDrive(0.5, 1.0, 1.0);
    Command com3 = new activateSolenoid();
    Command com4 = new autonDrive(0.5, 0.0, 1.0);
    Command com5 = new disengageSolenoid();
    Command com6 = new autonArm(10);
    Command com7 = new autonDrive(0.8, 0.0, 2.0);
    Command com8 = new autonPause(2.0);

    autonCommands.add(com1);
    autonCommands.add(com2);
    autonCommands.add(com3);
    autonCommands.add(com4);
    autonCommands.add(com8);
    autonCommands.add(com5);
    autonCommands.add(com6);
    autonCommands.add(com7);


    return autonCommands;
  }
}
