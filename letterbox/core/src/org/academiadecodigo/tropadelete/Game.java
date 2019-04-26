package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.gameobjects.*;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private LetterBox letterBox;
    private CollisionDetector collisionDetector;
    private Platform [] platforms;

    @Override
    public void create() {

        batch = new SpriteBatch();
        player = new Player(new Texture("player_girl/step1_girl.png"), new Rectangle());
        letterBox = new LetterBox("A");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        inputHandler = new InputHandler(player);
        loadPlatforms();


        collisionDetector = new CollisionDetector(letterBox, player,platforms);

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
        for (Letter letter : letterBox.getLetters()){
            batch.draw(letter.getImg(),letter.getX(),letter.getY());
        }
        batch.draw(player.getImg(), player.getX(), player.getY());

        batch.end();

    }

    private void loadPlatforms(){
        platforms = new Platform[1];
        platforms[0] = new Platform(new Texture("/letras/m.png"),new Rectangle());
    }

    private void renderPlatforms (){

    }
}
