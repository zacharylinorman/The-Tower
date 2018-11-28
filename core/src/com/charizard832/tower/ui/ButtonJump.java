package com.charizard832.tower.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.charizard832.tower.util.AssetLoader;
import com.charizard832.tower.util.Constants;

public class ButtonJump extends UIComponent implements Clickable{

    private TextureAtlas.AtlasRegion sprite;
    private boolean jumpDown;

    public ButtonJump(){
        super(Constants.SCREEN_WIDTH-AssetLoader.jumpButtonUp.getRegionWidth(), Constants.SCREEN_HEIGHT-AssetLoader.jumpButtonUp.getRegionHeight(), AssetLoader.jumpButtonUp.getRegionWidth(), AssetLoader.jumpButtonUp.getRegionHeight());
        sprite = AssetLoader.jumpButtonUp;
        jumpDown = false;
    }

    @Override
    public void render(float delta, int keyFrame, SpriteBatch batch) {
        batch.draw(sprite, getX(), getY());
    }

    @Override
    public void touchDown(int screenX, int screenY) {
        if(getBounds().contains(screenX, screenY)) {
            jumpDown = true;
            sprite = AssetLoader.jumpButtonDown;
        }
    }

    @Override
    public void touchUp(int screenX, int screenY) {
        if(getBounds().contains(screenX, screenY)) {
            jumpDown = false;
            sprite = AssetLoader.jumpButtonUp;
        }
    }

    @Override
    public void touchDragged(int screenX, int screenY) {

    }

    public boolean isJumpDown(){
        return jumpDown;
    }
}
