package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//Delivering right wobble to first sqaure and launch and park
@Autonomous (name = "WobbleLaunch")


public class AutoWobbleLaunch extends LinearOpMode {

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

        //Drives to first sqauew
        Gerty.DriveStraight(.5,2700,-1);
        Thread.sleep(1000);
        //Backs up to leave wobble
        Gerty.DriveStraight(.5,200,1);
        Thread.sleep(1000);

        //strafes to line up with scorey thing
        Gerty.DriveSideways(.5,3000,-1);
        Thread.sleep(1000);

        //launches ring(s)
        Gerty.outake2.setPower(1);

        Gerty.Launch(1,4000);
        Thread.sleep(1000);

        //Parks
        Gerty.DriveStraight(.5,750,1);



    }
}
