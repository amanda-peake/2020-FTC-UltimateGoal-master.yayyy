package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

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

            telemetry.addData("Ramp encoder", Gerty.leadscrew.getCurrentPosition());

            telemetry.update();


            if (gamepad1.start) {
                Gerty.leftFront.setPower((fwdBack + 1.5 * strafe - turn) * .25);
                Gerty.leftBack.setPower((fwdBack - 1.5 * strafe - turn) * .25);
                Gerty.rightFront.setPower((-fwdBack + 1.5 * strafe - turn) * .25);
                Gerty.rightBack.setPower((-fwdBack - 1.5 * strafe - turn) * .25);

            } else { // drive robot normally at full speed

                Gerty.leftFront.setPower((fwdBack + strafe - turn));
                Gerty.leftBack.setPower((fwdBack - strafe - turn));
                Gerty.rightFront.setPower((-fwdBack + strafe - turn));
                Gerty.rightBack.setPower((-fwdBack - strafe - turn));

            }

            if (gamepad2.a) {
                Gerty.leadscrew.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Gerty.leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Gerty.leadscrew.setTargetPosition(100);
                Gerty.leadscrew.setPower(.5);
            } else if (gamepad2.b) {
                Gerty.leadscrew.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Gerty.leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Gerty.leadscrew.setTargetPosition(200);
                Gerty.leadscrew.setPower(.5);
            } else if (gamepad2.y) {
                Gerty.leadscrew.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Gerty.leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Gerty.leadscrew.setTargetPosition(-100);
                Gerty.leadscrew.setPower(.5);
            }

            Gerty.Outake(gamepad2.right_trigger);

            Gerty.Intake(gamepad2.left_trigger);


        }


    }
}






