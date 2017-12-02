package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.CustomOpMode.LinearCustomOpMode;
import org.firstinspires.ftc.teamcode.Movement.MovementLib;

/**
 * Created by josephodeh on 12/1/17.
 */

@Autonomous(name = "Blue Corner", group = "Blue and Red OpModes")
public class BlueCornerOpMode extends LinearCustomOpMode {
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.getColorServo().setPosition(0.31);

        waitForStart();
        runtime.reset();
        ColorSensor sensor = robot.getColorSensor();

        MovementLib.lowerCServo(this);
        sleep(100);
        double result = 0;
        for (int i = 0; i < 50 ; i++) {
            int rColor = sensor.red();
            int bColor = sensor.blue();
            telemetry.addData("Blue", bColor);
            telemetry.addData("Red", rColor);
            telemetry.update();
            result += bColor - rColor;
        }

        if (result/50 > 0) {
            MovementLib.forward(3, .2, this);
            MovementLib.raiseCServo(this);
            MovementLib.forward(-25, .2, this);

        }
        else {
            MovementLib.forward(-3, .2, this);
            MovementLib.raiseCServo(this);
            MovementLib.forward(-19, .2, this);
        }

        try {
            MovementLib.rotate(-90, .75, this);
            MovementLib.forward(5, .75, this);
            MovementLib.rotate(-90, .75, this);
            MovementLib.rotateArm(-10, .2, this);
            MovementLib.openArm(this);
            MovementLib.rotateArm(32, .2, this);
            MovementLib.closeArm(this);
            MovementLib.rotateArm(-190, .2, this);
            MovementLib.openArm(this);
            sleep(2000);
            MovementLib.rotateArm(60, .2, this);
            MovementLib.closeArm(this);
            MovementLib.rotateArm(110, .2, this);
            sleep(2000);
            MovementLib.forward(15, .2, this);

        } catch (NullPointerException NPE) {
            telemetry.addData("Error", NPE.getMessage());
            telemetry.update();
        }
    }
}