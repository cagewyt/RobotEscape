package com.sagereducation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class RobotEscape extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas spriteSheet;
	Array<Sprite> belts;
	Array<Sprite> arrows;
	Sprite background;
	Sprite leftmenu;
	Sprite ball;
	TextureRegion ballRegion;
	@Override
	public void create () {
		batch = new SpriteBatch();
		spriteSheet = new TextureAtlas("C:/Users/Administrator/Documents/development/RobotEscape/android/assets/mainscene.txt");
		ballRegion = spriteSheet.findRegion("ball");
	}

	@Override
	public void render () {
		
		
		
		belts = spriteSheet.createSprites("belt");
		for(int i=0;i<belts.size;i++){
			belts.get(i).setSize(1154,19);
		}
		arrows = spriteSheet.createSprites("arrow");
		for(int i=0;i<arrows.size;i++){
			belts.get(i).setSize(1154,19);
		}
		
		Gdx.gl.glViewport(0, 0, 1080/2, 720/2);
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(ballRegion, ballRegion.getRegionX()/2, ballRegion.getRegionY()/2, 0, 0, ballRegion.);
		batch.draw(ballRegion, ballRegion.getRegionX()/4, ballRegion.getRegionY()/4);
		//batch.draw(ballRegion.getTexture(), ballRegion.getRegionX(), ballRegion.getRegionY());
		batch.end();
	}
}
