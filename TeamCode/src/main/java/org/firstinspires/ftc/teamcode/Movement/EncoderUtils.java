package org.firstinspires.ftc.teamcode.Movement;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Math.*;

/**
 * Created by Justin on 10/16/2017.
 */

public class EncoderUtils {
    private static final int COUNTS_PER_ROTATION = 1440;
    private static final double GEAR_RATIO = 2d;
    private static final double PI = Math.PI;
    private static final double WHEEL_CIRC = 2d * PI;

    /**
     * Calculating distance from the number of counts
     *
     * @param counts
     * @return distance
     */
    public static double calcDistance(long counts) {
        return (counts / COUNTS_PER_ROTATION) * GEAR_RATIO * WHEEL_CIRC;
    }

    /**
     * Returns ratio between two encoders
     *
     * @param count1 - encoder count from encoder 1
     * @param count2 - encoder count from encoder 2
     * @return ratio
     */
    private static double encRatio(long count1, long count2) {
        return count1 / count2;
    }

    /**
     * Modifies the stronger motor to match the weaker motor.
     * @param motor1 - reference to a motor
     * @param motor2 - reference to a motor
     * @param count1 - encoder count of motor1
     * @param count2 - encoder count of motor2
     */
    public static void calibrateMotor(DcMotor motor1, DcMotor motor2, long count1, long count2) {
        double ratio = encRatio(count1, count2);
        if (ratio > 1) {
            motor1.setPower(motor1.getPower() / ratio);
        } else if (ratio < 1) {
            // TODO // FIXME: 10/16/2017  motor2.setPower(motor2.getPower()/ratio)
            motor1.setPower(motor1.getPower() * ratio);
        }
    }
}
