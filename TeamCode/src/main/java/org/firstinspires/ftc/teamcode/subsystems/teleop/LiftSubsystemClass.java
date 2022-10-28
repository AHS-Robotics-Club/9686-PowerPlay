package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class LiftSubsystemClass extends SubsystemBase {
    private Motor leftLift, rightLift;

    public LiftSubsystemClass(Motor ll, Motor rl){
        leftLift = ll;
        rightLift = rl;
    }

    public void setZero(){
        leftLift.setTargetPosition(0);
        rightLift.setTargetPosition(0);
    }
    public void setLow(){
        leftLift.setTargetPosition(500);
        rightLift.setTargetPosition(500);
    }
    public void setMedium(){
        leftLift.setTargetPosition(1000);
        rightLift.setTargetPosition(1000);
    }
    public void setHigh(){
        leftLift.setTargetPosition(2000);
        rightLift.setTargetPosition(2000);
    }
}
