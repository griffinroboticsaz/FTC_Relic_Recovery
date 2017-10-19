package org.firstinspires.ftc.teamcode.Movement;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Justin on 10/16/2017.
 */

public class MovementLib {
    /**
     *
     * @param motor1
     * @param motor2
     * @param inches
     */
    public static void forward(DcMotor motor1, DcMotor motor2, double inches, double speed){
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

    }
}
