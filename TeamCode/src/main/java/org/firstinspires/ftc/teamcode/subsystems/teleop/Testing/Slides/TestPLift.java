package org.firstinspires.ftc.teamcode.subsystems.teleop.Testing.Slides;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftMotorGroup;

public class TestPLift extends SubsystemBase {
    private LiftMotorGroup lifts;

    private double kP = 1.0;

    public TestPLift(LiftMotorGroup lm, double p){
        lifts = lm;
        kP = p;
    }

    public void runToPos(int pos, double tolerance){
        double output;

        com.arcrobotics.ftclib.controller.PController posCtrl = new com.arcrobotics.ftclib.controller.PController(kP);

        posCtrl.setSetPoint(pos);
        posCtrl.setTolerance(tolerance);

        while(!posCtrl.atSetPoint()){
            output = posCtrl.calculate(lifts.getCurrentPosition());
            lifts.set(output);
        }
        lifts.stopMotor();
    }

}
