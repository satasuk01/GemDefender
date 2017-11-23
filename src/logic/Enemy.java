package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
	//private int angle = 0;
	private int stage = 1;
	private Image sprite;
	
	public Enemy(int maxHp,double normalSpeed) { //speed = 1.5 hp=100
		speed = normalSpeed;
		this.normalSpeed = normalSpeed;
		this.maxHp = maxHp;
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
			if(x>Field.getPositionX(9)){
				this.x = Field.getPositionX(9);
				this.y = Field.getPositionY(3);
				stage = 5;
			}
		}
		
		if(stage == 5) {
			this.y += speed;
			if(y>Field.getPositionY(16)){
				this.x = Field.getPositionX(9);
				this.y = Field.getPositionY(16);
				stage = 6;
			}
		}
		if(stage == 6) {
			this.x += speed;
			if(x>Field.getPositionX(13)){
				this.x = Field.getPositionX(13);
				this.y = Field.getPositionY(16);
				stage = 7;
			}
		}
		if(stage == 7) {
			this.y += speed;
			if(y>Field.getPositionY(18)){
				this.x = Field.getPositionX(13);
				this.y = Field.getPositionY(18);
				stage = 8;
			}
		}
		if(stage == 8) {
			this.x += speed;
			if(x>Field.getPositionX(15)){
				this.x = Field.getPositionX(15);
				this.y = Field.getPositionY(18);
				stage = 9;
			}
		}
		if(stage == 9) {
			this.y -= speed;
			if(y<Field.getPositionY(1)){
				this.x = Field.getPositionX(15);
				this.y = Field.getPositionY(1);
				stage = 10;
			}
		}
		if(stage == 10) {
			this.x += speed;
			if(x>Field.getPositionY(19)){
				this.x = Field.getPositionX(19);
				this.y = Field.getPositionY(1);
				stage = 11;
			}
		}
		if(stage == 11) {
			this.y += speed;
			if(y>Field.getPositionY(17)){
				this.x = Field.getPositionX(19);
				this.y = Field.getPositionY(17);
				stage = 12;
			}
		}
		if(stage == 12) {
			this.x += speed;
			if(x>Field.getPositionY(23)){
				this.x = Field.getPositionX(23);
				this.y = Field.getPositionY(17);
				stage =13;
			}
		}
		if(stage == 13) {
			this.y -= speed;
			if(y<Field.getPositionY(2)){
				this.x = Field.getPositionX(23);
				this.y = Field.getPositionY(2);
				stage = 14;
			}
		}
		if(stage == 14) {
			this.x += speed;
			if(x>Field.getPositionY(27)){
				this.x = Field.getPositionX(27);
				this.y = Field.getPositionY(2);
				stage = 15;
			}
		}
		if(stage == 15) {
			this.y += speed;
			if(y>Field.getPositionY(19)){
				this.x = Field.getPositionX(27);
				this.y = Field.getPositionY(19);
				this.speed = 0;
			}
		}
	}
	public void getHit(int damage) {
		this.hp -= damage;
		//System.out.println("Take damage");
	}
	public void freeze(int duration) {
		if(!freezed) {
			speed = normalSpeed/5;
			freezed = true;
			freezedDuration=duration;
		}
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
		/*Font font = Font.font("Times New Roman",FontWeight.LIGHT,10);
		gc.setFont(font);
		gc.setFill(Color.GREEN);
		gc.fillText(Integer.toString(hp), x-radius, y-radius + 12);*/
		if(hp>0) {
			gc.setFill(Color.rgb((int)(255 *(1-(double)(hp)/(double)(maxHp))), (int)(255 *(double)(hp)/(double)(maxHp)), 0));
			gc.fillRect(x-12.5, y-16, 25*(double)(hp)/(double)(maxHp), 3);
		}
		//-------------------------
		
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
