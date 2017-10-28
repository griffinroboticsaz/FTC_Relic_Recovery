package org.firstinspires.ftc.teamcode;

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
    public Servo arm;
    public Servo rot;
    double pLeft;
    double pRight;
    double pFeeder;
    double safety;
    double powerReducer = 3;
    double armPos = 1;
    double rotPos = 1;
    double servoPowerReducer = 250;
    double armServoPowerReducer = 250;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        lift = hardwareMap.dcMotor.get("lift");
        feeder = hardwareMap.dcMotor.get("feeder");

        arm = hardwareMap.servo.get("arm");
        rot = hardwareMap.servo.get("rot");
        right.setDirection(DcMotor.Direction.FORWARD);
        left.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void loop() {
        pLeft = -gamepad1.left_stick_y + gamepad1.left_stick_x;
        pRight = -gamepad1.left_stick_y - gamepad1.left_stick_x;

        pFeeder = -gamepad1.left_trigger + gamepad1.right_trigger;

        left.setPower(pLeft);
        right.setPower(pRight);
        feeder.setPower(pFeeder);

        safety = (gamepad1.right_stick_y / powerReducer);
        lift.setPower(safety);

        if(((armPos + gamepad2.left_stick_y / armServoPowerReducer) >= 0) && ((armPos + gamepad2.left_stick_y / armServoPowerReducer) <= 1)){
            armPos = armPos + gamepad2.left_stick_y / armServoPowerReducer;
        }
        if(((rotPos + gamepad2.right_stick_y / servoPowerReducer) >= 0) && ((rotPos + gamepad2.right_stick_y / servoPowerReducer) <= 1)){
            rotPos = rotPos + gamepad2.right_stick_y / servoPowerReducer;
        }

        arm.setPosition(armPos);
        rot.setPosition(rotPos);
    }


}
