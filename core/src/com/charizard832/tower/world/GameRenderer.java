package com.charizard832.tower.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.charizard832.tower.ui.UIComponent;
import com.charizard832.tower.util.Constants;
import com.charizard832.tower.util.EntityHandler;
import com.charizard832.tower.util.UIComponentHandler;

import java.util.ArrayList;

public class GameRenderer {

    private GameWorld gameWorld;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    private ShapeRenderer shapeRenderer;

    private EntityHandler entityHandler;
    private UIComponentHandler uiComponentHandler;

    public GameRenderer(GameWorld gameWorld_, EntityHandler entityHandler_, UIComponentHandler uiComponentHandler_){
        gameWorld = gameWorld_;
        entityHandler = entityHandler_;
        uiComponentHandler = uiComponentHandler_;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.enableBlending();


        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        //Gdx.gl.glLineWidth(2);
    }

    public void render(float delta, int keyFrame){
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        entityHandler.render(delta, keyFrame, spriteBatch);
        uiComponentHandler.render(delta, keyFrame, spriteBatch);
        spriteBatch.end();

        entityHandler.renderShape(delta, keyFrame, shapeRenderer);
        uiComponentHandler.renderShape(delta, keyFrame, shapeRenderer);

    }

}
