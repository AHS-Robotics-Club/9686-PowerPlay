package org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Gripper;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class GripperSubsystem extends SubsystemBase {
    private SimpleServo gripper;

    public GripperSubsystem(SimpleServo g){
        gripper = g;
    }

    public void lock(){
        gripper.turnToAngle(45);
    }
    public void release(){
        gripper.turnToAngle(-45);
    }
}
