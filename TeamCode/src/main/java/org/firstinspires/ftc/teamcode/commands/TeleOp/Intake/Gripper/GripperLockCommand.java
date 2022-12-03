package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Gripper.GripperSubsystem;

public class GripperLockCommand extends CommandBase {
    private GripperSubsystem gripper;

    public GripperLockCommand(GripperSubsystem gS){
        gripper = gS;
    }

    @Override
    public void initialize() {
        gripper.lock();
    }
}
