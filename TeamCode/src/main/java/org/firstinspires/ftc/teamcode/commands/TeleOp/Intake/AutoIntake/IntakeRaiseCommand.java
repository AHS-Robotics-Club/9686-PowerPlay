package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.AutoIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LevelsSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Positions;

public class IntakeRaiseCommand extends CommandBase {
    private LevelsSubsystem intake;

    public IntakeRaiseCommand(LevelsSubsystem subsystem){
        intake = subsystem;
    }

    @Override
    public void initialize() {
        intake.setPosition(Positions.RAISE);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setPosition(Positions.PICKUP);
    }
}
