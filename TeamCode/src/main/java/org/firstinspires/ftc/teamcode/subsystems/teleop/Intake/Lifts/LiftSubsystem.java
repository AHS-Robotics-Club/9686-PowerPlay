package org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts;

import com.arcrobotics.ftclib.command.SubsystemBase;

public class LiftSubsystem extends SubsystemBase {
    private LiftMotorGroup liftMotor;
    private double motorConstant = 0.5;

    public LiftSubsystem(LiftMotorGroup lM){
        liftMotor = lM;
    }

    public void runSlow(){
        if(liftMotor != null)
            liftMotor.set(0.1);
    }

    public void runNormal(){
        if(liftMotor != null)
            liftMotor.set(motorConstant);
    }

    public void runTurbo(){
        if(liftMotor != null)
            liftMotor.set(motorConstant * 2);
    }

    public void runSlowReverse(){
        if(liftMotor != null)
            liftMotor.set(-0.1);
    }

    public void runNormalReverse(){
        if(liftMotor != null)
            liftMotor.set(-motorConstant);
    }

    public void stopMotor(){
        if(liftMotor != null)
            liftMotor.stopMotor();
    }

}
