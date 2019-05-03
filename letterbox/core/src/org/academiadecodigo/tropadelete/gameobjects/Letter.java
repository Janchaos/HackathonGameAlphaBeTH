package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Letter extends GameObjects {

    private char letter;
    public static final float HEIGHT = 50;
    public static final float WIDTH = 30;

    public Letter(Texture img, char letter) {
        super(img, new Rectangle(0,1000, WIDTH, HEIGHT));
        this.letter = letter;
    }

}
