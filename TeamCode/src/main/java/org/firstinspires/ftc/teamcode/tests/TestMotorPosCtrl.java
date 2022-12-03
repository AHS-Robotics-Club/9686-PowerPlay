package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.subsystems.teleop.Testing.PController;
import org.firstinspires.ftc.teamcode.subsystems.teleop.Testing.TestPosControl;

@Config
@Autonomous(name = "TestPositionCtrl")
public class TestMotorPosCtrl extends CommandOpMode {
    public static double kP = 1.0;
    public static int runPos = 200;

    private Motor testMotor;
    private FtcDashboard dashboard;

    private PController s_motor;

    @Override
    public void initialize() {
        testMotor = new Motor(hardwareMap, "testMotor");


        s_motor = new PController(testMotor, kP);

        dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();



        schedule(
                new ParallelCommandGroup(
                        new WaitUntilCommand(this::isStarted)
                                .andThen(
                                        new InstantCommand(() -> s_motor.runToPos(runPos, 1))
                                                .andThen(
                                                        new WaitCommand(1000)
                                                                .andThen(new InstantCommand(() -> s_motor.runToPos(0, 1)))
                                                )
                                ),
                        new RunCommand(() -> {
                            telemetry.addData("Current Motor Position", testMotor.getCurrentPosition());
                            telemetry.addData("RunPos", runPos);
                            telemetry.addData("0", 0);
                            telemetry.update();
                        })
                )
        );


    }
}
