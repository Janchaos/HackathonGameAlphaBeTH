package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.gameobjects.*;

import java.util.LinkedList;


public class Game extends ApplicationAdapter {
    private SpriteBatch batch;
    private Player player;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private LetterBox letterBox;
    private CollisionDetector collisionDetector;
    private LinkedList<Letter> letters;
    private Platform[] platforms;
    private Texture[] background;

    @Override
    public void create() {

        batch = new SpriteBatch();
        player = new Player(GlobalVariables.RIGHT_RUNNING_TEXTURES[0], new Rectangle());
        letterBox = new LetterBox();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        inputHandler = new InputHandler(player);
        letters = letterBox.splitWord("HELLO");

        collisionDetector = new CollisionDetector(letters, player, platforms,letterBox);

        background = new Texture[]{GlobalVariables.SKY, GlobalVariables.GROUND,
                GlobalVariables.SIERRA, GlobalVariables.BUSH};
        loadPlatforms();
    }

    @Override
    public void render() {

        updateCamera();


        createImage();
        inputHandler.keyboardListenerX();
        inputHandler.keyboardListenerY();
        player.jump();
        collisionDetector.checkCollision();
        System.out.println(letterBox.asWon());
    }


    @Override
    public void dispose() {

        for (Letter letter : letters) {
            letter.dispose();
        }
        batch.dispose();
        player.dispose();
    }

    private void updateCamera() {
        camera.position.x = player.getHitbox().x;
        camera.position.y = player.getHitbox().y + 800 / 4; // look magic number to push camera up
        camera.update();

    }


    private void createImage() {

        float x = 0;

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        drawBackground();
        renderPlatforms();
        renderLetters();

        int index = 0;
        for (int i = 0; i < letterBox.getLetters().length; i++) {
            batch.draw(letterBox.getLetters()[i], camera.position.x + index - 300, camera.position.y + 100);
            System.out.println(camera.position.x);
            index += 112;
        }

        for (Letter letter : letters) {

            batch.draw(letter.getImg(), letter.getX(), letter.getY());
        }

        batch.draw(player.getImg(), player.getX(), player.getY());

        batch.end();

    }

    private void renderLetters() {

        for (Letter letter : letters) {
            batch.draw(letter.getImg(), letter.getX(), letter.getY());
        }


    }

    /*private void spawnLetters() {

        for (int i = 0; i < 5; i++) {
            LetterType letterType = randomLetter();
            letters.add(new Letter(letterType.getImgPath(), letterType.getCharLetter(), (int)Math.floor(Math.random() * 1000), 0));

        }
    }*/

    /*private LetterType randomLetter() {

        return LetterType.values()[(int)Math.floor(Math.random() * LetterType.values().length)];
    }*/

    private void loadPlatforms() {
        platforms = new Platform[2];
        platforms[0] = new Platform(new Texture(GlobalVariables.PLATFORM_BLOCK), new Rectangle());
        platforms[1] = new Platform(new Texture(GlobalVariables.PLATFORM_BIG_BLOCK), new Rectangle());
    }

    private void renderPlatforms() {



        batch.draw(platforms[0].getImg(), 500, 100);
        batch.draw(platforms[1].getImg(), 1000, 200);
    }

    private void drawBackground(){
        for (Texture img : background){
            batch.draw(img,0,0);
        }
    }
}
