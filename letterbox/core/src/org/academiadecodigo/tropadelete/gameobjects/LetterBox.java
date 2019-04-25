package org.academiadecodigo.tropadelete.gameobjects;

import org.academiadecodigo.tropadelete.LetterType;

import java.util.LinkedList;
import java.util.List;

public class LetterBox {

    private List<Letter> letters;

    public LetterBox(String word) {

        this.letters = new LinkedList<>();
        splitWord(word);
    }

    public void addLetter(Letter letter) {

        letter.setCaugth();
    }

    //syntaxe pode variar
    public void splitWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            for (LetterType letter : LetterType.values()) {
                if (letter.getCharLetter() == word.charAt(i)) {
                    this.letters.add(new Letter(letter.getTexture(),letter.getCharLetter(),10,10));
                }
            }
        }
    }

}
