package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj.Timer;

public class autonDrive extends CommandBase {

    double driveSpeed;
    double rotateSpeed;
    double time;

    Chassis chassis;

    Timer m_Timer;

    boolean isFinished = false;
    
    public autonDrive(double speed, double rotate, double amtTime, Chassis chassis) {

        m_Timer = new Timer();

        driveSpeed = speed;
        rotateSpeed = rotate;
        time = amtTime;
        this.chassis = chassis;
    }

    @Override
    public void initialize() {
        m_Timer.reset();
        m_Timer.start();
    }

    @Override
    public void execute() {
        chassis.driveChassis(driveSpeed, rotateSpeed);
    

        if(m_Timer.get() >= time) {
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}
