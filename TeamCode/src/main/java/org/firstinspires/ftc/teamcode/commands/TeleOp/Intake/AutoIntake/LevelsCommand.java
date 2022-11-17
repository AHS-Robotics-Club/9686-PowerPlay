package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.AutoIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LevelsSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Positions;

public class LevelsCommand extends CommandBase {
    private LevelsSubsystem intake;
    private int level = 1;

    public LevelsCommand(LevelsSubsystem subsystem){
        intake = subsystem;
    }

    @Override
    public void initialize() {
        if(level == 1){
            intake.setPosition(Positions.LEVEL1);
        }
        if(level == 2){
            intake.setPosition(Positions.LEVEL2);
        } else {
            intake.setPosition(Positions.LEVEL3);
        }
    }

    @Override
    public void end(boolean interrupted) {
        if(level < 3){
            level++;
        } else {
            level = 1;
        }
    }
}
