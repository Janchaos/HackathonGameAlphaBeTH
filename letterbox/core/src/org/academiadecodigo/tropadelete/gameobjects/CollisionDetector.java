package org.academiadecodigo.tropadelete.gameobjects;

import java.util.Iterator;
import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<Letter> word;
    private Player player;
    private Platform[] platforms;

    public CollisionDetector(LinkedList<Letter> letters, Player player, Platform[] platforms) {
        this.word = letters;
        this.player = player;
        this.platforms = platforms;
    }

    public void checkCollision() {
        groundCollision();
        letterCollision();

    }

    private void groundCollision() {
        if (player.getY() <= 0) {
            player.setY(0);
            player.setJump(false);
            player.setStandOnGround();
        }
    }

    private void platformsCollision() {
        for (Platform platform : platforms) {
            if (player.overlaps(platform)) {
                player.setY(platform.getY());
                player.setStandOnGround();
            }
        }

    }

    private void letterCollision() {
        Iterator<Letter> it = word.iterator();
        while(it.hasNext()) {
            Letter letter = it.next();
            if (letter.overlaps(player)) {
                it.remove();
                System.out.println("colliding with letter");

            }
        }
    }


}
