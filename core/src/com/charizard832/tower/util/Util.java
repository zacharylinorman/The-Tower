package com.charizard832.tower.util;

import com.badlogic.gdx.math.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static float clamp(float x, float min, float max){
        if(x<min)
            return min;
        if(x>max)
            return max;
        return x;
    }

    public static int clamp(int x, int min, int max){
        if(x<min)
            return min;
        if(x>max)
            return max;
        return x;
    }

    public static int getRandomInt(int start, int endBound){
        return ThreadLocalRandom.current().nextInt(start, endBound+1);
    }

    public static boolean intersects(Rectangle a, Rectangle b){
        if((a.getX()<=b.getX()&&a.getX()+a.getWidth()>=b.getX())||(b.getX()<=a.getX()&&b.getX()+b.getWidth()>=a.getX())
                &&
                (a.getY()<=b.getY()&&a.getY()+a.getHeight()>=b.getY()||b.getY()<=a.getY()&&b.getY()+b.getHeight()>=a.getY())){
            return  true;
        }
        return false;
    }

}
