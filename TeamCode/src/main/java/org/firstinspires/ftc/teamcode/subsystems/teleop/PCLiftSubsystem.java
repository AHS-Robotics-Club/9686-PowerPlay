package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;

public class PCLiftSubsystem extends SubsystemBase {
    private LiftMotorGroup liftMotors;
    private final int zero = 0;
    private final int vLow = 20;
    private final int low = 35;
    private final int medium = 50;
    private final int high = 65;
    private final int vHigh = 80;

    public PCLiftSubsystem(LiftMotorGroup lmg) {
        liftMotors = lmg;
    }

    public void goToZero(){
        if(liftMotors != null){
            liftMotors.setTargetPosition(zero);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(-0.5);
            }
            liftMotors.stopMotor();
        }
    }

    public void setPosVeryLow(){
        if(liftMotors != null) {
            liftMotors.setTargetPosition(vLow);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(0.5);
            }
            liftMotors.stopMotor();
        }
    }

    public void setPosLow(){
        if(liftMotors != null) {
            liftMotors.setTargetPosition(low);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(0.5);
            }
            liftMotors.stopMotor();
        }
    }

    public void setPosMedium(){
        if(liftMotors != null) {
            liftMotors.setTargetPosition(medium);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(0.5);
            }
            liftMotors.stopMotor();
        }
    }

    public void setPosHigh(){
        if(liftMotors != null) {
            liftMotors.setTargetPosition(high);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(0.5);
            }
            liftMotors.stopMotor();
        }
    }

    public void setPosVeryHigh(){
        if(liftMotors != null) {
            liftMotors.setTargetPosition(vHigh);
            while (!liftMotors.atTargetPosition()) {
                liftMotors.set(0.5);
            }
            liftMotors.stopMotor();
        }
    }
}

