package com.charizard832.tower.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.charizard832.tower.util.Timer;
import com.charizard832.tower.util.Util;


public abstract class Monster extends Entity {

    private int currentHP, maxHP, defense, magicDefense, touchDamage;
    private Sprite sprite;

    private int phase;

    private Timer timer;

    private int minIdleTime, maxIdleTime, minTravelTime, maxTravelTime;
    private boolean faceLeft;

    private float speed;

    public Monster(float x, float y, int maxHP_, int defense_, int magicDefense_, int touchDamage_, float speed_, Sprite sprite_){
        super(x, y, sprite_.getRegionWidth(), sprite_.getRegionHeight());

        maxHP = maxHP_;
        currentHP = maxHP;
        defense = defense_;
        magicDefense = magicDefense_;
        touchDamage = touchDamage_;
        speed = speed_;
        sprite = sprite_;

        timer = new Timer(1);

        if(Util.getRandomInt(0, 1)==1)
            phase = 0;
        else
            phase = 2;


        minIdleTime = 0;
        maxIdleTime = 2;

        minTravelTime = 2;
        maxTravelTime = 3;

        faceLeft = true;


    }

    @Override
    public void render(float delta, int keyFrame, SpriteBatch batch) {


        switch (phase){
            case 1:
                if(faceLeft){
                    faceLeft = false;
                    sprite.flip(true, false);
                }
                break;
            case 3:
                if(!faceLeft){
                    faceLeft = true;
                    sprite.flip(true, false);
                }
                break;

        }
        batch.draw(sprite, getX(), getY());
    }

    @Override
    public void renderShape(float delta, int keyFrame, ShapeRenderer shapeRenderer){

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(getX(), getY()-50, sprite.getRegionWidth(), 2);
        shapeRenderer.rect(getX(), getY()-22, sprite.getRegionWidth(), 2);
        shapeRenderer.rect(getX(), getY()-50, 2, 30);
        shapeRenderer.rect(getX()+sprite.getRegionWidth()-2, getY()-50, 2, 30);
        shapeRenderer.setColor(0, 255, 0, 1);
        shapeRenderer.rect(getX()+2, getY()-48, ((float)currentHP/(float)maxHP)*(sprite.getRegionWidth()-4), 26);
        shapeRenderer.end();


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(getBounds().x, getBounds().y, getBounds().width, getBounds().height);
        shapeRenderer.end();
    }

    @Override
    public void update(float delta){
        super.update(delta);
        if(currentHP == 0){
            setDestroy(true);
            return;
        }

        switch(phase){
            case 0:
                if(timer.getTimer(0, minIdleTime, maxIdleTime)){
                    phase++;
                }
                break;
            case 1:
                if(timer.getTimer(0, minTravelTime, maxTravelTime)){
                    phase++;
                }else {
                    setX(getX() + speed);
                }
                break;
            case 2:
                if(timer.getTimer(0, minIdleTime, maxIdleTime)){
                    phase++;
                }
                break;
            case 3:
                if(timer.getTimer(0, minTravelTime, maxTravelTime)){
                    phase = 0;
                }else {
                    setX(getX() - speed);
                }
                break;
        }

    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getTouchDamage() {
        return touchDamage;
    }

    public void setTouchDamage(int touchDamage) {
        this.touchDamage = touchDamage;
    }
}

