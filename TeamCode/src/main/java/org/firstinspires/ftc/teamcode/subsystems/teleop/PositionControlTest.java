package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class PositionControlTest extends SubsystemBase {
    private Motor posCtrlMotor;

    public PositionControlTest(Motor m){
        posCtrlMotor = m;
    }

    public void runToPos(int pos){
        posCtrlMotor.setTargetPosition(pos);
        while(!posCtrlMotor.atTargetPosition()){
            posCtrlMotor.set(0.5);
        }
        posCtrlMotor.stopMotor();
    }
}
