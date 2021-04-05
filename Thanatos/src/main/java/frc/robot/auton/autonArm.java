package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class autonArm extends CommandBase {
    double speed;
    double time;
    
    Boolean isFinished = false;
    
    public autonArm(double speed, double time) {
        addRequirements(RobotContainer.m_Arm);

        Timer m_Timer = new Timer();

        this.speed = speed;
        this.time = time;

    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_Timer.start();

        while(m_Timer.get <= time) {
            RobotContainer.m_Arm.moveArm(speed);
        }

        isFinished = true;
    }

    @Override
    public Boolean isFinished() {
        return isFinished;
    }
}