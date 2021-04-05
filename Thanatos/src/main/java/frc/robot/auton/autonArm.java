package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class autonArm extends CommandBase {
    double moveSpeed;
    double time;
    
    public autonArm(double speed, double time) {
        
        moveSpeed = speed;
        this.time = time;
    }
}
