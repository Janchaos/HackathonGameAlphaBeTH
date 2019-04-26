package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.graphics.Texture;

public class GlobalVariables {

    public final static Texture[] RIGHT_RUNNING_TEXTURES = new Texture[]{new Texture("player_girl/step1_girl.png"),
                                                                        new Texture("player_girl/step2_girl.png"),
                                                                         new Texture("player_girl/step3_girl.png"),
                                                                          new Texture("player_girl/step4_girl.png"),
                                                                            new Texture("player_girl/step5_girl.png"),
                                                                             new Texture("player_girl/step6_girl.png"),
                                                                             new Texture("player_girl/step7_girl.png")};


    /*
    public final static Texture[] LEFT_RUNNING_TEXTURES = new Texture[]{new Texture("player_girl/step1_girl_left.png"),
            new Texture("player_girl/step2_girl_left.png"),
            new Texture("player_girl/step3_girl_left.png"),
            new Texture("player_girl/step4_girl_left.png"),
            new Texture("player_girl/step5_girl_left.png"),
            new Texture("player_girl/step6_girl_left.png"),
            new Texture("player_girl/step7_girl_left.png")};

*/

    public final static Texture[] RIGHT_JUMPING_TEXTURES = new Texture[] {new Texture("player_girl/step8_girl.png"),
                                                                         new Texture("player_girl/step9_girl.png"),
                                                                         new Texture("player_girl/step10_girl.png")};

    /*
    public final static Texture[] LEFT_JUMPING_TEXTURES = new Texture[] {new Texture("player_girl/step8_girl_left.png"),
                                                                          new Texture("player_girl/step9_girl_left.png"),
                                                                             new Texture("player_girl/step10_girl_left.png")};
*/
    public final static Texture SKY = new Texture("background/sky.png");
    public final static Texture GROUND = new Texture("background/ground.png");
    public final static Texture SIERRA = new Texture("background/sierra.png");
    public final static Texture BUSH = new Texture("background/bush.png");

    public final static String PLATFORM_BLOCK = "background/block.png";
    public final static String PLATFORM_BIG_BLOCK = "background/bigblock.png";
}
