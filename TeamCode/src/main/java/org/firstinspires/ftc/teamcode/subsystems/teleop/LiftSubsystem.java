package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class LiftSubsystem extends SubsystemBase {
    private Motor liftMotor;
    private double motorConstant = 1;
    private int level = 0;

    public LiftSubsystem(Motor lM){
        liftMotor = lM;
    }

    public void runSlow(){
        if(liftMotor != null)
            liftMotor.set(motorConstant / 5);
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
            liftMotor.set(-motorConstant / 5);
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
