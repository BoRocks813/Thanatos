package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class autonArm extends CommandBase {
    double position;

    Boolean isFinished = false;

    WPI_TalonFX motor = RobotContainer.m_Arm.getMotor();
    
    public autonArm(double position) {
        addRequirements(RobotContainer.m_Arm);

        this.position = position;

    }

    @Override
    public void initialize() {
        motor.setSelectedSensorPosition(position);
    }

    @Override
    public void execute() {}

    @Override
    public boolean isFinished() {
        return motor.getSelectedSensorPosition() == position;
    }
}