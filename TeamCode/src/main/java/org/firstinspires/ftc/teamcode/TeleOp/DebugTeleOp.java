package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Testing.TestPosControl;

@Config
@TeleOp(name = "DebugTeleOp")
public class DebugTeleOp extends CommandOpMode {
    private Motor testMotor;
    private SimpleServo gripper;

    private TestPosControl s_motor;

    private GamepadEx gPad1;
    private FtcDashboard dashboard;
    private Telemetry dashTelemetry;

    // Dashboard Values
    public static int runPos = 312;
    public static double kP = 1;
    public static double tolerance = 1;

    @Override
    public void initialize() {
        gPad1 = new GamepadEx(gamepad1);

        // Position Control
        testMotor = new Motor(hardwareMap, "testMotor");
        testMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        s_motor = new TestPosControl(testMotor, kP, tolerance);

        gPad1.getGamepadButton(GamepadKeys.Button.A).whenHeld(new StartEndCommand(
                () -> s_motor.runToPos(runPos),
                () -> s_motor.runToPos(0)
        ));

        dashboard = FtcDashboard.getInstance();
        dashTelemetry = dashboard.getTelemetry();

        while(opModeIsActive()){
            dashTelemetry.addData("Current Motor Position", testMotor.getCurrentPosition());
            dashTelemetry.update();
        }

        schedule(
                new RunCommand(() ->
                        {
                                telemetry.addData("Current Motor Position", testMotor.getCurrentPosition());
                                telemetry.update();
                        }
                )
        );

    }
}
