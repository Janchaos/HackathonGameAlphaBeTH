package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
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
    private Texture background;
    private Music music;

    private boolean gamestart;

    @Override
    public void create() {

        batch = new SpriteBatch();
        player = new Player(GlobalVariables.RIGHT_RUNNING_TEXTURES[0], new Rectangle());
        letterBox = new LetterBox();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        inputHandler = new InputHandler(player);
        letters = letterBox.splitWord("HELLO");
        loadPlatforms();
        collisionDetector = new CollisionDetector(letters, player, platforms, letterBox);

        background = GlobalVariables.BACKGROUND;

        createSound();


        //devia ter variable global akí finito
        letters.get(0).setX(50);
        letters.get(0).setY(50);
        letters.get(1).setX(400);
        letters.get(1).setY(50);
        letters.get(2).setX(800);
        letters.get(2).setY(50);
        letters.get(3).setX(1200);
        letters.get(3).setY(50);
        letters.get(4).setX(1600);
        letters.get(4).setY(50);

    }

    @Override
    public void render() {


        inputHandler.keyboardListenerX();
        inputHandler.keyboardListenerY();
        player.jump();


       camera.position.x = MathUtils.clamp(camera.position.x, camera.viewportWidth / 2f, 0);

        updateCamera();
        batch.setProjectionMatrix(camera.combined);

        collisionDetector.checkCollision();

        if(letterBox.asWon()){


        }

        System.out.println(letterBox.asWon());
        createImage();
    }


    @Override
    public void dispose() {

        for (Letter letter : letters) {
            letter.dispose();
        }
        batch.dispose();
        player.dispose();
        music.dispose();

    }

    private void updateCamera() {
        camera.position.x = player.getHitbox().x;
        camera.position.y = player.getHitbox().y + 800 / 4; // look magic number to push camera up
        camera.update();

    }


    private void createImage() {

        float x = 0;


        batch.begin();
        batch.draw(background, 0, 0);

        renderPlatforms();
        renderLetters();

        int index = 0;
        for (int i = 0; i < letterBox.getLetters().length; i++) {
            batch.draw(letterBox.getLetters()[i], camera.position.x + index - 300, camera.position.y + 100);
            index += 112;
        }

        for (Letter letter : letters) {

            batch.draw(letter.getImg(), letter.getX(), letter.getY());
        }

        batch.draw(player.getImg(), player.getX(), player.getY());

        batch.end();

    }

    private void createSound(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/backgroundSound.mp3"));
        music.setLooping(true);
        music.play();

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
        platforms[0] = new Platform(new Texture(GlobalVariables.PLATFORM_BLOCK), 1000, 300);
        platforms[1] = new Platform(new Texture(GlobalVariables.PLATFORM_BIG_BLOCK), 500, 100);
    }

    private void renderPlatforms() {

        batch.draw(platforms[0].getImg(), platforms[0].getX(), platforms[0].getY() - 50);
        batch.draw(platforms[1].getImg(), platforms[1].getX(), platforms[1].getY() - 50);
    }

}
