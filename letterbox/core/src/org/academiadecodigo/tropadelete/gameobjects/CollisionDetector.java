package org.academiadecodigo.tropadelete.gameobjects;

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

    private void letterCollision(){
        for (Letter letter : letterBox.getLetters()){
            if (letter.overlaps(player)) {
                letter.setCaught();
                letter.dispose();
                letter.getImg().dispose();
            }
        }
    }



}
