package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.security.PublicKey;

public class CollisionDetector {

    private LetterBox letterBox;
    private Player player;

    public CollisionDetector(LetterBox letterBox, Player player) {
        this.letterBox = letterBox;
        this.player = player;
    }

    public void checkCollision(){
        groundCollision();

        }

    private void groundCollision() {
        if(player.getY()<=0){
            player.setY(0);
            player.setJump(false);
            player.setStandOnGround(true);
        }
    }

    private void tileCollision() {

    }



}
