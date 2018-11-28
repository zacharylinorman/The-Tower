package com.charizard832.tower.floor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.charizard832.tower.entity.Entity;
import com.charizard832.tower.entity.Player;
import com.charizard832.tower.world.GameWorld;

public class Platform extends Entity {

    private TextureAtlas.AtlasRegion texture;
    private GameWorld gameWorld;
    private boolean playerOnTop;

    public Platform(float x, float y, TextureAtlas.AtlasRegion texture_, GameWorld gameWorld_){
        super(x, y, texture_.getRegionWidth(), texture_.getRegionHeight());
        texture = texture_;
        gameWorld = gameWorld_;
        playerOnTop = false;
    }

    @Override
    public void update(float delta){
        super.update(delta);
        if(playerOnTop(gameWorld.getPlayer())){
            playerOnTop = true;
        }else{
            playerOnTop = false;
        }
    }

    private boolean playerOnTop(Player player){
        if(player.getY()+player.getHeight()>=getY()&&player.getX()+player.getWidth()>getX()&&player.getX()<getX()+getWidth()){
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta, int keyFrame, SpriteBatch batch) {

    }
}
