package org.firstinspires.ftc.teamcode.commands.TeleOp;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.IntakeSubsystem;

public class IntakeStepCommand extends CommandBase {
    private IntakeCommandManagerClass i;
    private IntakeSubsystem intakeSubsystem = i.intakeSubsystem;
    int state = 0;

    @Override
    public void initialize() {
        intakeSubsystem.levelUp(state);
    }
    @Override
    public void end(boolean interrupted) {
        if(state != 1){
            state++;
        } else {
            state = 0;
        }
    }
}
