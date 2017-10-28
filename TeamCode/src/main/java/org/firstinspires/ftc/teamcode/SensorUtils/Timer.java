package org.firstinspires.ftc.teamcode.SensorUtils;

/**
 * Created by Justin on 10/28/2017.
 */

public final class Timer implements Runnable {
    private long lastTime, currentTime;
    private long deltaTime;


    public Timer(){
        lastTime = System.currentTimeMillis();
        deltaTime = 0;
        this.run();
    }

    @Override
    public void run() {
        synchronized (this) {
            currentTime = System.currentTimeMillis();
            deltaTime = currentTime - lastTime;
            lastTime = currentTime;
        }
    }

    public long getDeltaTime(){
        synchronized (this){
        return deltaTime;
        }
    }

    public long getDeltaTimeAndReset(){
        synchronized (this) {
            long currentDeltaTime = deltaTime;
            deltaTime = 0;
            return currentDeltaTime;
        }
    }
}
