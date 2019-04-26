package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.graphics.Texture;

import java.util.LinkedList;
import java.util.List;

public enum LetterType {
    A (new String("letras/a.png"), 'A'),
    B (new String("letras/b.png"), 'B'),
    C (new String("letras/c.png"), 'C');
    /*D (new String(""), 'D'),
    E (new String(""), 'E'),
    F (new String(""), 'F'),
    G (new String(""), 'G'),
    H (new String(""), 'H'),
    I (new String(""), 'I'),
    J (new String(""), 'J'),
    K (new String(""), 'K'),
    L (new String(""), 'L'),
    M (new String("letras/m.png"), 'M'),
    N (new String(""), 'N'),
    O (new String(""), 'O'),
    P (new String(""), 'P'),
    Q (new String(""), 'Q'),
    R (new String(""), 'R'),
    S (new String(""), 'S'),
    T (new String(""), 'T'),
    U (new String(""), 'U'),
    V (new String(""), 'V'),
    W (new String(""), 'W'),
    X (new String(""), 'X'),
    Y (new String(""), 'Y'),
    Z (new String(""), 'Z'); */

    private String texture;
    private char charLetter;

    LetterType(String texture, char charLetter) {
        this.charLetter = charLetter;
        this.texture = texture;

    }

    public String getTexture() {
        return texture;
    }

    public char getCharLetter() {
        return charLetter;
    }


}
