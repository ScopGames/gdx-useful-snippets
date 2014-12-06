package SplashSnippet;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Fade
{
	private float transparency = 0;
	private float fadeTime;
	private float initialAlpha;
	private float finalAlpha;
	private Timer timer;

	private boolean fadeAnimationActive = false;

	public Fade(float initialAlpha, float finalAlpha, float fadeTime) {
		this.initialAlpha = initialAlpha;
		this.finalAlpha = finalAlpha;
		this.fadeTime = fadeTime;
		this.transparency = initialAlpha;

		this.timer = new Timer();
	}

	public void update(float delta) {
		if (transparency < finalAlpha && fadeAnimationActive)
		{
			float transparencyIncrement = delta*(finalAlpha - initialAlpha)/fadeTime;
			transparency += transparencyIncrement;

			if (transparency > 1f)
			{
				transparency = 1f;
				fadeAnimationActive = false;
			}
		}
		//Gdx.app.log("transparency", transparency +"");
	}

	public void start() {
		transparency = initialAlpha;
		fadeAnimationActive = true;
	}

	/**
	 * Starts the fade animation after a delay time
	 * @param delay delay time.
	 */
	public void start(float delay) {
		Task start_task = new Task() {
			public void run() {
				start();
			}
		};

		timer.scheduleTask(start_task, delay);
	}

	public boolean isAnimationActive() {
		return fadeAnimationActive;
	}

	// Getters and setters

	public float getTransparency() {
		return this.transparency;
	}

	public float getFadeTime() {
		return fadeTime;
	}

	public void setFadeTime(float fadeTime) {
		this.fadeTime = fadeTime;
	}

	public float getInitialAlpha() {
		return initialAlpha;
	}

	public void setInitialAlpha(float initialAlpha) {
		this.initialAlpha = initialAlpha;
	}

	public float getFinalAlpha() {
		return finalAlpha;
	}

	public void setFinalAlpha(float finalAlpha) {
		this.finalAlpha = finalAlpha;
	}
}
