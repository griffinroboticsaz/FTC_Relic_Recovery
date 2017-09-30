package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Griffins on 9/30/2017.
 */
@TeleOp(name = "manual", group = "TeleOp")
public class ManualOpMode extends OpMode {
    public DcMotor left;
    public DcMotor right;
    double pLeft;
    double pRight;

    public void loop() {
        pLeft = -(gamepad1.left_stick_y - gamepad1.left_stick_x);
        pRight = -(gamepad1.left_stick_y + gamepad1.left_stick_x);
        left.setPower(pLeft);
        right.setPower(pRight);

    }

    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        //left.setDirection(DcMotorSimple.Direction.REVERSE);

    }

}
