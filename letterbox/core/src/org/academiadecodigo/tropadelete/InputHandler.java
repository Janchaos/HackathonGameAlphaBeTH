package org.academiadecodigo.tropadelete;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler {

    private Player player;

    //Falta o player
    public void keyboardListener() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            player.moveRight();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            player.moveLeft();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

            player.jump();
        }
    }

}
