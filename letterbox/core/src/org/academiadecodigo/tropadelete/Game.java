package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.gameobjects.Player;
import org.w3c.dom.css.Rect;

import java.sql.ResultSet;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Player player;
    InputHandler inputHandler;
    OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();


        player = new Player(new Texture("player_girl/step1_girl.png"), new Rectangle());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        inputHandler = new InputHandler(player);


    }

    @Override
    public void render() {

        updateCamera();

        createImage();
        inputHandler.keyboardListener();
        player.jump();

    }


    @Override
    public void dispose() {

        batch.dispose();
        player.dispose();
    }

    private void updateCamera() {
        camera.position.x = player.getHitbox().x;
        camera.position.y = player.getHitbox().y;
        camera.update();

    }


    private void createImage() {


        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(new Texture("back.jpg"), -450, -350);
        batch.draw(player.getImg(), player.getX(), player.getY());

        batch.end();

    }
}
