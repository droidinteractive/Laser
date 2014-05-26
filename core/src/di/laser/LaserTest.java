package di.laser;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * LaserTest 
 * @author Trenton Shaffer
 */
public class LaserTest extends ApplicationAdapter {
	public SpriteBatch batch;
	private Texture texLaserS1;
	private Texture texLaserS2;
	private Texture texLaserM1;
	private Texture texLaserM2;
	private Texture texLaserE1;
	private Texture texLaserE2;
	
	private Sprite spriteLaserS1;
	private Sprite spriteLaserS2;
	private Sprite spriteLaserM1;
	private Sprite spriteLaserM2;
	private Sprite spriteLaserE1;
	private Sprite spriteLaserE2;
	
	private Laser laser1;
	private Laser laser2;
	private Laser laser3;
	private Laser laser4;
	
	private static LaserTest instance = null;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		instance = this;
		
		this.texLaserS1 = new Texture(Gdx.files.internal("data/beamstart1.png"));
		this.texLaserS2 = new Texture(Gdx.files.internal("data/beamstart2.png"));
		this.texLaserM1 = new Texture(Gdx.files.internal("data/beammid1.png"));
		this.texLaserM2 = new Texture(Gdx.files.internal("data/beammid2.png"));
		this.texLaserE1 = new Texture(Gdx.files.internal("data/beamend1.png"));
		this.texLaserE2 = new Texture(Gdx.files.internal("data/beamend2.png"));
		
		this.spriteLaserS1 = new Sprite(this.texLaserS1);
		this.spriteLaserS2 = new Sprite(this.texLaserS2);
		this.spriteLaserM1 = new Sprite(this.texLaserM1);
		this.spriteLaserM2 = new Sprite(this.texLaserM2);
		this.spriteLaserE1 = new Sprite(this.texLaserE1);
		this.spriteLaserE2 = new Sprite(this.texLaserE2);
		
		this.laser1 = new Laser();
		laser1.begin1 = this.spriteLaserS1;
		laser1.begin2 = this.spriteLaserS2;
		laser1.mid1 = this.spriteLaserM1;
		laser1.mid2 = this.spriteLaserM2;
		laser1.end1 = this.spriteLaserE1;
		laser1.end2 = this.spriteLaserE2;
		laser1.position.set(50, 50);
		
		this.laser2 = new Laser();
		laser2.begin1 = this.spriteLaserS1;
		laser2.begin2 = this.spriteLaserS2;
		laser2.mid1 = this.spriteLaserM1;
		laser2.mid2 = this.spriteLaserM2;
		laser2.end1 = this.spriteLaserE1;
		laser2.end2 = this.spriteLaserE2;
		laser2.position.set(0, 200);
		laser2.color = Color.GREEN;
		laser2.degrees = -90;
		
		this.laser3 = new Laser();
		laser3.begin1 = this.spriteLaserS1;
		laser3.begin2 = this.spriteLaserS2;
		laser3.mid1 = this.spriteLaserM1;
		laser3.mid2 = this.spriteLaserM2;
		laser3.end1 = this.spriteLaserE1;
		laser3.end2 = this.spriteLaserE2;
		laser3.position.set(300, Gdx.graphics.getHeight());
		laser3.color = Color.BLUE;
		laser3.degrees = 180;
		
		this.laser4 = new Laser();
		laser4.begin1 = this.spriteLaserS1;
		laser4.begin2 = this.spriteLaserS2;
		laser4.mid1 = this.spriteLaserM1;
		laser4.mid2 = this.spriteLaserM2;
		laser4.end1 = this.spriteLaserE1;
		laser4.end2 = this.spriteLaserE2;
		laser4.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);
		laser4.color = Color.ORANGE;
		laser4.degrees = 0;
		
	}

	float add;
	float deltaTime;
	@Override
	public void render () {
		add += Gdx.graphics.getDeltaTime();
		deltaTime = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		laser1.distance = (100+add*100%300);
		laser2.distance = (10+add*100%700);
		laser3.distance = (2+add*100%400);
		laser4.degrees = 10*add;
		
		batch.begin();
		laser1.render(deltaTime);
		laser2.render(deltaTime);
		laser3.render(deltaTime);
		laser4.render(deltaTime);
		batch.end();
	}
	
	/**
	 * Accessor
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static final <T extends LaserTest> T get() {
		return (T) instance;
	}
}
