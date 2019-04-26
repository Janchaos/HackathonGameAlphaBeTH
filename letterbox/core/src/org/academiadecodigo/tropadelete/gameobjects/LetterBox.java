package org.academiadecodigo.tropadelete.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.tropadelete.LetterType;

import java.util.LinkedList;
import java.util.List;

public class LetterBox {

    private Texture[] letters;
    private LinkedList<Boolean> catchWords;


    public LinkedList<Letter> splitWord(String word) {

        this.letters = new Texture[word.length()];
        this.catchWords = new LinkedList<>();
        LinkedList<Letter> scrambleLetters = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            for (LetterType letter : LetterType.values()) {
                if (letter.getCharLetter() == word.charAt(i)) {
                    Texture img = new Texture(letter.getImgPath());
                    this.letters[i] = img;
                    scrambleLetters.add(new Letter(img,letter.getCharLetter()));

                }
            }
        }
        return scrambleLetters;
    }

    public Texture[] getLetters() {
        return letters;
    }

    public void catchWords() {
        this.catchWords.add(true);
    }

    public boolean asWon(){
        return letters.length <= catchWords.size();
    }
}
