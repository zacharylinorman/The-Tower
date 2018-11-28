package com.charizard832.tower.floor;

import java.util.ArrayList;
import java.util.List;

public abstract class Floor {

    private List<Platform> platforms;
    private int floorNum;

    public Floor(int floorNum_){
        platforms = new ArrayList<Platform>();
        floorNum = floorNum_;
    }


    public int getFloorNum(){return floorNum;}
}
