package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.MecanumCommand;
import org.firstinspires.ftc.teamcode.subsystems.MecanumSubsystem;


@TeleOp(name = "TeleOp")
public class MecanumTeleOp extends CommandOpMode {
    private Motor frontLeft, frontRight, backLeft, backRight;

    private Motor intakeMotor;

    private MecanumSubsystem driveSubsystem;

    private MecanumCommand driveCommand;

    private GamepadEx gamepad;

    private SimpleServo liftServo;

    private boolean isIntaked = true;

    @Override
    public void initialize() {
        frontLeft = new Motor(hardwareMap, "frontLeft");
        frontRight = new Motor(hardwareMap, "frontRight");
        backLeft = new Motor(hardwareMap, "backLeft");
        backRight = new Motor(hardwareMap, "backRight");

        intakeMotor = new Motor(hardwareMap, "intakeMotor");

        liftServo = new SimpleServo(hardwareMap, "liftServo", -180, 180);

        gamepad = new GamepadEx(gamepad1);

        driveSubsystem = new MecanumSubsystem(frontLeft, frontRight, backLeft, backRight);
        driveCommand = new MecanumCommand(driveSubsystem, gamepad::getLeftX, gamepad::getLeftY, gamepad::getRightX);

        gamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new StartEndCommand(() -> intakeMotor.set(-0.5), () -> intakeMotor.set(0)));
        gamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new StartEndCommand(() -> intakeMotor.set(0.5), () -> intakeMotor.set(0)));

        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).toggleWhenPressed(
                new InstantCommand(() -> liftServo.setPosition(0.69)),
                new InstantCommand(() -> liftServo.setPosition(0)));



        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}