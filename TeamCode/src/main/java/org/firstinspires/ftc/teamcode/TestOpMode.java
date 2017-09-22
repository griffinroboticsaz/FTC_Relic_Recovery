package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor  ;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by Griffins on 9/11/2017.
 */
@TeleOp(name = "TestOpMode", group = "TeleOp")
public class TestOpMode extends OpMode{

    public DcMotor left;
    public DcMotor right;
    public Servo servoBoi;
    double lel;
    double leftPower;
    double rightPower;
    double currentLeftPower;
    double currentRightPower;
    Thread main = Thread.currentThread();

    {
        lel = 0;
    }

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        //servoBoi = hardwareMap.servo.get("bigboi");

    }

    @Override
    public void loop() {
        currentLeftPower = gamepad1.left_stick_y - gamepad1.left_stick_x;
        currentRightPower = gamepad1.left_stick_y + gamepad1.left_stick_x;
        currentLeftPower = Range.clip(currentLeftPower, -1, 1);
        currentRightPower = Range.clip(currentRightPower, -1, 1);

        if (leftPower < currentLeftPower) {
            leftPower += .05;
            if (leftPower >= 1) {
                leftPower = 1;
            }
        }
        if (leftPower > currentLeftPower) {
            leftPower -= .05;
            if (leftPower <= -1) {
                leftPower = -1;
            }
        }
        if (rightPower < currentRightPower) {
            rightPower += .05;
            if (rightPower >= 1) {
                rightPower = 1;
            }
        }
        if (rightPower > currentRightPower) {
            rightPower -= .05;
            if (rightPower <= -1) {
                rightPower = -1;
            }
        }
        left.setPower(leftPower);
        right.setPower(rightPower);
        try {
            main.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //left.setPower(gamepad1.left_stick_y);
        //right.setPower(gamepad1.right_stick_y);

         /*if ((lel <= 1) && (gamepad2.right_stick_y <= 0)){
             lel += (gamepad2.right_stick_y/5);

         } else if ((lel >= -1) && (gamepad2.right_stick_y >= 0)){
             lel += (gamepad2.right_stick_y/5);

         } else{
             lel += (gamepad2.right_stick_y/5);

         }*/
    }
}



