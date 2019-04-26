package org.academiadecodigo.tropadelete;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.tropadelete.gameobjects.Player;

public class InputHandler {

    private Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    public void keyboardListenerX() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

            player.moveRight();
            return;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            player.moveLeft();
            return;
        }

        player.setStill(GlobalVariables.RIGHT_RUNNING_TEXTURES[0]);


    }

    public void keyboardListenerY() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

            player.setJump(true);

        }
    }

}
