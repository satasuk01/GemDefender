package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;
//TODO make it private and create a singleton pattern(create one instance)
public class GameLogic {
	public static List<Entity> gameObjectContainer;
	private Spawner spawner;
	private Gem gem;

	public GameLogic() {
		GameLogic.gameObjectContainer = new ArrayList<Entity>();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		gem = new Gem(19,27);
		addNewObject(gem);
		spawner = new Spawner(0,3);
		addNewObject(spawner);
	
		
		System.out.println("add "+RenderableHolder.getInstance().toString());
	}
	
	private void removeDestroyed() {
		for (int i = gameObjectContainer.size() - 1; i >= 0; i--) {
					
					if (gameObjectContainer.get(i).isDestroyed()) {
						gameObjectContainer.remove(i);
					}
					
		}
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);

		//TODO add these into RenderableHolder
		RenderableHolder.getInstance().add(entity);
	}
	
	public static List<Enemy> getEnemy() {
		List<Enemy> enemyList = new ArrayList<Enemy>();
		for(Entity entity: gameObjectContainer) {
			if(entity instanceof Enemy && entity.isDestroyed() == false) {
				enemyList.add((Enemy)entity);
			}
		}
		return enemyList;
	}
	public static List<Tower> getTower(){
		List<Tower> towerList = new ArrayList<Tower>();
		for(Entity entity: gameObjectContainer) {
			if(entity instanceof Tower && entity.isDestroyed() == false) {
				towerList.add((Tower)entity);
			}
		}
		return towerList;
	}
	//TODO delete this var when the game is finished.
	int counter = 0;
	int top =150;
	int tick =0;
	//---------------------------------------------
	
	
	public void logicUpdate() {
		//----Remove Unused Items
		removeDestroyed();
		
		
		//----Enemy Update----
		for(Enemy enemy:getEnemy()) {
			enemy.update();
		}
		//----Tower Update----
		for(Tower tower:getTower()) {
			tower.update();
		}
		gem.update();
		spawner.update();
		
		//---Test group of enemies--- PLS DELETE
		if(counter>top) {
			addNewObject(new Enemy(100+(int)(tick/50),1));
			counter = 0;
		}
		counter ++;
		tick++;
		//---------------------------
	}
}