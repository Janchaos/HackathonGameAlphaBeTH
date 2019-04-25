package org.academiadecodigo.tropadelete;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.tropadelete.gameobjects.Player;

public class InputHandler {

    private Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    public void keyboardListener() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            player.moveRight();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            player.moveLeft();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

            player.setJump(true);

        }
    }

}
