package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class autonDrive extends CommandBase {

    double driveSpeed;
    double rotateSpeed;
    double time;
    Timer m_Timer;
    
    public autonDrive(double speed, double rotate, double amtTime) {
        addRequirements(RobotContainer.m_Chassis);

        m_Timer = new Timer();

        driveSpeed = speed;
        rotateSpeed = rotate;
        time = amtTime;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        m_Timer.start();

        while(m_Timer.get() != time) {
            RobotContainer.m_Chassis.driveChassis(driveSpeed, rotateSpeed);
        }
    }

}
