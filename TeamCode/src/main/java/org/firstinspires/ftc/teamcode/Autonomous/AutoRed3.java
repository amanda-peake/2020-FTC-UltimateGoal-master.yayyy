package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareUltimateGoal;

//closest square with right wobble
@Autonomous (name = "AutoRed3")
public class AutoRed3 extends LinearOpMode {
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

        Gerty.DriveStraight(1,3500,1);
        Thread.sleep(1000);


        Gerty.DriveSideways(.5,3000,1,1,1,1);
        Thread.sleep(3000);

        Gerty.DriveStraight(.5,1000,1);
        Thread.sleep(1000);






    }
}
