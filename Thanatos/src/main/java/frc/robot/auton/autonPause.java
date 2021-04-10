// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class autonPause extends CommandBase {
  Timer m_Timer;
  double time;
  boolean isFinished = false;

  /** Creates a new autonPause. */
  public autonPause(double time) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Timer = new Timer();

    this.time = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(m_Timer.get() >= time) {
      isFinished = true;
    }

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
