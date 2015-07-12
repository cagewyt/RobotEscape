package com.sagereducation.robotescape;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sagereducation.robotescape.util.ScreenEnum;
import com.sagereducation.robotescape.util.ScreenManager;
import com.badlogic.gdx.Game;

public class RobotEscape extends Game {
	SpriteBatch batch;
	TextureAtlas spriteSheet;
	TextureRegion ballRegion;
	
	@Override
	public void create () {
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen( ScreenEnum.GAME, 1 );
	}
}
