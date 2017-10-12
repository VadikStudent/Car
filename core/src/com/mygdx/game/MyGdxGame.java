package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.view.GameScreen;

public class MyGdxGame extends Game {

    private Screen gameScreen;
    @Override
    public void create(){
        gameScreen = new GameScreen();
        setScreen(gameScreen);
    }
}
