package com.charizard832.tower.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.charizard832.tower.util.AssetLoader;

public class Enemy1 extends Monster {

    public Enemy1(float x, float y){
        super(x, y, 3, 0, 0, 1, 3, new Sprite(AssetLoader.enemy1));

    }

}
