package com.charizard832.tower.screen;

import com.badlogic.gdx.Screen;
import com.charizard832.tower.util.InputHandler;
import com.charizard832.tower.TheTower;

public class MenuScreen implements Screen {

    private InputHandler ih;
    private TheTower tt;

    public MenuScreen(InputHandler ih_, TheTower tt_){
        ih = ih_;
        tt = tt_;
    }

    @Override
    public void show() {

    }
    public void touchDown(int screenX, int screenY){

    }

    public void touchUp(int screenX, int screenY){
        tt.setGameScreen();
    }
    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
