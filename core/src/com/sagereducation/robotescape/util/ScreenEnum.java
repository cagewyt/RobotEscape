package com.sagereducation.robotescape.util;

import com.sagereducation.robotescape.screen.AbstractScreen;
import com.sagereducation.robotescape.screen.GameScreen;
import com.sagereducation.robotescape.screen.LevelSelectScreen;
import com.sagereducation.robotescape.screen.MainMenuScreen;

public enum ScreenEnum {
	
	MAIN_MENU {
		public AbstractScreen getScreen(Object... params) {
			return new MainMenuScreen();
		}
	},
	
	LEVEL_SELECT {
		public AbstractScreen getScreen(Object... params) {
			return new LevelSelectScreen();
		}
	},
	
	GAME {
		public AbstractScreen getScreen(Object... params) {
			return new GameScreen((Integer) params[0]);
		}
	};
	
	public abstract AbstractScreen getScreen(Object... params);
}
