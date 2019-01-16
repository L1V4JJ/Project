package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static AssetManager manager;

    public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
    public static final AssetDescriptor<Texture> PACMAN_TEXTURE = new AssetDescriptor<Texture>("pacman.png", Texture.class);
    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        manager.load(BADLOGIC_TEXTURE);
    }

    public static void unload() {
        manager.dispose();
    }
}
