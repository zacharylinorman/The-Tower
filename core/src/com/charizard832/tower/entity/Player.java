package com.charizard832.tower.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.charizard832.tower.util.AssetLoader;
import com.charizard832.tower.util.Constants;
import com.charizard832.tower.util.Direction;
import com.charizard832.tower.util.Timer;
import com.charizard832.tower.util.Util;
import com.charizard832.tower.world.GameWorld;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

public class Player extends  Entity {

    private Direction direction;
    private GameWorld gameWorld;
    private Sprite sprite;
    private Timer timer;

    private boolean invincible, inAir;

    private int currentHP, maxHP, defense, magicDefense;

    private float xSpeed, jumpSpeed;

    public Player(float x, float y, float width, float height, GameWorld gameWorld_){
        super(x, y, width, height);
        direction = Direction.NONE;
        gameWorld = gameWorld_;
        sprite = new Sprite(AssetLoader.playerStanding);
        timer = new Timer(2);

        maxHP = 50;
        currentHP = maxHP;
        defense = 0;
        magicDefense = 0;

        xSpeed = 5;
        jumpSpeed = 20;

        invincible = false;
        inAir = false;
    }

    @Override
    public void render(float delta, int keyFrame, SpriteBatch batch) {
        //System.out.println(invincible);
        if(invincible){
            sprite.setAlpha((float)(Math.abs(Math.cos((float)(keyFrame)/(float)2))));
        }else{
            sprite.setAlpha(1);
        }
        sprite.draw(batch);
    }

    @Override
    public void renderShape(float delta, int keyFrame, ShapeRenderer shapeRenderer){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(getX(), getY()-50, sprite.getRegionWidth(), 2);
        shapeRenderer.rect(getX(), getY()-22, sprite.getRegionWidth(), 2);
        shapeRenderer.rect(getX(), getY()-50, 2, 30);
        shapeRenderer.rect(getX()+sprite.getRegionWidth()-2, getY()-50, 2, 30);
        shapeRenderer.setColor(255, 0, 0, 1);
        shapeRenderer.rect(getX()+2, getY()-48, ((float)currentHP/(float)maxHP)*(sprite.getRegionWidth()-4), 26);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
        shapeRenderer.end();
    }

    @Override
    public void update(float delta){
        super.update(delta);
        direction = gameWorld.getMovePad().getDirection();
        switch (direction){
            case UP:
                setVelX(0);
                break;
            case DOWN:
                setVelX(0);
                break;
            case LEFT:
                setVelX(-xSpeed);
                break;
            case RIGHT:
                setVelX(xSpeed);
                break;
            case NONE:
                setVelX(0);
                break;
        }
        sprite.setX(getX());
        sprite.setY(getY());

        if(!inAir){
            setVelY(0);
            if (gameWorld.getJumpButton().isJumpDown()) {
                inAir = true;
                setVelY(-jumpSpeed);
                setAccY(1);
            }
        }else{
            inAir = getY()+getHeight() < Constants.SCREEN_HEIGHT-10;
        }

        if(!invincible) {
            for (Entity e : gameWorld.getEntityHandler().getEntities()) {
                if (e instanceof Monster) {
                    Monster m = (Monster) e;
                    if (Util.intersects(getBounds(), m.getBounds())) {
                        invincible = true;
                        currentHP -= m.getTouchDamage()-defense;
                        break;
                    }
                }
            }
        }else{
            invincible = !timer.getTimer(0, 1);
        }
    }

    public void setDirection(Direction direction_){direction = direction_;}
}
