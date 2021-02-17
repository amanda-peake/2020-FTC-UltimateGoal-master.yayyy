package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "AutoLaunch2")

//driving forward, launching ring into goal, delivering wobble goal to third square, then parking

public class AutoLaunch2 extends LinearOpMode {

    HardwareUltimateGoal Gerty = new HardwareUltimateGoal();

    @Override
    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Gerty.InitializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");

        telemetry.update();

        waitForStart();

        Gerty.DriveStraight(.75,3000,1);
        Thread.sleep(1000);

        Gerty.Launch(1,3000);
        Thread.sleep(1000);

        Gerty.DriveTurn(.5,500,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(1000);

        Gerty.DriveTurn(.5,750,-1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,1000,-1);
        Thread.sleep(1000);

    }
}

