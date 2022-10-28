package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.TeleOp.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.IntakeCommandManagerClass;
import org.firstinspires.ftc.teamcode.commands.TeleOp.IntakeRaiseCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.IntakeReleaseCommand;
import org.firstinspires.ftc.teamcode.commands.TeleOp.IntakeStepCommand;
import org.firstinspires.ftc.teamcode.subsystems.teleop.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.GripperSubsystemClass;
import org.firstinspires.ftc.teamcode.subsystems.teleop.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.teleop.LiftSubsystemClass;

@TeleOp(name = "Main")
public class MainTeleOp extends CommandOpMode {
    // MOTORS
    private Motor fL, fR, bL, bR;
    private Motor testMotor;
    private Motor leftLift, rightLift;

    // SERVOS
    private SimpleServo gripper;

    // SUBSYSTEMS
    private DriveSubsystem driveSubsystem;

    private IntakeSubsystem intakeSubsystem;
    private LiftSubsystemClass liftSubsystemClass;
    private GripperSubsystemClass gripperSubsystemClass;

    // COMMANDS
    private DriveCommand driveCommand;

    private IntakeCommandManagerClass intakeCommand;

    private IntakeRaiseCommand intakeRaiseCommand;
    private IntakeStepCommand intakeStepCommand;
    private IntakeReleaseCommand intakeReleaseCommand;

    // EXTRAS
    private GamepadEx gPad1;
    private RevIMU revIMU;

    // CONSTANTS
    private final double DRIVE_MULT = 1.0;
    private final int DEBUG = 1;

    @Override
    public void initialize() {
        gPad1 = new GamepadEx(gamepad1);
        //DEBUG GROUP 1
        /*
        // Initializing Motors
        fL = new Motor(hardwareMap, "frontLeft");
        fR = new Motor(hardwareMap, "frontRight");
        bL = new Motor(hardwareMap, "backLeft");
        bR = new Motor(hardwareMap, "backRight");

        // Initializing Extras
        gPad1 = new GamepadEx(gamepad1);

        // Initializing Commands and Subsystems
        driveSubsystem = new DriveSubsystem(fL, fR, bL, bR, revIMU);
        driveCommand = new DriveCommand(driveSubsystem, gPad1::getLeftX, gPad1::getLeftY, gPad1::getRightX, DRIVE_MULT);

        // Motor Settings
        fL.motor.setDirection(DcMotor.Direction.REVERSE);
        fR.motor.setDirection(DcMotor.Direction.FORWARD);
        bL.motor.setDirection(DcMotor.Direction.REVERSE);
        bR.motor.setDirection(DcMotor.Direction.FORWARD);

        fL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Sets default command for drivetrain
        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
        */

        //DEBUG GROUP 2
        /*
        testMotor = new Motor(hardwareMap, "testMotor");
        gPad1.getGamepadButton(GamepadKeys.Button.B).whenHeld(new InstantCommand(() -> testMotor.set(0.5)));
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addData("Button Press 'b'", 0);
         */

        //DEBUG GROUP 3
        gripperSubsystemClass = new GripperSubsystemClass(gripper);
        liftSubsystemClass = new LiftSubsystemClass(leftLift, rightLift);
        intakeSubsystem = new IntakeSubsystem(gripperSubsystemClass, liftSubsystemClass);

        intakeCommand = new IntakeCommandManagerClass(intakeSubsystem);

        gPad1.getGamepadButton(GamepadKeys.Button.A).whenHeld(intakeRaiseCommand);
        gPad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(intakeStepCommand);
        gPad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(intakeReleaseCommand);


    }
}
