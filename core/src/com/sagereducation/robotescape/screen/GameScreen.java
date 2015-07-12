package com.sagereducation.robotescape.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Align;
import com.sagereducation.robotescape.util.MultipleVirtualViewportBuilder;
import com.sagereducation.robotescape.util.OrthographicCameraWithVirtualViewport;
import com.sagereducation.robotescape.util.ScreenEnum;
import com.sagereducation.robotescape.util.UIFactory;
import com.sagereducation.robotescape.util.VirtualViewport;

public class GameScreen extends AbstractScreen {
	private SpriteBatch batch;
	private TextureAtlas spriteSheet;
	private TextureRegion ballRegion;
	
	private ArrayList<String> spriteNames = new ArrayList<String>();

	// Current level
	private int level;
	
	public GameScreen(Integer level) {
		super();
		this.level = level.intValue();
		batch = new SpriteBatch();
		spriteSheet = new TextureAtlas("/Users/taylor/Documents/Development/Projects/RobotEscape/android/assets/mainscene.txt");
		
		spriteNames.add("bg");
		spriteNames.add("belt1");
		spriteNames.add("arrow1");
		spriteNames.add("arrow2");
		spriteNames.add("ball");
		spriteNames.add("robot");
		spriteNames.add("door1");
		spriteNames.add("pause_icon");
		spriteNames.add("restart_icon");
		
		//txtrBg   = new Texture( Gdx.files.internal("img/game_bg.png") );
		//txtrBack = new Texture( Gdx.files.internal("img/btn_back.png") );
	}

	@Override
	public void buildStage() {
		ballRegion = spriteSheet.findRegion("ball");
		
		VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
          
        camera = new OrthographicCameraWithVirtualViewport(virtualViewport);  
        // centers the camera at 0, 0 (the center of the virtual viewport)  
        camera.position.set(0f, 0f, 0f);  
        
		// Adding actors
//		Image bg = new Image(txtrBg);
//		addActor(bg);
//		
//		ImageButton btnBack = UIFactory.createButton(txtrBack);
//		btnBack.setPosition(260.f, 40.f, Align.center);
//		addActor(btnBack);
//		
//		txtrLevelImage = new Texture( Gdx.files.internal("img/btn_level_" + level + ".png") );
//		Image imgLevel = new Image(txtrLevelImage);
//		imgLevel.setPosition(getWidth() / 2, getHeight() / 2, Align.center);
//		addActor(imgLevel);
//		
//		btnBack.addListener( UIFactory.createListener( ScreenEnum.LEVEL_SELECT ) );
	}

	@Override
	public void render(float delta) {
		super.render(delta);  
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f);  
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  
        camera.update();   
        // render stuff...  
        batch.setProjectionMatrix(camera.combined); 
        
		batch.begin();
		for(String spriteName : spriteNames)
		{
			Sprite sprite = spriteSheet.createSprite(spriteName);
			if(sprite != null)
			{
				sprite.draw(batch);
//				batch.draw(sprite, 
//						sprite.getRegionX()/2, 
//						sprite.getRegionY()/2, 
//						0.0f,
//						0.0f,
//						sprite.getRegionWidth()/2, 
//						sprite.getRegionHeight()/2, 
//						1.f, 
//						1.f, 
//						0.0f);
			}
			//Sprite t = spriteSheet.createSprite("bg");
		
		}
		batch.end();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		//txtrBg.dispose();
		//txtrBack.dispose();
		//txtrLevelImage.dispose();
	}
}
