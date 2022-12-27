package org.firstinspires.ftc.teamcode.tests;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftMotorGroup;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Testing.Slides.TestPLift;

public class TestSlidePIDControl extends CommandOpMode {
    // DASHBOARD VALUES
    public static double kP = 1.0;
    public static int runPos = 25;
    public static double tolerance = 1.0;

    public static int longWait = 2000;
    public static int shortWait = 750;

    private Motor leftLift, rightLift;
    private LiftMotorGroup lifts;

    private TestPLift liftSubsystem;

    @Override
    public void initialize() {
        leftLift = new Motor(hardwareMap, "leftLift");
        rightLift = new Motor(hardwareMap, "rightLift");

        lifts = new LiftMotorGroup(leftLift, rightLift);

        liftSubsystem = new TestPLift(lifts, kP);

        schedule(
                new ParallelCommandGroup(
                        new SequentialCommandGroup(runUp().andThen(runDown().andThen(new WaitCommand(longWait)))),
                        new RunCommand(() -> {
                            telemetry.addData("Current Motor Position", lifts.getCurrentPosition());
                            telemetry.addData("RunPos", runPos);
                            telemetry.addData("0", 0);
                            telemetry.update();
                        })
                )
        );
    }

    private SequentialCommandGroup runUp(){
        return new SequentialCommandGroup(
                new InstantCommand(() -> liftSubsystem.runToPos(runPos, tolerance))
                        .andThen(new WaitCommand(shortWait))
        );
    }
    private SequentialCommandGroup runDown(){
        return new SequentialCommandGroup(
                new InstantCommand(() -> liftSubsystem.runToPos(0, tolerance))
                        .andThen(new WaitCommand(shortWait))
        );
    }
}
