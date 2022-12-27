package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Gripper.GripperSubsystem;

public class GripperCommand extends CommandBase {
    private GripperSubsystem gripper;
    private int i = 0;

    public GripperCommand(GripperSubsystem g) {
        gripper = g;
    }

    @Override
    public void initialize() {
        if (i == 0) {
            gripper.lock();
        } else if (i == 1) {
            gripper.release();
        }
    }

    @Override
    public void end(boolean interrupted) {
        if(i == 0){
            i++;
        } else {
            i = 0;
        }
    }
}

