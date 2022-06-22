package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private final DriveSubsystem drive;
    private final DoubleSupplier strafeDS, forwardDS, turnDS;
    private double multiplier;

    // These constants slow down the drivetrain no matter what multiplier is given
    private final double DEFAULT_MULT = 0.8;
    private final double DEFAULT_TURN_MULT = 0.78;

    // Constructor that allows for slow mode
    public DriveCommand (DriveSubsystem driveSubsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn, double mult){
        drive = driveSubsystem;
        strafeDS = strafe;
        forwardDS = forward;
        turnDS = turn;
        multiplier = mult;

        addRequirements(drive);
    }

    // Default drive command
    public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn){
        drive = driveSubsystem;
        strafeDS = strafe;
        forwardDS = forward;
        turnDS = turn;
        multiplier = 1.0;

        addRequirements(drive);
    }

    // Tells the drive subsystem to drive based on inputs
    @Override
    public void execute(){
        drive.drive(
                strafeDS.getAsDouble() * DEFAULT_MULT * multiplier,
                forwardDS.getAsDouble() * DEFAULT_MULT * multiplier,
                turnDS.getAsDouble() * DEFAULT_TURN_MULT * multiplier
        );
    }
}