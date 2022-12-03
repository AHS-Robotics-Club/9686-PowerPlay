package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftSubsystem;

public class LiftDownCommand extends CommandBase {
    private LiftSubsystem lift;

    public LiftDownCommand(LiftSubsystem lS){
        lift = lS;
    }

    @Override
    public void initialize() {
        lift.runNormalReverse();
    }

    @Override
    public void end(boolean interrupted) {
        lift.stopMotor();
    }
}
