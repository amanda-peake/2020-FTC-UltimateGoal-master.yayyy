package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "AutoWobbleLaunch2")

//driving forward, launching ring into goal, delivering left wobble goal to third square, then parking
//tested and works!!

public class AutoWobbleLaunch2 extends LinearOpMode {

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


        Gerty.DriveStraight(.50,3000,-1);
        Thread.sleep(2000);

        Gerty.outake2.setPower(1);

        Gerty.Launch(1,4000);
        Thread.sleep(1000);

        Gerty.DriveTurn(.5,700,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,500,-1);
        Thread.sleep(1000);

        Gerty.DriveTurn(.5,700,-1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,800,-1);
        Thread.sleep(1000);


        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(1000);

    }
}

