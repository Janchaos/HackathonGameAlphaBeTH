package org.academiadecodigo.tropadelete.gameobjects;

public class CollisionDetector {

    private LetterBox letterBox;
    private Player player;
    private Platform[] platforms;

    public CollisionDetector(LetterBox letterBox, Player player, Platform[] platforms) {
        this.letterBox = letterBox;
        this.player = player;
        this.platforms = platforms;
    }

    public void checkCollision(){
        groundCollision();

        }

    private void groundCollision() {
        if(player.getY()<=0){
            player.setY(0);
            player.setJump(false);
            player.setStandOnGround();
        }
    }

    private void platformsCollision() {
        for (Platform platform : platforms){
            if(player.overlaps(platform)){
                player.setY(platform.getY());
                player.setStandOnGround();
            }
        }

    }

    private void letterCollision(){
        for (Letter letter : letterBox.getLetters()){
            if (letter.overlaps(player)) {
                letter.setCaught();

                letter.getImg().dispose();
            }
        }
    }



}
