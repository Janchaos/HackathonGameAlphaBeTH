package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Letter extends GameObjects {


    private boolean isCaugth;

    public Letter(Texture img, Rectangle hitbox) {
        super(img, hitbox);
        this.isCaugth = false;
    }

    public void setCaugth() {
        isCaugth = true;
    }

    public boolean isCaugth(){
        return isCaugth;
    }
}
