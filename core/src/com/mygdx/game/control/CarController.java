package com.mygdx.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.view.GameScreen;

/**
 * Created by Вадик on 11.10.2017.
 */

public class CarController {
    private Polygon carBounds;

    public CarController (Polygon carBounds) {
        this.carBounds = carBounds;
    }

    float carSpeed, velocity = 10f, speedMax = 10f;
    private  float rotationSpeed = 30f;
    public void handle(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            carSpeed += velocity * GameScreen.deltaCff;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            carSpeed -= velocity * GameScreen.deltaCff;
        }
        else{
            downSpeed();
        }
        carSpeed = sliceSpead();

        //все, что связано с поворотом
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCff);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCff);
        }
        ///

        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCff,
                            carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() +90) * carSpeed * GameScreen.deltaCff);
    }
    //гасим скорость
    private void downSpeed(){
        if(carSpeed > velocity * GameScreen.deltaCff){
            carSpeed -= velocity * GameScreen.deltaCff;
        }
        else if(carSpeed < velocity * GameScreen.deltaCff){
            carSpeed += velocity * GameScreen.deltaCff;
        }
        else{
            carSpeed = 0f;
        }
    }
    //добавляем ограничение на скорость
    private float sliceSpead(){
        if(carSpeed > speedMax){
            return speedMax;
        }
        if(carSpeed < -speedMax){
            return -speedMax;
        }
        return carSpeed;
    }
}
