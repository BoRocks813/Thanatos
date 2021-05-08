package frc.robot.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class autonArm extends CommandBase {    
    private final Arm m_Arm;

    private final Timer m_Timer;

    private final double amtTime;

    private final double speed;
    
    public autonArm(double speed, Arm cArm, double time) {
        m_Arm = cArm;
        
        amtTime = time;
        
        m_Timer = new Timer();

        addRequirements(m_Arm);

        this.speed = speed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_Arm.moveArm(speed);
    }

    @Override
    public boolean isFinished() {
        return m_Timer.get() > amtTime;
    }
}