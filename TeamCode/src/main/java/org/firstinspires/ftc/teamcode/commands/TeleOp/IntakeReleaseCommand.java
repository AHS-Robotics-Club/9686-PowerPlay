package org.firstinspires.ftc.teamcode.commands.TeleOp;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.IntakeSubsystem;

public class IntakeReleaseCommand extends CommandBase {
    private IntakeCommandManagerClass i;
    private IntakeSubsystem intakeSubsystem = i.intakeSubsystem;

    @Override
    public void initialize() {
        intakeSubsystem.release();
    }
}
