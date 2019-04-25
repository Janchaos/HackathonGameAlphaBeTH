package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.LinkedList;
import java.util.List;

public class LetterBox {

    private List<Letter> letters;
    private String word;

    public LetterBox(String word) {

        letters = new LinkedList<>();
        this.word = word;
    }

    public void addLetter(Letter letter) {

        letter.setCaugth();
    }

    //syntaxe pode variar
    public void splitWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            for (Letter letter : LetterType.values()) {
                if (letter.getLetter() == word.charAt(i)) {
                    letters.add(letter);
                }
            }
        }
    }

}
