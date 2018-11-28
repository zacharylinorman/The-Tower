package com.charizard832.tower.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.charizard832.tower.util.AssetLoader;
import com.charizard832.tower.util.Constants;
import com.charizard832.tower.util.Direction;
import com.charizard832.tower.util.Util;

public class MovePad extends UIComponent{

    private Direction direction;
    private boolean visible;
    private float circleXOffset, circleYOffset;

    public MovePad(){
        super(0, 0, 0, 0);
        circleXOffset = 0;
        circleYOffset = 0;
        direction = Direction.NONE;
        visible = false;
    }


    public void update(float delta){
        super.update(delta);
        circleXOffset = Util.clamp(circleXOffset, -AssetLoader.moveCircle.getRegionWidth()-AssetLoader.moveArrowUp.getRegionHeight()/2, AssetLoader.moveCircle.getRegionWidth()+AssetLoader.moveArrowUp.getRegionHeight()/2);
        circleYOffset = Util.clamp(circleYOffset, -AssetLoader.moveCircle.getRegionWidth()-AssetLoader.moveArrowUp.getRegionHeight()/2, AssetLoader.moveCircle.getRegionWidth()+AssetLoader.moveArrowUp.getRegionHeight()/2);
    }

    @Override
    public void render(float delta, int keyFrame, SpriteBatch batch) {
        if(visible) {
            switch (direction) {
                case NONE:
                    //up
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveCircle.getRegionHeight() - AssetLoader.moveArrowUp.getRegionHeight() / 2);
                    //down
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() + AssetLoader.moveCircle.getRegionHeight() + AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, 0, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 180);
                    //left
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, -90);
                    //right
                    batch.draw(AssetLoader.moveArrowUp, getX() + AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 90);
                    batch.draw(AssetLoader.moveCircle, getX() - AssetLoader.moveCircle.getRegionWidth() / 2 + circleXOffset, getY() - AssetLoader.moveCircle.getRegionHeight() / 2 + circleYOffset);
                    break;
                case RIGHT:
                    //up
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveCircle.getRegionHeight() - AssetLoader.moveArrowUp.getRegionHeight() / 2);
                    //down
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() + AssetLoader.moveCircle.getRegionHeight() + AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, 0, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 180);
                    //left
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, -90);
                    //right
                    batch.draw(AssetLoader.moveArrowDown, getX() + AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 90);
                    batch.draw(AssetLoader.moveCircle, getX() - AssetLoader.moveCircle.getRegionWidth() / 2 + circleXOffset, getY() - AssetLoader.moveCircle.getRegionHeight() / 2 + circleYOffset);
                    break;
                case LEFT:
                    //up
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveCircle.getRegionHeight() - AssetLoader.moveArrowUp.getRegionHeight() / 2);
                    //down
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() + AssetLoader.moveCircle.getRegionHeight() + AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, 0, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 180);
                    //left
                    batch.draw(AssetLoader.moveArrowDown, getX() - AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, -90);
                    //right
                    batch.draw(AssetLoader.moveArrowUp, getX() + AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 90);
                    batch.draw(AssetLoader.moveCircle, getX() - AssetLoader.moveCircle.getRegionWidth() / 2 + circleXOffset, getY() - AssetLoader.moveCircle.getRegionHeight() / 2 + circleYOffset);
                    break;
                case DOWN:
                    //up
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveCircle.getRegionHeight() - AssetLoader.moveArrowUp.getRegionHeight() / 2);
                    //down
                    batch.draw(AssetLoader.moveArrowDown, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() + AssetLoader.moveCircle.getRegionHeight() + AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, 0, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 180);
                    //left
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, -90);
                    //right
                    batch.draw(AssetLoader.moveArrowUp, getX() + AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 90);
                    batch.draw(AssetLoader.moveCircle, getX() - AssetLoader.moveCircle.getRegionWidth() / 2 + circleXOffset, getY() - AssetLoader.moveCircle.getRegionHeight() / 2 + circleYOffset);
                    break;
                case UP:
                    //up
                    batch.draw(AssetLoader.moveArrowDown, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveCircle.getRegionHeight() - AssetLoader.moveArrowUp.getRegionHeight() / 2);
                    //down
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() + AssetLoader.moveCircle.getRegionHeight() + AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, 0, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 180);
                    //left
                    batch.draw(AssetLoader.moveArrowUp, getX() - AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, -90);
                    //right
                    batch.draw(AssetLoader.moveArrowUp, getX() + AssetLoader.moveCircle.getRegionWidth() - AssetLoader.moveArrowUp.getRegionWidth() / 2, getY() - AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth() / 2, AssetLoader.moveArrowUp.getRegionHeight() / 2, AssetLoader.moveArrowUp.getRegionWidth(), AssetLoader.moveArrowUp.getRegionHeight(), 1, 1, 90);
                    batch.draw(AssetLoader.moveCircle, getX() - AssetLoader.moveCircle.getRegionWidth() / 2 + circleXOffset, getY() - AssetLoader.moveCircle.getRegionHeight() / 2 + circleYOffset);
                    break;
            }
        }

    }

    @Override
    public void touchDown(int screenX, int screenY) {
        if(screenX <= Constants.SCREEN_WIDTH/2) {
            setX(screenX);
            setY(screenY);
            visible = true;
        }
    }

    @Override
    public void touchUp(int screenX, int screenY) {
        visible = false;
        direction = Direction.NONE;
        circleXOffset = 0;
        circleYOffset = 0;
    }

    @Override
    public void touchDragged(int screenX, int screenY) {
        if(visible){
            circleXOffset = screenX-(int)getX();
            circleYOffset = screenY-(int)getY();
            if(Math.abs(circleXOffset) >= Math.abs(circleYOffset)){
                if(circleXOffset>AssetLoader.moveCircle.getRegionWidth()/6){
                    direction = Direction.RIGHT;
                }else if(circleXOffset<-AssetLoader.moveCircle.getRegionWidth()/6){
                    direction = Direction.LEFT;
                }else{
                    direction = Direction.NONE;
                }
            }else{
                if(circleYOffset>AssetLoader.moveCircle.getRegionWidth()/6){
                    direction = Direction.DOWN;
                }else if(circleYOffset<-AssetLoader.moveCircle.getRegionWidth()/6){
                    direction = Direction.UP;
                }else{
                    direction = Direction.NONE;
                }
            }
        }
    }
    public Direction getDirection(){return direction;}

}
