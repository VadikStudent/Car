package com.mygdx.game.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

/**
 * Created by Вадик on 11.10.2017.
 */

public abstract class GameObject {

    Polygon bounds;
    //item-img
    Sprite object;
    public GameObject(Texture texture, float x, float y, float width, float height){

        //спрайт
        object = new Sprite(texture);
        //размеры
        object.setSize(width, height);
        //позииця
        object.setPosition(x,y);
        object.setOrigin(width/2f, height/2f);

        //полигон
        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        //центр поворота
        bounds.setOrigin(width/2f, height/2f);
        //задаем позицию
        bounds.setPosition(x,y);
    }

    public void draw(SpriteBatch batch){
        object.setPosition(bounds.getX(),bounds.getY());
        object.setRotation(bounds.getRotation());
        object.draw(batch);
    }

    public Polygon getBounds() {
        return bounds;
    }

}
