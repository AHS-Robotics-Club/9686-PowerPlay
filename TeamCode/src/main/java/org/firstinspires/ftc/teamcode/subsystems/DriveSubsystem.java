package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class DriveSubsystem extends SubsystemBase {
    private MecanumDrive drive;
    private Motor fL, fR, bL, bR;

    // Constructor takes in hardware that makes up the subsystem
    // You can think of constructors as initializing objects
    public DriveSubsystem(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight){
        fL = frontLeft;
        fR = frontRight;
        bL = backLeft;
        bR = backRight;

        // Initialize MecanumDrive object, takes in parameters for all motors
        drive = new MecanumDrive(fL, fR, bL, bR);
    }

    // This method runs the subsystem
    public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed){
        drive.driveRobotCentric(
                -strafeSpeed,
                -forwardSpeed,
                -turnSpeed,
                true // Squared inputs allow for more precise movement
        );
    }
}