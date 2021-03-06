package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyBaseClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

	@Override
	public void create () {
		Assets.prepare();
		Assets.load();
		System.out.println("Loading");
		while (!Assets.manager.update()){
			System.out.print(".");
		}
		setScreen(new GameScreen(this));
	}

}
