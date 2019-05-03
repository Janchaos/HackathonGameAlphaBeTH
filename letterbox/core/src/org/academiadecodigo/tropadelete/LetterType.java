package org.academiadecodigo.tropadelete;

public enum LetterType {
    A ("letras/a.png", 'A'),
    B ("letras/b.png", 'B'),
    C ("letras/c.png", 'C'),
    D ("letras/d.png", 'D'),
    E ("letras/e.png", 'E'),
    F ("letras/f.png", 'F'),
    G ("letras/g.png", 'G'),
    H ("letras/h.png", 'H'),
    I ("letras/i.png", 'I'),
    J ("letras/j.png", 'J'),
    K ("letras/k.png", 'K'),
    L ("letras/l.png", 'L'),
    M ("letras/m.png", 'M'),
    N ("letras/n.png", 'N'),
    O ("letras/o.png", 'O'),
    P ("letras/p.png", 'P'),
    Q ("letras/q.png", 'Q'),
    R ("letras/r.png", 'R'),
    S ("letras/s.png", 'S'),
    T ("letras/t.png", 'T'),
    U ("letras/u.png", 'U'),
    V ("letras/v.png", 'V'),
    W ("letras/w.png", 'W'),
    X ("letras/x.png", 'X'),
    Y ("letras/y.png", 'Y'),
    Z ("letras/z.png", 'Z');

    private String imgPath;
    private char charLetter;

    LetterType(String imgPath, char charLetter) {
        this.charLetter = charLetter;
        this.imgPath = imgPath;

    }

    public String getImgPath() {
        return imgPath;
    }

    public char getCharLetter() {
        return charLetter;
    }


}
