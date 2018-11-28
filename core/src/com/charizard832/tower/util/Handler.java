package com.charizard832.tower.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.charizard832.tower.entity.Entity;

import java.util.ArrayList;

public abstract class Handler<T> {


    private ArrayList<T> entities;

    private ArrayList<T> removeList;

    public Handler(){

        entities = new ArrayList<T>();
        removeList = new ArrayList<T>();
    }

    public void add(T t){
        entities.add(t);
    }

    public void remove(T t){
        entities.remove(t);
    }

    public void update(float delta){
        for(T t : entities){
            if(t instanceof Entity) {
                ((Entity) t).update(delta);
                if(((Entity) t).isDestroy()){
                    removeList.add(t);
                }
            }
        }
        if(removeList.size()>0){
            for(T t : removeList){
                entities.remove(t);
            }
            removeList.clear();
        }
    }

    public void render(float delta, int keyFrame, SpriteBatch batch){
        for(T t : entities){
            if(t instanceof Entity)
                ((Entity)t).render(delta, keyFrame, batch);
        }
    }

    public void renderShape(float delta, int keyFrame, ShapeRenderer shapeRenderer){
        for(T t : entities){
            if(t instanceof Entity)
                ((Entity)t).renderShape(delta, keyFrame, shapeRenderer);
        }
    }

    public T get(int index){
        return entities.get(index);
    }


    public ArrayList<T> getEntities() {
        return entities;
    }
    
}
