package com.sagereducation.robotescape.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.sagereducation.robotescape.util.MultipleVirtualViewportBuilder;
import com.sagereducation.robotescape.util.OrthographicCameraWithVirtualViewport;
import com.sagereducation.robotescape.util.VirtualViewport;

public abstract class AbstractScreen extends Stage implements Screen {
	
	private static final int VIRTUAL_WIDTH = 1080;
    private static final int VIRTUAL_HEIGHT = 720;
    private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
    
    protected OrthographicCameraWithVirtualViewport camera;
	protected MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;
	
	protected AbstractScreen() {
		super( new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, new OrthographicCamera()) );
		multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder(800, 600, 1080, 720);  
	}
	
	// Subclasses must load actors in this method
	public abstract void buildStage();

	@Override
	public void render(float delta) {
		// Clear screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Calling to Stage methods
		super.act(delta);
		super.draw();
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void resize(int width, int height) {
		
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
        camera.setVirtualViewport(virtualViewport);  
          
        camera.updateViewport();  
        // centers the camera at 0, 0 (the center of the virtual viewport)  
        //camera.position.set(0f, 0f, 0f);  
        camera.position.set(virtualViewport.getWidth()/2.0f, virtualViewport.getHeight()/2.0f, 0f);
        // relocate floating stuff  
        //floatingButtonSprite.setPosition(virtualViewport.getVirtualWidth() * 0.5f - 80, virtualViewport.getVirtualHeight() * 0.5f - 80);  
	
	}

	@Override public void hide() {}
	@Override public void pause() {}
	@Override public void resume() {}
}
