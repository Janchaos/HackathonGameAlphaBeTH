package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.audio.Sound;
import org.academiadecodigo.tropadelete.Game;

import java.util.Iterator;
import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<Letter> word;
    private Player player;
    private Platform[] platforms;
    private LetterBox letterBox;

    public CollisionDetector(LinkedList<Letter> letters, Player player, Platform[] platforms, LetterBox letterBox) {
        this.word = letters;
        this.player = player;
        this.platforms = platforms;
        this.letterBox = letterBox;
    }

    public void checkCollision() {
        groundCollision();
        letterCollision();
        platformsCollision();

    }

    private void groundCollision() {
        if (player.getY() < 50) {
            player.setY(50);
            playerGrounded();
        }
    }

    private void platformsCollision() {
        for (Platform platform : platforms) {
            if (player.overlaps(platform)) {
                player.setY(platform.getY() + platform.getHeight());
                playerGrounded();
            }
        }

    }

    private void letterCollision() {
        Iterator<Letter> it = word.iterator();
        while(it.hasNext()) {
            Letter letter = it.next();
            if (letter.overlaps(player)) {
                it.remove();
                letterBox.catchWords();
                System.out.println("colliding with letter");

            }
        }
    }

    private void playerGrounded(){
        player.setJump(false);
        player.setStandOnGround();
    }


}
