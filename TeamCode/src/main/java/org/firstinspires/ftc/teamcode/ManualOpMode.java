package org.firstinspires.ftc.teamcode;

import android.media.AudioManager;
import android.media.SoundPool;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

/**
 * Created by Griffins on 9/30/2017.
 */
@TeleOp(name = "manual", group = "TeleOp")
//@Disabled
public class ManualOpMode extends OpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor liftMotor;
    private CRServo leftFeeder;
    private CRServo rightFeeder;
    private DcMotor Rotator;
    private Servo armMotor;
    private Servo colorServo;
    private double liftDirection;
    private double powerReducer = 2;
    private double openPosition = 0.37;
    private double closedPosition = 0.5;
    private double colorSetPosition = 0.45;
    private double directionUp = 0.666;
    private double directionDown = -0.2;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        liftMotor = hardwareMap.dcMotor.get("lift");
        leftFeeder = hardwareMap.crservo.get("leftFeeder");
        rightFeeder = hardwareMap.crservo.get("rightFeeder");
        colorServo = hardwareMap.servo.get("cservo");
        armMotor = hardwareMap.servo.get("arm");
        Rotator = hardwareMap.dcMotor.get("rot");
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        armMotor.setPosition(openPosition);
        colorServo.setPosition(colorSetPosition);
    }

    @Override
    public void loop() {
        //powerLeft = -gamepad1.left_stick_y + gamepad1.left_stick_x;
        //powerRight = -gamepad1.left_stick_y - gamepad1.left_stick_x;

        //powerFeeder = (-gamepad1.left_trigger + gamepad1.right_trigger) / powerReducer;

        //powerRotator = gamepad1.right_stick_y;

        leftMotor.setPower(power("left"));
        rightMotor.setPower(power("right"));
        leftFeeder.setPower(power("feeders"));
        rightFeeder.setPower(-power("feeders"));

        if (gamepad1.dpad_down) {
            liftDirection = directionDown;
        } else if (gamepad1.dpad_up) {
            liftDirection = directionUp;
        } else {
            liftDirection = 0;
        }

        liftMotor.setPower(liftDirection);
        Rotator.setPower(power("rotator"));

        telemetry.addData("rotation power" , Rotator.getPower());

        //armMotor.setPosition(armPos);

        if (gamepad1.a) {
            armMotor.setPosition(openPosition);
        } else if (gamepad1.b) {
            armMotor.setPosition(closedPosition);
        }
    }
    private double power(String side){
        /*if (side.equals("left")) {
            return -gamepad1.left_stick_y + gamepad1.left_stick_x;
        }
        else if (side.equals("right")){
            return -gamepad1.left_stick_y - gamepad1.left_stick_x;
        }
        else if (side.equals("feeder")) {
            return (-gamepad1.left_trigger + gamepad1.right_trigger) / powerReducer;
        }
        else if (side.equals("rotator")) {
            return gamepad1.right_stick_y;
        }
        else throw new IllegalArgumentException("There is no such motor!");*/

        switch (side){
            case "left": return -gamepad1.left_stick_y + gamepad1.left_stick_x;
            case "right": return -gamepad1.left_stick_y - gamepad1.left_stick_x;
            case "feeders": if (gamepad1.right_bumper) {return 1;}
                else if (gamepad1.left_bumper) {return -1;}
                else {return 0;}
            case "rotator": return gamepad1.right_stick_y;
            default: throw new IllegalArgumentException("There is no such motor!");
        }
    }

}
