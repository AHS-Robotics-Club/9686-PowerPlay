package org.firstinspires.ftc.teamcode.commands.TeleOp;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.teleop.LiftSubsystem;

public class LiftStepCommand extends CommandBase {
    private LiftSubsystem lift;

    private ElapsedTime deltaTime;
    private double timeLeft;
    private int level = 2;

    public LiftStepCommand(LiftSubsystem liftSubsystem, ElapsedTime time){
        lift = liftSubsystem;
        deltaTime = time;
    }

    @Override
    public void initialize() {
            timeLeft = 0.45;
            lift.runNormal();
    }

    @Override
    public boolean isFinished() {
        return deltaTime.seconds() >= timeLeft;
    }

    @Override
    public void end(boolean interrupted) {
        lift.stopMotor();
    }
}
