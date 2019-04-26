package org.academiadecodigo.tropadelete;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    private static AssetManager asm = new AssetManager();
    private static String assetsPackPath = "sprite_girl_1.png";
    public static TextureAtlas atlas;

    public static void load(){
        asm.load(assetsPackPath, TextureAtlas.class);
        asm.finishLoading();

        atlas = asm.get(assetsPackPath);
    }

    public static void dispose(){
        asm.dispose();
    }
}
