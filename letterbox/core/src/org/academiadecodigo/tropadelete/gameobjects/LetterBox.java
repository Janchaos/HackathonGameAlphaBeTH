package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.tropadelete.LetterType;

import java.util.LinkedList;
import java.util.List;

public class LetterBox {

    private Texture[] letters;

    public LetterBox(String word) {

        this.letters = new Texture[word.length()];
        splitWord(word);
    }

    public void addLetter(Letter letter) {

        letter.setCaught();
    }

    //syntaxe pode variar
    public void splitWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            for (LetterType letter : LetterType.values()) {
                if (letter.getCharLetter() == word.charAt(i)) {
                    this.letters[i] = letter.getTexture();
                }
            }
        }
    }

    public Texture[] getLetters() {
        return letters;
    }
}
