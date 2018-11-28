package com.charizard832.tower.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class AssetLoader {

    public static TextureAtlas ui, player, enemies;
    public static AtlasRegion
            moveArrowUp, moveArrowDown,
            moveCircle,
            jumpButtonUp,
            jumpButtonDown,
            playerStanding,
            enemy1
                    ;

    public static void load(){
        ui = new TextureAtlas(Gdx.files.internal("theTowerUI.atlas"));
        player = new TextureAtlas(Gdx.files.internal("player.atlas"));
        enemies = new TextureAtlas(Gdx.files.internal("enemies.atlas"));

        //ui
        moveArrowUp = a(ui, "arrowButtonUp");
        moveArrowDown = a(ui, "arrowButtonDown");
        moveCircle = a(ui, "moveCircle");

        jumpButtonUp = a(ui, "jumpButtonUp");
        jumpButtonDown = a(ui, "jumpButtonDown");

        //player
        playerStanding = a(player, "characterStand");

        //enemies
        enemy1 = a(enemies, "enemy1");
    }

    private static AtlasRegion a(TextureAtlas atlas, String name){
        AtlasRegion temp = atlas.findRegion(name);
        temp.flip(false, true);
        return temp;
    }

    public static void dispose(){
        ui.dispose();
        player.dispose();
        enemies.dispose();
    }

}
