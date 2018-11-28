package com.charizard832.tower;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.charizard832.tower.screen.GameScreen;
import com.charizard832.tower.screen.MenuScreen;
import com.charizard832.tower.util.AssetLoader;
import com.charizard832.tower.util.InputHandler;

public class TheTower extends Game {

	private InputHandler ih;
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private int screen;

	@Override
	public void create() {
		AssetLoader.load();
		ih = new InputHandler(this);
		menuScreen = new MenuScreen(ih, this);
		gameScreen = new GameScreen();
		Gdx.input.setInputProcessor(ih);
		setGameScreen();
		screen = 0;
	}

	public void setMenuScreen(){
		gameScreen.setInFocus(false);
		setScreen(menuScreen);
		System.out.println("testerino1");
		screen = 0;
	}

	public void setGameScreen(){
		gameScreen.setInFocus(true);
		setScreen(gameScreen);
		System.out.println("testerino2");
		screen = 1;
	}

	public void touchDown(int screenX, int screenY){
		switch(screen){
			case 0:
				menuScreen.touchDown(screenX, screenY);
				break;
			case 1:
				gameScreen.touchDown(screenX, screenY);
				break;
		}
    }

    public void touchUp(int screenX, int screenY){
		switch(screen){
			case 0:
				menuScreen.touchUp(screenX, screenY);
				break;
			case 1:
				gameScreen.touchUp(screenX, screenY);
				break;
		}
    }


    public void touchDragged(int screenX, int screenY){
		switch(screen){
			case 1:
				gameScreen.touchDragged(screenX, screenY);
				break;
		}
	}
	@Override
	public void dispose() {
		AssetLoader.dispose();
	}
}
