package org.firstinspires.ftc.teamcode.CustomOpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.CustomHardwareMap;
import org.firstinspires.ftc.teamcode.SensorUtils.Timer;

/**
 * Created by Justin on 10/28/2017.
 */

public abstract class LinearCustomOpMode extends LinearOpMode {
    protected Timer timer = new Timer();
    protected CustomHardwareMap robot = CustomHardwareMap.getInstance();
    protected ElapsedTime runtime = new ElapsedTime();
}