package SplashSnippet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SnippetMain extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create() {
		float initialAlpha = 0f;
		float finalAlpha = 1f;
		float fadeTime = 4f;
		float delayTime = 1.5f;
		
		setScreen(new Splash(initialAlpha, finalAlpha, fadeTime, delayTime));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);	
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
