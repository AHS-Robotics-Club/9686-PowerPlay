package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.AutoIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LevelsSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Positions;

public class IntakeDropCommand extends CommandBase {
    private LevelsSubsystem intake;

    public IntakeDropCommand(LevelsSubsystem subsystem){
        intake = subsystem;
    }

    @Override
    public void initialize() {
        intake.setPosition(Positions.DROP);
    }
}
