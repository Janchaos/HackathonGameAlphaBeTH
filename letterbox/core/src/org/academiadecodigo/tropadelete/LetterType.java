package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.graphics.Texture;

import java.util.LinkedList;
import java.util.List;

public enum LetterType {
    A(new Texture("letras/a.png"), 'A'),
    B(new Texture("letras/b.png"), 'B'),
    C(new Texture("letras/c.png"), 'C'),/*,
    D(new Texture(""), "D"),
    E(new Texture(""), "E"),
    F(new Texture(""), "F"),
    G(new Texture(""), "G"),
    H(new Texture(""), "H"),
    I(new Texture(""), "I"),
    J(new Texture(""), "J"),
    K(new Texture(""), "K"),
    L(new Texture(""), "L"),*/
    M(new Texture("letras/m.png"),'M');/*
    N(new Texture(""), "N"),
    O(new Texture(""), "O"),
    P(new Texture(""), "P"),
    Q(new Texture(""), "Q"),
    R(new Texture(""), "R"),
    S(new Texture(""), "S"),
    T(new Texture(""), "T"),
    U(new Texture(""), "U"),
    V(new Texture(""), "V"),
    W(new Texture(""), "W"),
    X(new Texture(""), "X"),
    Y(new Texture(""), "Y"),
    Z(new Texture(""), "Z");*/

    private Texture texture;
    private char charLetter;

    LetterType(Texture texture, char charLetter) {
        this.charLetter = charLetter;
        this.texture = texture;

    }

    public Texture getTexture() {
        return texture;
    }

    public char getCharLetter() {
        return charLetter;
    }


}
