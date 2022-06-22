package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class MecanumSubsystem extends SubsystemBase {
    private MecanumDrive mDrive;
    private Motor fL, fR, bL, bR;

    public MecanumSubsystem(Motor fL, Motor fR, Motor bL, Motor bR){
        this.fL = fL;
        this.fR = fR;
        this.bL = bL;
        this.bR = bR;

        mDrive = new MecanumDrive(fL, fR, bL, bR);
    }

    public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed){
        mDrive.driveRobotCentric(-strafeSpeed, -forwardSpeed, -turnSpeed, true);
    }
}
