package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LiftMotorGroup;

public class LiftSubsystem extends SubsystemBase {
    private LiftMotorGroup liftMotor;
    private double motorConstant = 1;

    public LiftSubsystem(LiftMotorGroup lM){
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
            liftMotor.set(-motorConstant / 2);
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
