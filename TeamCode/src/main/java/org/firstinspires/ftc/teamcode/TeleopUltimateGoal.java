package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TeleopUltimateGoal")

public class TeleopUltimateGoal extends LinearOpMode {

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

        while (opModeIsActive()) {

            double fwdBack = gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            if (gamepad1.start) {

                Gerty.leftFront.setPower((fwdBack + 1.5*strafe - turn) * .25);
                Gerty.leftBack.setPower((fwdBack - 1.5*strafe - turn) * .25);
                Gerty.rightFront.setPower((-fwdBack + 1.5*strafe - turn) * .25);
                Gerty.rightBack.setPower((-fwdBack - 1.5*strafe - turn) * .25);

            } else { // drive robot normally at full speed

                Gerty.leftFront.setPower((fwdBack + strafe - turn));
                Gerty.leftBack.setPower((fwdBack - strafe - turn));
                Gerty.rightFront.setPower((-fwdBack + strafe - turn));
                Gerty.rightBack.setPower((-fwdBack - strafe - turn));

            }

            }

       /* if (gamepad2.right_bumper) {
            Robot.Outake(1);
        }
        else {
            Robot.Outake(0);
        }

        if (gamepad2.left_bumper) {
            Robot.Outake(-1);
        }
        else {
            Robot.Outake(0);
        }
        */

        }


    }





