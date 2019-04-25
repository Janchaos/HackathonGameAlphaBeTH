package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Letter extends GameObjects {

    private boolean isCaught;
    private char letter;
    public static final float HEIGHT = 50;
    public static final float WIDTH = 30;

    public Letter(Texture img, char letter, float x, float y) {
        super(img, new Rectangle(x, y, WIDTH, HEIGHT));
        this.isCaught = false;
        this.letter = letter;
    }

    public void setCaught() {
        isCaught = true;
    }

    public boolean isCaught() {
        return isCaught;
    }
}
