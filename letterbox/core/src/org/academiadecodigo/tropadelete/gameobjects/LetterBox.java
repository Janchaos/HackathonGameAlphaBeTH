package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.tropadelete.LetterType;

import java.util.LinkedList;

public class LetterBox {

    private Texture[] letters;
    private boolean[]

    public LetterBox() {



    }

    public void addLetter(Letter letter) {

        letter.setCaught();
    }

    public LinkedList<Letter> splitWord(String word) {

        this.letters = new Texture[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (LetterType letter : LetterType.values()) {
                if (letter.getCharLetter() == word.charAt(i)) {
                    this.letters[i] = letter.getImgPath();
                }
            }
        }
    }

    public Texture[] getLetters() {
        return letters;
    }
}
