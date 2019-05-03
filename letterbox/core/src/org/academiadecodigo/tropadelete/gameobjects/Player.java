package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.tropadelete.GlobalVariables;

public class Player extends GameObjects {

    public final int SPEED = 300;
    public final int JUMP_HEIGHT = 300;

    private float lastTexture;
    private int counter;

    Vector2 gravity = new Vector2(0, -5);
    Vector2 velocity = new Vector2();

    private boolean jump = false;
    private boolean canJump = true;
    private boolean standOnGround = true;


    public Player(Texture img, Rectangle hitbox) {
        super(img, hitbox);
        init();

        counter = 1;
        lastTexture = TimeUtils.nanoTime();
    }

    private void init() {
        hitbox.x = 100;
        hitbox.y = 50;
        hitbox.width = 100;
        hitbox.height = 100;
    }

    public void moveRight() {

        Vector2 vector2 = new Vector2();
        vector2.x = SPEED;
        addPosition(vector2);

        runRightLastTexture();
    }


    public void moveLeft() {
        Vector2 vector2 = new Vector2();
        vector2.x = -SPEED;
        addPosition(vector2);

        //runLeftLastTexture();
    }


    public void jump() {

        // Add the gravity to the velocity
        velocity.add(gravity);

        // If the jump key is pressed and jumping is allowed
        if (jump && canJump) {

            // Add an upward velocity
            velocity.add(0, JUMP_HEIGHT);

            // Disallow jumping, so you can't jump in mid air.
            canJump = false;

            //not on ground anymore
            standOnGround = false;

            img = GlobalVariables.RIGHT_JUMPING_TEXTURES[0];
        }
        // If the player stands on the ground
        else if (standOnGround && !canJump) {
            // You can't fall down when you stand on a ground
            velocity.y = 50;
            // When you stand on a ground you can jump again
            canJump = true;
            img = GlobalVariables.RIGHT_JUMPING_TEXTURES[2];
        }

        // Limit fall SPEED
        if (velocity.y < -200) {
            velocity.y = -200;
        }
        // Add the velocity to the players position
        addPosition(velocity);
    }

    public void addPosition(Vector2 vector2) {
        hitbox.x += vector2.x * Gdx.graphics.getDeltaTime();
        hitbox.y += vector2.y * Gdx.graphics.getDeltaTime();
    }


    public void runRightLastTexture() {
        if(jump){
            return;
        }

        if (TimeUtils.nanoTime() - lastTexture > TimeUtils.millisToNanos(100)) {

            img = GlobalVariables.RIGHT_RUNNING_TEXTURES[counter];
            lastTexture = TimeUtils.nanoTime();
            ++counter;
        }
        if (counter == 7) {
            counter = 1;
        }
    }

    /*
    public void runLeftLastTexture() {

        if (TimeUtils.nanoTime() - lastTexture > TimeUtils.millisToNanos(100)) {

            img = GlobalVariables.LEFT_RUNNING_TEXTURES[counter];
            lastTexture = TimeUtils.nanoTime();
            ++counter;
        }
        if (counter == 7) {
            counter = 1;
        }
    }
    */

    public void jumpRightLastTexture() {

        if (TimeUtils.nanoTime() - lastTexture > TimeUtils.millisToNanos(10)) {


            lastTexture = TimeUtils.nanoTime();
            ++counter;
        }
        if (counter == 3) {
            counter = 0;
        }
    }
/*
    public void jumpLeftLastTexture() {

        if (TimeUtils.nanoTime() - lastTexture > TimeUtils.millisToNanos(100)) {

            img = GlobalVariables.LEFT_JUMPING_TEXTURES[counter];
            lastTexture = TimeUtils.nanoTime();
            ++counter;
        }
        if (counter == 3) {
            counter = 0;
        }
    }
    */
    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void setStandOnGround() {
        this.standOnGround = true;
    }

    public void setStill(Texture img) {
        this.img = img;
    }
}
