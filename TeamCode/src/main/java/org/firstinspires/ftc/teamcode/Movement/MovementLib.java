package org.firstinspires.ftc.teamcode.Movement;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.CustomHardwareMap;

/**
 * Created by Justin on 10/16/2017.
 */

public class MovementLib {

    /*public static void forward(DcMotor motor1, DcMotor motor2, double inches, double speed){
            motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            int counts = EncoderUtils.calcCounts(inches);

        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motor1.setTargetPosition(counts);
        motor2.setTargetPosition(counts);

        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor1.setPower(speed);
        motor2.setPower(speed);

        while(motor1.getCurrentPosition() <= counts && motor2.getCurrentPosition() <= counts){
            if(motor1.getCurrentPosition() == counts && motor2.getCurrentPosition() == counts){
                motor1.setPower(0);
                motor2.setPower(0);

                motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                break;
            }
        }

    }*/
    public static<Mode extends OpMode> void forward(CustomHardwareMap robot, double inches, double speed, Mode mode) {
        mode.telemetry.addData("Working!", "");
        int counts = EncoderUtils.calcCounts(inches);
        mode.telemetry.addData("Counts", counts);
        robot.getRight().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.getLeft().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        robot.getRight().setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.getLeft().setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.getRight().setTargetPosition(counts);
        robot.getLeft().setTargetPosition(counts);

        robot.getRight().setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.getLeft().setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.getRight().setPower(speed);
        robot.getLeft().setPower(speed);

        while (robot.getRight().getCurrentPosition() <= counts && Math.abs(robot.getLeft().getCurrentPosition()) <= counts) {
            mode.telemetry.addData("Counts Left", robot.getLeft().getCurrentPosition());
            mode.telemetry.update();
            if (robot.getRight().getCurrentPosition() >= counts && (Math.abs(robot.getLeft().getCurrentPosition()) >= counts)) {
                robot.getRight().setPower(0);
                robot.getLeft().setPower(0);
                robot.getRight().setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.getLeft().setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.getRight().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.getLeft().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                break;
            }
        }

   /* public static<Mode extends OpMode> void rotate(CustomHardwareMap robot, double angle, double speed, Mode mode) {
        robot.getGyroscope().getAngularVelocity(AngleUnit.DEGREES).
    }*/
    }
}
