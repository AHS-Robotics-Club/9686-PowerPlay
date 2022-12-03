package org.firstinspires.ftc.teamcode.subsystems.teleop.Testing;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class PController extends SubsystemBase {
    private Motor testMotor;
    private double kP = 1.0;

    public PController(Motor m, double kP){
        testMotor = m;
        this.kP = kP;
    }

    public void runToPos(int pos, double tolerance){
        double output;

        com.arcrobotics.ftclib.controller.PController posCtrl = new com.arcrobotics.ftclib.controller.PController(kP);

        posCtrl.setSetPoint(pos);
        posCtrl.setTolerance(tolerance);

        while(!posCtrl.atSetPoint()){
            output = posCtrl.calculate(testMotor.getCurrentPosition());
            testMotor.set(output);
        }
        testMotor.stopMotor();
    }
}
