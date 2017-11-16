package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Enemy extends CollidableEntity {
	private int maxHp;
	private int hp;
	private double normalSpeed;
	private double speed;
	private boolean freezed = false;
	private int freezedDuration = 0;
	private int angle = 0;
	private int stage = 1;
	
	public Enemy(int maxHp,double normalSpeed) { //speed = 1.5 hp=100
		speed = normalSpeed;
		this.normalSpeed = normalSpeed;
		maxHp = maxHp;
		hp = maxHp;
		this.radius = 12;
		this.x = Field.getPositionX(3);
		this.y = Field.getPositionY(0);
		this.z = 0;
	}
	private void move() {
		//Stage1
		if(stage == 1) {
			this.y += speed;
			if(y>Field.getPositionY(17)) {
				this.y = Field.getPositionY(17);
				this.x = Field.getPositionX(3);
				stage = 2;
			}
		}
		
		if(stage == 2) {
			this.x += speed;
			if(x>Field.getPositionX(6)) {
				this.y = Field.getPositionY(17);
				this.x = Field.getPositionX(6);
				stage = 3;
			}
		}
		
		if(stage ==3) {
			this.y -=speed;
			if(y<Field.getPositionY(3)) {
				this.y = Field.getPositionY(3);
				this.x = Field.getPositionX(6);
				stage = 4;
			}
		}
		
		if(stage == 4) {
			this.x += speed;
		}
	}
	public void getHit(int damage) {
		this.hp -= damage;
		//System.out.println("Take damage");
	}
	public void freeze(int duration) {
		speed = normalSpeed/5;
		freezed = true;
		freezedDuration=duration;
	}
	public void update() {
		//Decrease freeze time
		if(freezed) {
			freezedDuration--;
			//System.out.println(freezedDuration);
			//System.out.println(normalSpeed);
			if(freezedDuration<=0) {
				freezed = false;
				speed = normalSpeed;
			}
		}
		//--------------------
		if(hp<=0) {
			this.destroyed = true;
		}
		
		move();
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		//-----Draw radius----------
		gc.setFill(Color.RED);
				
		gc.fillArc(x-radius, y-radius, radius*2, radius*2, 0, 360, ArcType.OPEN);
		//-----Draw HP--------------
		Font font = Font.font("Times New Roman",FontWeight.LIGHT,10);
		gc.setFont(font);
		gc.setFill(Color.GREEN);
		gc.fillText(Integer.toString(hp), x-radius, y-radius + 12);
		
	}
	
	//---------Getters and Setters--------------
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public boolean isFreezed() {
		return freezed;
	}
	public void setFreezed(boolean freezed) {
		this.freezed = freezed;
	}
	//------------------------------------------
	
}
