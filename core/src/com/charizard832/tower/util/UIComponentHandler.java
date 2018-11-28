package com.charizard832.tower.util;

import com.charizard832.tower.ui.UIComponent;

public class UIComponentHandler extends Handler<UIComponent> {

    public void touchDown(int screenX, int screenY){
        for(UIComponent u : getEntities()) {
            u.touchDown(screenX, screenY);
        }
    }


    public void touchUp(int screenX, int screenY){
        for(UIComponent u : getEntities()) {
            u.touchUp(screenX, screenY);
        }
    }


    public void touchDragged(int screenX, int screenY){
        for(UIComponent u : getEntities()){
            u.touchDragged(screenX, screenY);
        }
    }
}
