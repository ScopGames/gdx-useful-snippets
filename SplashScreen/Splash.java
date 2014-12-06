package SplashSnippet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen {

	private SpriteBatch batch;
	private Sprite splash;
	private Fade fade;
	private float delayTime;

	public Splash(float initialAlpha, float finalAlpha, float fadeTime, float delayTime) {
		batch = new SpriteBatch();
		Texture splashTexture = new Texture("badlogic.jpg");
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.delayTime = delayTime;
		fade = new Fade(initialAlpha, finalAlpha, fadeTime);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		updateTransparency(delta);

		batch.begin();
		splash.draw(batch);
		batch.end();
	}

	public void updateTransparency(float delta) {
		fade.update(delta);
		splash.setAlpha(fade.getTransparency());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		fade.start(delayTime);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
		//fade.start();
	}

	@Override
	public void dispose() {

	}

}
