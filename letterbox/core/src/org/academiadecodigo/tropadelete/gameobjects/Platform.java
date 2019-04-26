package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.tropadelete.GlobalVariables;

public class Platform extends GameObjects {

    public Platform(Texture img, float x, float y) {
        super(img, new Rectangle());
        hitbox.x = x;
        hitbox.y = y;
        hitbox.height = GlobalVariables.BLOCK_HEIGHT;
        hitbox.width = GlobalVariables.BLOCK_WIDTH;
    }
}
