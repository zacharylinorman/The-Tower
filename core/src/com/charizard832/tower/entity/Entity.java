package com.charizard832.tower.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {


    private Vector2 position, velocity, acceleration;
    private float width, height;
    private Rectangle bounds;
    private boolean destroy;

    public Entity(float x_, float y_, float width_, float height_){
        position = new Vector2(x_, y_);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0,0);
        width = width_;
        height = height_;
        bounds = new Rectangle(position.x, position.y, width, height);
        destroy = false;
    }

    public abstract void render(float delta, int keyFrame, SpriteBatch batch);
    public void renderShape(float delta, int keyFrame, ShapeRenderer shapeRenderer){}

    public void update(float delta){
        position.add(velocity);
        velocity.add(acceleration);
        bounds.set(position.x, position.y, width, height);
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(float y) {
        position.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }
    public void setVelocity(float x, float y) {
        velocity.x = x;
        velocity.y = y;
    }

    public void setVelX(float x){
        velocity.x = x;
    }

    public void setVelY(float y){
        velocity.y = y;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }
    public void setAcceleration(float x, float y){
        acceleration.x = x;
        acceleration.y = y;
    }

    public void setAccX(float x){
        acceleration.x = x;
    }

    public void setAccY(float y){
        acceleration.y = y;
    }

}
