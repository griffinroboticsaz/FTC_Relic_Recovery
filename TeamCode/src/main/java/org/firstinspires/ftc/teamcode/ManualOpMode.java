package org.firstinspires.ftc.teamcode;

import android.media.AudioManager;
import android.media.SoundPool;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Griffins on 9/30/2017.
 */
@TeleOp(name = "manual", group = "TeleOp")
//@Disabled
public class ManualOpMode extends OpMode {
    public DcMotor left;
    public DcMotor right;
    public DcMotor lift;
    public DcMotor feeder;
    public DcMotor rot;
    public Servo arm;
    public Servo colorServo;
    double pLeft;
    double pRight;
    double pFeeder;
    double pRot;
    double direction;
    double powerReducer = 3;
    double rotPos = 1;
    double servoPowerReducer = 250;
    double openPos = 0.6;
    double closedPos = .8;
    double colorSetPos = 0.45;
    double colorCheckPos = 1;
    double dirUp = 0.666;
    double dirDown = -0.2;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        lift = hardwareMap.dcMotor.get("lift");
        feeder = hardwareMap.dcMotor.get("feeder");
        colorServo = hardwareMap.servo.get("cservo");
        arm = hardwareMap.servo.get("arm");
        rot = hardwareMap.dcMotor.get("rot");
        right.setDirection(DcMotor.Direction.FORWARD);
        left.setDirection(DcMotor.Direction.REVERSE);

        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm.setPosition(openPos);
        colorServo.setPosition(colorSetPos);
    }

    @Override
    public void loop() {
        pLeft = -gamepad1.left_stick_y + gamepad1.left_stick_x;
        pRight = -gamepad1.left_stick_y - gamepad1.left_stick_x;

        pFeeder = (-gamepad1.left_trigger + gamepad1.right_trigger) / powerReducer;

        pRot = gamepad1.right_stick_y /3;

        left.setPower(pLeft);
        right.setPower(pRight);
        feeder.setPower(pFeeder);

        if (gamepad1.dpad_down) {
            direction = dirDown;
        } else if (gamepad1.dpad_up) {
            direction = dirUp;
        } else {
            direction = 0;
        }

        lift.setPower(direction);
        rot.setPower(pRot);

        /*if(((armPos + gamepad2.left_stick_y / armServoPowerReducer) >= 0) && ((armPos + gamepad2.left_stick_y / armServoPowerReducer) <= 1)){
            armPos = armPos + gamepad2.left_stick_y / armServoPowerReducer;
        }*/
        /*if(((rotPos + gamepad2.right_stick_y / servoPowerReducer) >= 0) && ((rotPos + gamepad2.right_stick_y / servoPowerReducer) <= 1)){
            rotPos = rotPos + gamepad2.right_stick_y / servoPowerReducer;
        }*/

        telemetry.addData("rotation power" , rot.getPower());

        //arm.setPosition(armPos);

        if (gamepad1.a) {
            arm.setPosition(openPos);
        } else if (gamepad1.b) {
            arm.setPosition(closedPos);
        }
    }


}
