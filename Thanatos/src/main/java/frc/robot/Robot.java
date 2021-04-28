// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.cscore.HttpCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

// This class automatically runs
public class Robot extends TimedRobot {
  // Initializes variable that will hold the auton commands
  private Command m_autonomousCommand;

  // Initializes the Robot Container
  private RobotContainer m_robotContainer;

  // Uncomment when the limelight is ready
  // private HttpCamera limeLightFeed;

  // Called when the robot starts up
  @Override
  public void robotInit() {
    // Stores the Robot Container
    m_robotContainer = new RobotContainer();

    // Uncomment when the limelight is in place
    /*
     * limeLightFeed = new HttpCamera("limelight",
     * "http://limelight.local:5800/stream.mjpg"); Dashboard.tab.add("LL",
     * limeLightFeed).withPosition(0, 0).withSize(15, 8);
     */
  }

  // Called periodically while the robot is active
  @Override
  public void robotPeriodic() {
    // This runs the command scheduler which is responsible for timing out all of the commands
    // Do not remove this line of code
    CommandScheduler.getInstance().run();
  }

  // Called when the robot enters disabled mode
  @Override
  public void disabledInit() {}

  // Called periodically during disabled mode
  @Override
  public void disabledPeriodic() {}

  // Runs the auton commands
  @Override
  public void autonomousInit() {
    // Stores the auton commands
    m_autonomousCommand = m_robotContainer.getAutonCommand();

    // If there are auton commands, this will schedule them
    // If not it will print a helpful message
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    } else {
      System.out.println("no.");
    }
  }

  // Called periodically during auton
  @Override
  public void autonomousPeriodic() {}

  // Called at the beginning of teleop
  @Override
  public void teleopInit() {
    // This will cancel the currently running auton command
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

  }

  // Called periodically during teleop
  @Override
  public void teleopPeriodic() {}

  // Called at the beginning of test mode
  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  // Called periodically during test mode
  @Override
  public void testPeriodic() {}
}
