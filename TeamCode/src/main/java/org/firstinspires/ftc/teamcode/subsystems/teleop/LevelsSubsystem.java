package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;

public class LevelsSubsystem extends SubsystemBase {
    private PCLiftSubsystem lifts;
    private GripperSubsystem gripper;

    public LevelsSubsystem(PCLiftSubsystem lifts, GripperSubsystem gripper){
        this.lifts = lifts;
        this.gripper = gripper;
    }

    public void setPosition(Positions position){
        switch(position){
            case INIT:
                setZero();
                break;
            case PICKUP:
                pickCone();
                break;
            case RAISE:
                raise();
                break;
            case LEVEL1:
                setLevel1();
                break;
            case LEVEL2:
                setLevel2();
                break;
            case LEVEL3:
                setLevel3();
                break;
            case DROP:
                drop();
                break;
        }
    }

    public void setZero(){
        if(lifts != null)
            lifts.goToZero();
        if(gripper != null)
            gripper.release();
    }

    private void pickCone(){
        if(lifts != null)
            lifts.goToZero();
        if(gripper != null)
            gripper.lock();
    }

    private void raise(){
        if(lifts != null)
            lifts.setPosLow();
        if(gripper != null)
            gripper.lock();
    }

    private void setLevel1(){
        if(lifts != null)
            lifts.setPosMedium();
        if(gripper != null)
            gripper.lock();
    }

    private void setLevel2(){
        if(lifts != null)
            lifts.setPosHigh();
        if(gripper != null)
            gripper.lock();
    }

    private void setLevel3(){
        if(lifts != null)
            lifts.setPosVeryHigh();
        if(gripper != null)
            gripper.lock();
    }

    private void drop(){
        if(gripper != null)
            gripper.release();
        if(lifts != null)
            lifts.goToZero();
    }
}

