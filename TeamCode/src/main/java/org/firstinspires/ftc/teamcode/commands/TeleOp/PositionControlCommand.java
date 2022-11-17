package org.firstinspires.ftc.teamcode.commands.TeleOp;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.teleop.PositionControlTest;

public class PositionControlCommand extends CommandBase {
    private PositionControlTest motor;
    private int pos;

    public PositionControlCommand(PositionControlTest position, int runPos){
        motor = position;
        pos = runPos;

    }

    @Override
    public void initialize() {
        motor.runToPos(pos);
    }

    @Override
    public void end(boolean interrupted) {
        motor.runToPos(0);
    }
}
