package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends GameObjects {

    // Just sample values
    Vector2 gravity = new Vector2(0, -5);
    Vector2 position = new Vector2(10, 10);
    Vector2 velocity = new Vector2();

    // Test if the jump key (or what ever you like) is pressed)
    boolean jump = false;
    boolean canJump = true;
    // Test if the player stands on the ground every loop
    boolean standOnGround = true;


    public Player(Texture img, Rectangle hitbox) {
        super(img, hitbox);
    }


    public void moveRight() {
        Vector2 vector2 = new Vector2();
        vector2.x = 10;
        addPosition(vector2);
    }

    public void moveLeft() {
        Vector2 vector2 = new Vector2();
        vector2.x = -10;
        addPosition(vector2);
    }


    public void jump() {

        /*
         * In your update method
         */

        // Add the gravity to the velocity
        velocity.add(gravity);

        // If the jump key is pressed and jumping is allowed
        if (jump && canJump) {
            // Add an upward velocity
            velocity.add(0, 20);
            // Disallow jumping, so you can't jump in mid air.
            canJump = false;
        }
        // If the player stands on the ground
        else if (standOnGround) {
            // You can't fall down when you stand on a ground
            velocity.y = 0;
            // When you stand on a ground you can jump again
            canJump = true;
        }

        // Limit fall speed
        if (velocity.y < -20) {
            velocity.y = -20;
        }

        // Add the velocity to the players position
        position.add(velocity);

    }

    public void addPosition(Vector2 vector2) {
        hitbox.x += vector2.x * Gdx.graphics.getDeltaTime();
        hitbox.y += vector2.y * Gdx.graphics.getDeltaTime();
    }


}
