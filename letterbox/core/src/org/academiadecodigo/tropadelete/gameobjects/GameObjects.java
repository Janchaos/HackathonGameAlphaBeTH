package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObjects {
    protected Texture img;
    protected Rectangle hitbox;

    public GameObjects(Texture img, Rectangle hitbox) {
        this.img = img;
        this.hitbox = hitbox;
    }

    public void dispose() {
        img.dispose();
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public float getX() {
        return hitbox.x;
    }

    public float getY() {
        return hitbox.y;
    }

    public void setX(int x){
        hitbox.x = x;
    }

    public void setY(int y){
        hitbox.y = y;
    }

    public float getHeight() {
        return hitbox.height;
    }

    public float getWidth() {
        return hitbox.width;
    }

    public boolean overlaps(GameObjects gameObject) {
        return hitbox.overlaps(gameObject.hitbox);
    }

}
