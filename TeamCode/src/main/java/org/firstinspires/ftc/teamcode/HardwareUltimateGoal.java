package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareUltimateGoal {

    //Wheels
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    //outtake slingshot thingy
   // public DcMotor leftoutake;
  //  public DcMotor rightoutake;

    //leadscrew motor

    public DcMotor leadscrew;

    public CRServo intakeL;
    public CRServo intakeR;


    int driveTime;


    //-------------------------------------Initialization----------------------

    public void InitializeRobot(HardwareMap hardwareMap) {
        HardwareMap HWMap = hardwareMap;

        //initialize motors

        leftFront = HWMap.dcMotor.get("leftFront");
        leftBack = HWMap.dcMotor.get("leftBack");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

       // leftoutake = HWMap.dcMotor.get("leftoutake");
        //rightoutake = HWMap.dcMotor.get("rightoutake");

        leadscrew = HWMap.dcMotor.get("leadscrew");

        intakeL = HWMap.crservo.get("intakeL");
        intakeR = HWMap.crservo.get("intakeR");

    }


    //------------------------------------Basic Driving--------------------

    public void DriveStraight(double power, long totalSeconds, int Direction) throws InterruptedException {

        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * -Direction);
        rightFront.setPower(power * Direction);
        rightBack.setPower(power * Direction);

        Thread.sleep(totalSeconds);

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }
//right = positive direction
    public void DriveTurn(double power, long totalSeconds, int Direction) throws InterruptedException {
        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * -Direction);
        rightFront.setPower(power * -Direction);
        rightBack.setPower(power * -Direction);

        Thread.sleep(totalSeconds);


        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

    public void DriveSideways(double power, long totalSeconds, int Direction) throws InterruptedException {
        leftFront.setPower(power * -Direction);
        leftBack.setPower(power * Direction);
        rightFront.setPower(power * -Direction);
        rightBack.setPower(power * Direction);

        Thread.sleep(totalSeconds);
        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }


//-----------------------------------------Outake/Intake------------------------------

   /* public void Outake(double power) {
      leftoutake.setPower(power);
     rightoutake.setPower(power);
    }
*/
  /*  public void Intake(double power) {
        intake.setPower(power);
    }
*/

// ----------------------------------------LeadScrew--------------------------


    public void Leadscrew (double power, int encoder, int Direction) {
        leadscrew.setPower(power*Direction);

        leadscrew.setTargetPosition(encoder*Direction);


        while (leadscrew.isBusy()) {
            leadscrew.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        leadscrew.setPower(0);



    }

    public void Intake (double power) {
        intakeL.setPower(power);
        intakeR.setPower(-power);
    }
}



