package org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftSubsystem;

public class LiftSlowDown extends CommandBase {
    private LiftSubsystem slowSlideBoob;
    public LiftSlowDown(LiftSubsystem constructSlide){
        slowSlideBoob = constructSlide;
    }

    @Override
    public void initialize() {
        slowSlideBoob.runSlowReverse();
    }

    @Override
    public void end(boolean interrupted) {
        slowSlideBoob.stopMotor();
    }
}
