package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyBaseClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class GameScreen extends MyScreen {




    MyStage stage = new MyStage(new ExtendViewport(128,128), spriteBatch, game ) {
        OneSpriteStaticActor actor;
        OneSpriteStaticActor actor1;


        @Override
        public void init() {
            actor = new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE));
            actor.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    actor.setX(actor.getX()+2);
                    return super.touchDown(event, x, y, pointer, button);
                }
            });

            actor1 = new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
                @Override
                public void act(float delta) {
                    super.act(delta);
                    setRotation(getRotation() + delta * 45);
                }
            };

            actor.setSize(16,16);
            actor.addBaseCollisionCircleShape();
            actor1.addBaseCollisionRectangleShape();
            actor1.setSize(16,16);
            actor1.setPosition(40,0);
            addActor(actor);
            addActor(actor1);
        }

        @Override
        public void act(float delta) {
            super.act(delta);
            if (actor.overlaps(actor1)){
                System.out.println("Overlaps");
            }else{
                actor.setColor(1,1,1,1f);
                actor1.setColor(1,1,1,1f);
            }
        }
    };

    MyStage stage2 = new MyStage(new ExtendViewport(1024,1024), spriteBatch, game) {
        OneSpriteActor pacman;
        @Override
        public void init() {
            pacman = new OneSpriteStaticActor(Assets.manager.get(Assets.PACMAN_TEXTURE));

            pacman.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    pacman.setX(pacman.getX()+2);
                    return super.touchDown(event, x, y, pointer, button);
                }
            });

            pacman.setSize(24,24);
            pacman.setPosition(15,15);
            addActor(pacman);
        }
    };


    public GameScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
