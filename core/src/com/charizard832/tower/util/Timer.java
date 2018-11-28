package com.charizard832.tower.util;

public class Timer {


    private boolean[] startOfTimer;
    private double[] timerCount, startTime, idleTime;

    public Timer(int numOfTimers){
        startOfTimer = new boolean[numOfTimers];
        timerCount = new double[numOfTimers];
        startTime = new double[numOfTimers];
        idleTime = new double[numOfTimers];

        for(int i = 0; i < numOfTimers; i++){
            startOfTimer[i] = false;
            timerCount[i] = 0;
            startTime[i] = 0;
            idleTime[i] = 0;
        }

    }

    public boolean getTimer(int id, double time){
        if(!startOfTimer[id]){
            startOfTimer[id] = true;
            startTime[id] = System.currentTimeMillis()/1000;
            idleTime[id] = time;
            return false;
        }else if(timerCount[id] < idleTime[id]){
            timerCount[id] = System.currentTimeMillis()/1000 - startTime[id];
            return false;
        }else{
            startOfTimer[id] = false;
            timerCount[id] = 0;
            return true;
        }
    }
    public boolean getTimer(int id, int minTime, int maxTime){
        if(!startOfTimer[id]){
            startOfTimer[id] = true;
            startTime[id] = System.currentTimeMillis()/1000;
            idleTime[id] = Util.getRandomInt(minTime, maxTime);
            return false;
        }else if(timerCount[id] < idleTime[id]){
            timerCount[id] = System.currentTimeMillis()/1000 - startTime[id];
            return false;
        }else{
            startOfTimer[id] = false;
            timerCount[id] = 0;
            return true;
        }
    }

}
