package com.arcrobotics.meepmeeptest;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class practiceWriting {
    public static void main(String[] args){
        MeepMeep mm = new MeepMeep(800);
        RoadRunnerBotEntity botEntity = new DefaultBotBuilder(mm)
                .setConstraints(60.0, 60.0, Math.toRadians(180), Math.toRadians(180),15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(0,0,0))
                            .forward(30)
                            .build()
                );
        mm.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(botEntity)
                .start();
    }
}

