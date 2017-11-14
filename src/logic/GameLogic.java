package logic;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
	public static List<Entity> gameObjectContainer;
	
	public GameLogic() {
		GameLogic.gameObjectContainer = new ArrayList<Entity>();
	}
	
	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		//TODO add this into RenderableHolder
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
}
