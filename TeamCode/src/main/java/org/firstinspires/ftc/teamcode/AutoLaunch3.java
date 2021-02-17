package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "AutoLaunch3")

//delivering wobble goal to second square, launching ring into goal, then parking

public class AutoLaunch3 extends LinearOpMode {

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

        Gerty.DriveTurn(.5,1000,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(1000);

        Gerty.DriveSideways(.5,300,1);
        Thread.sleep(100);
    }
}
