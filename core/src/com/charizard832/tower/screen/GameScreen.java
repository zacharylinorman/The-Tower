package com.charizard832.tower.screen;

import com.badlogic.gdx.Screen;
import com.charizard832.tower.world.GameWorld;

public class GameScreen implements Screen {

    private boolean inFocus;
    private GameWorld gameWorld;

    public GameScreen(){
        inFocus = false;
        gameWorld = new GameWorld();
    }

    public void touchDown(int screenX, int screenY){
        gameWorld.touchDown(screenX, screenY);
    }

    public void touchUp(int screenX, int screenY){
        gameWorld.touchUp(screenX, screenY);
    }

    public void touchDragged(int screenX, int screenY){
        gameWorld.touchDragged(screenX, screenY);
    }

    public void setInFocus(boolean inFocus_){inFocus = inFocus_;}
    public boolean isInFocus(){return inFocus;}

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(inFocus){
            gameWorld.update(delta);
            gameWorld.render(delta);
        }
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
