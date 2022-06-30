package com.arcrobotics.meepmeeptest;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Curve4 {
    public static void main(String[] args){
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity botEntity = new DefaultBotBuilder(meepMeep)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(36,47, Math.toRadians(180)))
                                .forward(60)
                                .splineTo(new Vector2d(-35, 36), Math.toRadians(270))
                                .splineTo(new Vector2d(-12, 20), Math.toRadians(0))
                                .forward(36)
                                .splineTo(new Vector2d(47, 12), Math.toRadians(270))
                                .splineTo(new Vector2d(36, -5), Math.toRadians(180))
                                .splineTo(new Vector2d(4, 4), Math.toRadians(180))
                                .splineTo(new Vector2d(-3, 0), Math.toRadians(270))
                                .forward(48)
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(botEntity)
                .start();
    }
}


