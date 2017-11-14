package logic;

public class ArrowTower extends Tower {
	public void ArrowTower(){
		this.price = 50;
		this.damage = 10;
		this.splashAttack = false;
		this.range = 50;
		this.fireRate = 10;
		this.fireCount = 0;
	}
	
	protected void Attack() {
		int nearestDistance = range;
		Enemy lockedEnemy = null;;
		for(Enemy enemy : GameLogic.getEnemy()) {
			if(inRange(enemy)<=nearestDistance) {
				nearestDistance = inRange(enemy);
				lockedEnemy = enemy;
			}
		}
		if(lockedEnemy != null) lockedEnemy.getHit(damage);
		nearestDistance = range;
		lockedEnemy = null;
	}
	
	public void update() {
		//----------Attack-------
		if(fireCount > fireRate) {
			Attack();
		}else {
			fireCount = 0;
		}
		fireCount ++;
		//----------------------
	}
}
