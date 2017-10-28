package org.firstinspires.ftc.teamcode.Movement;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.ColumnMajorMatrixF;
import org.firstinspires.ftc.teamcode.CustomHardwareMap;



/**
 * Created by Justin on 10/28/2017.
 */

public class AppendageLib {

/*
    public static void degreeRotateArm(CustomHardwareMap robot, double angle, double speed, Telemetry telemetry){
        int counts = EncoderUtils.degreeRotation(angle);
        telemetry.addData("Counts", counts);
        robot.getFeeder().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.getFeeder().setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.getFeeder().setTargetPosition(counts);

        robot.getFeeder().setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.getFeeder().setPower(speed);

        while(robot.getFeeder().getCurrentPosition() <= counts ){
            telemetry.addData("Counts Left", robot.getLeft().getCurrentPosition());
            telemetry.update();
            if(Math.abs(robot.getFeeder().getCurrentPosition()) >= counts ){
                robot.getFeeder().setPower(0);
                robot.getFeeder().setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.getFeeder().setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                break;
            }
        }
*/

    //}
}
