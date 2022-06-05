package com.arcrobotics.meepmeeptest;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Curve5 {
    public static void main(String[] args){
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity botEntity = new DefaultBotBuilder(meepMeep)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-60,36, Math.toRadians(315)))
                                .lineToSplineHeading(new Pose2d(0, 0, Math.toRadians(315)))
                                .splineTo(new Vector2d(0, -24), Math.toRadians(180))
                                .splineTo(new Vector2d(0, 0), Math.toRadians(45))
                                .lineToSplineHeading(new Pose2d(60, 36, Math.toRadians(45)))
                                .build()
                );
        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(botEntity)
                .start();
    }
}
