package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class autonArm extends CommandBase {
    private final double position;

    private final WPI_TalonFX motor;
    
    private final Arm m_Arm;
    
    public autonArm(double position, Arm cArm) {
        m_Arm = cArm;
        
        addRequirements(m_Arm);

        this.position = position;

        motor = m_Arm.getMotor();
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return motor.getSelectedSensorPosition() == position;
    }
}