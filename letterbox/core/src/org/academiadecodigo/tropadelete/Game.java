package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.gameobjects.CollisionDetector;
import org.academiadecodigo.tropadelete.gameobjects.Letter;
import org.academiadecodigo.tropadelete.gameobjects.LetterBox;
import org.academiadecodigo.tropadelete.gameobjects.Player;
import org.w3c.dom.css.Rect;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private LetterBox letterBox;
    private CollisionDetector collisionDetector;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private Letter[] initialLetters;

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Player(new Texture("badlogic.jpg"), new Rectangle());
        letterBox = new LetterBox("CACA");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        inputHandler = new InputHandler(player);

        collisionDetector = new CollisionDetector(letterBox, player);
        initialLetters = new Letter[5];
        spawnLetters();
    }

    @Override
    public void render() {

        updateCamera();
        createImage();
        inputHandler.keyboardListener();
        player.jump();
        collisionDetector.checkCollision();
    }


    @Override
    public void dispose() {

        batch.dispose();
        player.dispose();
    }

    private void updateCamera() {
        camera.position.x = player.getHitbox().x;
        camera.position.y = player.getHitbox().y + 800 / 4; // look magic number to push camera up
        camera.update();

    }


    private void createImage() {

        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(new Texture("back.jpg"), 0, 0);

        int index = 0;
        for (int i = 0; i < letterBox.getLetters().length; i++) {
            batch.draw(letterBox.getLetters()[i], camera.position.x + index, camera.position.y + 100);
            index += 112;
        }

        for (Letter letter : initialLetters) {

            batch.draw(letter.getImg(), letter.getX(), letter.getY());
        }

        batch.draw(player.getImg(), player.getX(), player.getY());

        batch.end();

    }

    private void spawnLetters() {

        for (int i = 0; i < 5; i++) {
            LetterType letterType = randomLetter();
            initialLetters[i] = new Letter(letterType.getTexture(), letterType.getCharLetter(), (int)Math.floor(Math.random() * 1000), 0);

        }
    }

    private LetterType randomLetter() {

        return LetterType.values()[(int)Math.floor(Math.random() * LetterType.values().length)];
    }
}
