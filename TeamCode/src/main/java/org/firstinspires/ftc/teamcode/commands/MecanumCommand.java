package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.MecanumSubsystem;

import java.util.function.DoubleSupplier;

public class MecanumCommand extends CommandBase {
    private final MecanumSubsystem mDrive;
    private final DoubleSupplier strafe, forward, turn;

    public MecanumCommand(MecanumSubsystem subsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn){
        mDrive = subsystem;
        this.strafe = strafe;
        this.forward = forward;
        this.turn = turn;

        addRequirements(subsystem);
    }

    @Override
    public void execute(){
        mDrive.drive(strafe.getAsDouble() * 0.80 ,
                forward.getAsDouble()* 0.80,
                turn.getAsDouble()* 0.80);
    }
}