package org.firstinspires.ftc.teamcode.subsystems.teleop.Testing;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class TestPosControl extends SubsystemBase {
    private Motor testMotor;
    private double kP, tolerance;

    public TestPosControl(Motor m, double posCoeff, double tolerance){
        testMotor = m;
        kP = posCoeff;
        this.tolerance = tolerance;
    }

    public TestPosControl(Motor m){
        this(m, 1, 1);
    }

    public TestPosControl(Motor m, double posCoeff){
        this(m, posCoeff, 1);
    }

    public void runToPos(int pos){
        testMotor.setTargetPosition(pos);

        testMotor.setPositionCoefficient(kP);
        testMotor.setPositionTolerance(tolerance);

        while(!testMotor.atTargetPosition()){
            testMotor.set(0.75);
        }
        testMotor.stopMotor();
    }
}
