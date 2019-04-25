package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Letter extends GameObjects {

    private boolean isCaugth;
    private char letter;
    public static final float HEIGHT = 50;
    public static final float WIDTH = 30;

    public Letter(Texture img, char letter, float x, float y) {
        super(img, new Rectangle(x, y, WIDTH, HEIGHT));
        this.isCaugth = false;
        this.letter = letter;
    }

    public void setCaugth() {
        isCaugth = true;
    }

    public boolean isCaugth() {
        return isCaugth;
    }
}
