package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Letter extends GameObjects {

    private char stringLetter;
    private float x;
    private float y;
    public static final float HEIGHT = 50;
    public static final float WIDTH = 30;

    public Letter(Texture img, char stringLetter, float x, float y) {
        super(img, new Rectangle(x, y, WIDTH, HEIGHT));
        this.x = x;
        this.y = y;

        this.stringLetter = stringLetter;
    }


}
