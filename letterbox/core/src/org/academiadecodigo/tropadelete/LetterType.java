package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.graphics.Texture;

public enum LetterType {
    A(new Texture("badlogic.jpg"), 'A');/*,
    B(new Texture(""), "B"),
    C(new Texture(""), "C"),
    D(new Texture(""), "D"),
    E(new Texture(""), "E"),
    F(new Texture(""), "F"),
    G(new Texture(""), "G"),
    H(new Texture(""), "H"),
    I(new Texture(""), "I"),
    J(new Texture(""), "J"),
    K(new Texture(""), "K"),
    L(new Texture(""), "L"),
    M(new Texture(""), "M"),
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
