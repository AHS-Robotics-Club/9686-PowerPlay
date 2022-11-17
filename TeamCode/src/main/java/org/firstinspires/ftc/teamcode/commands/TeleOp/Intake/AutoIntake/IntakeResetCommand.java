package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.AutoIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LevelsSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Positions;

public class IntakeResetCommand extends CommandBase {
    private LevelsSubsystem intake;

    public IntakeResetCommand(LevelsSubsystem subsystem){
        intake = subsystem;
    }

    @Override
    public void initialize() {
        intake.setPosition(Positions.INIT);
    }
}
