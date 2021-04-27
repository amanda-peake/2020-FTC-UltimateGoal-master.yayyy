package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//delivers right wobble to third square, launches rings, parks
//tested and works!!

@Autonomous (name = "WobbleLaunch3")
public class AutoWobbleLaunch3  extends LinearOpMode {

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

        //Drives to third sqaure
        Gerty.DriveStraight(.5,4000,-1);
        Thread.sleep(1000);
        //Backs up to leave wobble
        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(1000);

        //strafes to line up with scorey thing
        Gerty.DriveSideways(.5,1000,1);
        Thread.sleep(1000);

        //launches ring(s)
        Gerty.outake2.setPower(1);

        Gerty.Launch(1,4000);
        Thread.sleep(1000);

    }
}
