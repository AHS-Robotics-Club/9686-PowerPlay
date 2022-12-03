package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.TeleOp.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper.GripperCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper.GripperLockCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper.GripperReleaseCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftDownCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftSlowDown;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftSlowUp;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftUpCommand;
import org.firstinspires.ftc.teamcode.subsystems.teleop.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Gripper.GripperSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftMotorGroup;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Intake.Lifts.LiftSubsystem;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends CommandOpMode {
    // MOTORS
    private Motor fL, fR, bL, bR;
    private Motor testMotor;
    private Motor leftLift, rightLift;

    private LiftMotorGroup lifts;

    // SERVOS
    private SimpleServo gripper;

    // SUBSYSTEMS
    private DriveSubsystem driveSubsystem;

    private LiftSubsystem liftSubsystem;
    private GripperSubsystem gripperSubsystem;


    // COMMANDS
    private DriveCommand driveCommand;

    private LiftUpCommand liftUpCommand;
    private LiftDownCommand liftDownCommand;
    private LiftSlowUp slowUp;
    private LiftSlowDown slowDown;

    private GripperLockCommand lockGripper;
    private GripperReleaseCommand releaseGripper;

    private GripperCommand gripperCommand;


    // EXTRAS
    private GamepadEx gPad1;
    private RevIMU revIMU;
    private ElapsedTime deltaTime;

    // CONSTANTS
    private final double DRIVE_MULT = 1.0;
    private final int DEBUG = 1;

    @Override
    public void initialize() {
//        // I HATE U AND I LOVE UR MOMMMMM
//        //Drivetrain
//
//        // Initializing Motors
        fL = new Motor(hardwareMap, "frontLeft");
        fR = new Motor(hardwareMap, "frontRight");
        bL = new Motor(hardwareMap, "backLeft");
        bR = new Motor(hardwareMap, "backRight");
//
//        // Initializing Extras
            gPad1 = new GamepadEx(gamepad1);

        //`` Initializing Commands and Subsystems
        driveSubsystem = new DriveSubsystem(fL, fR, bL, bR, revIMU);
        driveCommand = new DriveCommand(driveSubsystem, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX, DRIVE_MULT);

        // Motor Settings
        fL.motor.setDirection(DcMotor.Direction.FORWARD);
        //fR.motor.setDirection(DcMotor.Direction.FORWARD);
        bL.motor.setDirection(DcMotor.Direction.FORWARD);
        //bR.motor.setDirection(DcMotor.Direction.FORWARD);

        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Sets default command for drivetrain
        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);

        // Lifts

        gripper = new SimpleServo(hardwareMap, "gripper", 0, 180);
        leftLift = new Motor(hardwareMap, "leftLift");
        rightLift = new Motor(hardwareMap, "rightLift");
        deltaTime = new ElapsedTime();

        leftLift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        liftSubsystem = new LiftSubsystem(new LiftMotorGroup(leftLift, rightLift));
        gripperSubsystem = new GripperSubsystem(gripper);

        liftUpCommand = new LiftUpCommand(liftSubsystem);
        liftDownCommand = new LiftDownCommand(liftSubsystem);
        slowUp = new LiftSlowUp(liftSubsystem);
        slowDown = new LiftSlowDown(liftSubsystem);

        lockGripper = new GripperLockCommand(gripperSubsystem);
        releaseGripper = new GripperReleaseCommand(gripperSubsystem);
        gripperCommand = new GripperCommand(gripperSubsystem);

        deltaTime = new ElapsedTime();

        /*
        gPad1.getGamepadButton(GamepadKeys.Button.A).whenHeld(
                new StartEndCommand(
                        () -> raiseLift.andThen(releaseCone),
                        () -> resetLift.andThen(lockCone)
                )
        );
        */
        gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(lockGripper, releaseGripper);
        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenHeld(liftUpCommand);
        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenHeld(liftDownCommand);
        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenHeld(slowDown);
        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenHeld(slowUp);



    }
}
