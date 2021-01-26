package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareUltimateGoal;

@Autonomous (name = "AutoRed2")
//delivering left wobble goal to closest square

//TESTED AND IT WORKS
public class AutoRed2 extends LinearOpMode {
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

        //strafe right just a little bit

        Gerty.DriveStraight(.5,800,1);
        Thread.sleep(5000);

        Gerty.DriveTurn(.5,500,-1);
        Thread.sleep(1000);

        //drive straight and stop on line

        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(5000);

        Gerty.DriveTurn(.5,700,1);
        Thread.sleep(1000);

        Gerty.DriveStraight(.5,990,1);
        Thread.sleep(5000);



    }
}
