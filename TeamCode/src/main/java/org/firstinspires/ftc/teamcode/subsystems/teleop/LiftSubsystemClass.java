package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class LiftSubsystemClass extends SubsystemBase {
    private Motor liftMotor;

    public LiftSubsystemClass(Motor lift){
        liftMotor = lift;
    }
    public void setZero(){
        if(liftMotor != null){
            liftMotor.setTargetPosition(0);
            while(!liftMotor.atTargetPosition()){
                liftMotor.set(0.5);
            }
            liftMotor.stopMotor();
        }

    }
    public void setLow(){
        if(liftMotor != null) {
            liftMotor.setTargetPosition(500);
            while(!liftMotor.atTargetPosition()){
                liftMotor.set(0.5);
            }
            liftMotor.stopMotor();
        }
    }
    public void setMedium(){
        if(liftMotor != null) {
            liftMotor.setTargetPosition(1000);
            while(!liftMotor.atTargetPosition()){
                liftMotor.set(0.5);
            }
            liftMotor.stopMotor();
        }
    }
    public void setHigh(){
        if(liftMotor != null) {
            liftMotor.setTargetPosition(2000);
            while(!liftMotor.atTargetPosition()){
                liftMotor.set(0.5);
            }
            liftMotor.stopMotor();
        }
    }
}
