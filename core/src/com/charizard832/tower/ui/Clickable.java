package com.charizard832.tower.ui;

public interface Clickable {

    void touchDown(int screenX, int screenY);
    void touchUp(int screenX, int screenY);
    void touchDragged(int screenX, int screenY);
}
