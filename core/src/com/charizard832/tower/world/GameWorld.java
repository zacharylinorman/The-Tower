package com.charizard832.tower.world;

import com.charizard832.tower.entity.Enemy1;
import com.charizard832.tower.entity.Player;
import com.charizard832.tower.ui.ButtonJump;
import com.charizard832.tower.ui.MovePad;
import com.charizard832.tower.util.AssetLoader;
import com.charizard832.tower.util.Constants;
import com.charizard832.tower.util.EntityHandler;
import com.charizard832.tower.util.UIComponentHandler;


public class GameWorld {

    private int keyFrame;
    private GameRenderer gameRenderer;
    private UIComponentHandler uiButtons;
    private EntityHandler entityHandler;

    public GameWorld(){
        keyFrame = 0;

        uiButtons = new UIComponentHandler();
        uiButtons.add(new MovePad()); //0
        uiButtons.add(new ButtonJump()); //1

        entityHandler = new EntityHandler();
        entityHandler.add(new Player(Constants.SCREEN_WIDTH/2-AssetLoader.playerStanding.getRegionWidth()/2, Constants.SCREEN_HEIGHT-AssetLoader.playerStanding.getRegionHeight(), AssetLoader.playerStanding.getRegionWidth(), AssetLoader.playerStanding.getRegionHeight(), this));

        entityHandler.add(new Enemy1(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT-AssetLoader.enemy1.getRegionHeight()));
        entityHandler.add(new Enemy1(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT-AssetLoader.enemy1.getRegionHeight()));
        entityHandler.add(new Enemy1(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT-AssetLoader.enemy1.getRegionHeight()));
        entityHandler.add(new Enemy1(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT-AssetLoader.enemy1.getRegionHeight()));

        gameRenderer = new GameRenderer(this, entityHandler, uiButtons);
    }

    public void update(float delta){
        keyFrame++;
        uiButtons.update(delta);
        entityHandler.update(delta);
    }

    public void render(float delta){
        gameRenderer.render(delta, keyFrame);
    }

    public void touchDown(int screenX, int screenY){
        uiButtons.touchDown(screenX, screenY);
    }

    public void touchUp(int screenX, int screenY){
        uiButtons.touchUp(screenX, screenY);
    }

    public void touchDragged(int screenX, int screenY){
        uiButtons.touchDragged(screenX, screenY);
    }

    public EntityHandler getEntityHandler(){return entityHandler;}

    public ButtonJump getJumpButton(){return (ButtonJump) uiButtons.get(1);}

    public MovePad getMovePad() {
        return (MovePad) uiButtons.get(0);
    }

    public Player getPlayer(){ return (Player)entityHandler.get(0);}
}
