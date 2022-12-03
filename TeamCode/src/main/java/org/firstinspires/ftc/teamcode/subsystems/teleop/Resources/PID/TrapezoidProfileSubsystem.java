// Copyright (c) FIRST and other WPILib contributors.
package org.firstinspires.ftc.teamcode.subsystems.teleop.Resources.PID;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

public abstract class TrapezoidProfileSubsystem extends SubsystemBase {
    private final double m_period;
    private final TrapezoidProfile.Constraints m_constraints;

    private TrapezoidProfile.State m_state;
    private TrapezoidProfile.State m_goal;

    private boolean m_enabled = true;

    /**
     * Creates a new TrapezoidProfileSubsystem.
     *
     * @param constraints     The constraints (maximum velocity and acceleration) for the profiles.
     * @param initialPosition The initial position of the controlled mechanism when the subsystem is
     *                        constructed.
     * @param period          The period of the main robot loop, in seconds.
     */
    public TrapezoidProfileSubsystem(
            TrapezoidProfile.Constraints constraints, double initialPosition, double period) {
        m_constraints = constraints;
        m_state = new TrapezoidProfile.State(initialPosition, 0);
        setGoal(initialPosition);
        m_period = period;
    }

    /**
     * Creates a new TrapezoidProfileSubsystem.
     *
     * @param constraints     The constraints (maximum velocity and acceleration) for the profiles.
     * @param initialPosition The initial position of the controlled mechanism when the subsystem is
     *                        constructed.
     */
    public TrapezoidProfileSubsystem(TrapezoidProfile.Constraints constraints, double initialPosition) {
        this(constraints, initialPosition, 0.02);
    }

    /**
     * Creates a new TrapezoidProfileSubsystem.
     *
     * @param constraints The constraints (maximum velocity and acceleration) for the profiles.
     */
    public TrapezoidProfileSubsystem(TrapezoidProfile.Constraints constraints) {
        this(constraints, 0, 0.02);
    }

    @Override
    public void periodic() {
        TrapezoidProfile profile = new TrapezoidProfile(m_constraints, m_goal, m_state);
        m_state = profile.calculate(m_period);
        if (m_enabled) {
            useState(m_state);
        }
    }

    /**
     * Sets the goal state for the subsystem.
     *
     * @param goal The goal state for the subsystem's motion profile.
     */
    public void setGoal(TrapezoidProfile.State goal) {
        m_goal = goal;
    }

    /**
     * Sets the goal state for the subsystem. Goal velocity assumed to be zero.
     *
     * @param goal The goal position for the subsystem's motion profile.
     */
    public void setGoal(double goal) {
        setGoal(new TrapezoidProfile.State(goal, 0));
    }

    /**
     * Enable the TrapezoidProfileSubsystem's output.
     */
    public void enable() {
        m_enabled = true;
    }

    /**
     * Disable the TrapezoidProfileSubsystem's output.
     */
    public void disable() {
        m_enabled = false;
    }

    /**
     * Users should override this to consume the current state of the motion profile.
     *
     * @param state The current state of the motion profile.
     */
    protected abstract void useState(TrapezoidProfile.State state);
}