package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LiftSubsystem;

public class LiftUpCommand extends CommandBase {
    private LiftSubsystem lift;

    public LiftUpCommand(LiftSubsystem lS){
        lift = lS;
    }

    @Override
    public void initialize() {
        lift.runNormal();
    }

    @Override
    public void end(boolean interrupted) {
        lift.stopMotor();
    }
}
