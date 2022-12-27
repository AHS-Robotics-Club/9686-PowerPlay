package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Gripper.GripperSubsystem;

public class GripperReleaseCommand extends CommandBase {
    private GripperSubsystem gripper;

    public GripperReleaseCommand(GripperSubsystem gS){
        gripper = gS;
    }

    @Override
    public void initialize() {
        gripper.release();
    }
}
