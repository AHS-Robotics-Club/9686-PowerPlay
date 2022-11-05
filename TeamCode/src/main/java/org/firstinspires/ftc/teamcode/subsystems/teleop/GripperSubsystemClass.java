package org.firstinspires.ftc.teamcode.subsystems.teleop;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class GripperSubsystemClass extends SubsystemBase {
    private SimpleServo gripper;

    public GripperSubsystemClass(SimpleServo g){
        gripper = g;
    }

    public void close(){
        if(gripper != null)
            gripper.turnToAngle(45);
    }
    public void open(){
        if(gripper != null)
            gripper.turnToAngle(0);
    }
}
