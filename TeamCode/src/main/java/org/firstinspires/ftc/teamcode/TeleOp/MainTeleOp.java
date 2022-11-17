package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.commands.TeleOp.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper.GripperLockCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Gripper.GripperReleaseCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftDownCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.Intake.Lifts.LiftUpCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.PositionControlCommand;
import org.firstinspires.ftc.teamcode.subsystems.teleop.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.GripperSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.PositionControlTest;


@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends CommandOpMode {
    // MOTORS
    private Motor fL, fR, bL, bR;
    private Motor testMotor;
    private Motor liftMotor, rightLift;

    // SERVOS
    private SimpleServo gripper;

    // SUBSYSTEMS
    private DriveSubsystem driveSubsystem;

    private LiftSubsystem liftSubsystem;
    private GripperSubsystem gripperSubsystem;

    private PositionControlTest positionControlTest;

    // COMMANDS
    private DriveCommand driveCommand;

    private LiftUpCommand liftUpCommand;
    private LiftDownCommand liftDownCommand;

    private GripperLockCommand lockGripper;
    private GripperReleaseCommand releaseGripper;

    private PositionControlCommand positionControlCommand;

    // EXTRAS
    private GamepadEx gPad1;
    private RevIMU revIMU;
    private ElapsedTime deltaTime;

    // CONSTANTS
    private final double DRIVE_MULT = 1.0;
    private final int DEBUG = 1;

    @Override
    public void initialize() {
        gPad1 = new GamepadEx(gamepad1);

        //DEBUG GROUP 1
//        gripper = new SimpleServo(hardwareMap, "gripper", 0, 180);
//        gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new InstantCommand(() -> gripper.rotateByAngle(45)));
//        gPad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new InstantCommand(() -> gripper.rotateByAngle(-45)));
        //DEBUG GROUP 2
//        testMotor = new Motor(hardwareMap, "testMotor");
//        gPad1.getGamepadButton(GamepadKeys.Button.B).whenHeld(new InstantCommand(() -> testMotor.set(0.5)));
//        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
//        System.out.println("B has been pressed");

        //DEBUG GROUP 3
        testMotor = new Motor(hardwareMap, "testMotor");
        testMotor.setRunMode(Motor.RunMode.PositionControl);

        positionControlTest = new PositionControlTest(testMotor);
        positionControlCommand = new PositionControlCommand(positionControlTest, 25);

        gPad1.getGamepadButton(GamepadKeys.Button.A).whenHeld(positionControlCommand);

//        //Drivetrain
//        // Initializing Motors
//        fL = new Motor(hardwareMap, "frontLeft");
//        fR = new Motor(hardwareMap, "frontRight");
//        bL = new Motor(hardwareMap, "backLeft");
//        bR = new Motor(hardwareMap, "backRight");
//
//        // Initializing Extras
//        gPad1 = new GamepadEx(gamepad1);
//
//        //`` Initializing Commands and Subsystems
//        driveSubsystem = new DriveSubsystem(fL, fR, bL, bR, revIMU);
//        driveCommand = new DriveCommand(driveSubsystem, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX, DRIVE_MULT);
//
//        // Motor Settings
//        fL.motor.setDirection(DcMotor.Direction.REVERSE);
//        fR.motor.setDirection(DcMotor.Direction.FORWARD);
//        bL.motor.setDirection(DcMotor.Direction.REVERSE);
//        bR.motor.setDirection(DcMotor.Direction.FORWARD);
//
//        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        // Sets default command for drivetrain
//        register(driveSubsystem);
//        driveSubsystem.setDefaultCommand(driveCommand);
//
//        // Lifts
//
//        gripper = new SimpleServo(hardwareMap, "gripper", 0, 180);
//        liftMotor = new Motor(hardwareMap, "liftMotor");
//        deltaTime = new ElapsedTime();
//
//        liftMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//
//        liftSubsystem = new LiftSubsystem(liftMotor);
//        gripperSubsystem = new GripperSubsystem(gripper);
//
//        liftUpCommand = new LiftUpCommand(liftSubsystem);
//        liftDownCommand = new LiftDownCommand(liftSubsystem);
//
//        deltaTime = new ElapsedTime();
//
//        /*
//        gPad1.getGamepadButton(GamepadKeys.Button.A).whenHeld(
//                new StartEndCommand(
//                        () -> raiseLift.andThen(releaseCone),
//                        () -> resetLift.andThen(lockCone)
//                )
//        );
//        */
//        gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(lockGripper);
//        gPad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(releaseGripper);
//        gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(stepCommand);
//        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenHeld(liftUpCommand);
//        gPad1.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenHeld(liftDownCommand);

    }
}
