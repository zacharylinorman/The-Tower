package com.charizard832.tower.ui;

import com.charizard832.tower.entity.Entity;

public abstract class UIComponent extends Entity implements Clickable{

    public UIComponent(float x, float y, float width, float height){
        super(x, y, width, height);
    }

}
