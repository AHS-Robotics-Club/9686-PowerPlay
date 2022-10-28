package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private GripperSubsystemClass gripperS;
    private LiftSubsystemClass liftS;

    public IntakeSubsystem(GripperSubsystemClass gS, LiftSubsystemClass lS){
        gripperS = gS;
        liftS = lS;
    }

    public void onInit(){
        gripperS.close();
        liftS.setZero();
    }
    public void raise(){
        liftS.setLow();
        gripperS.close();
    }
    public void descend(){
        gripperS.close();
        liftS.setZero();
        gripperS.open();
        liftS.setLow();
    }
    public void levelUp(int index){
        gripperS.open();
        if(index == 0){
            liftS.setMedium();
        } else {
            liftS.setHigh();
        }
    }
    public void release(){
        gripperS.close();
        liftS.setZero();
    }

}
