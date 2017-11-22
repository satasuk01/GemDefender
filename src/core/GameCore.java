package core;

import logic.ArrowTower;
import logic.GameLogic;
import logic.IceTower;
import logic.Tower;
import sharedObject.RenderableHolder;

public class GameCore { //Maybe make it as a singleton
	private static int gold=0;
	private static Tower selectedTower=null;
	private static int buyStatus=0; //0 is nothing, 1 is an ArrowTower, 2 is an IceTower
	public static int getGold() {
		return gold;
	}
	public static void addGold(int amount) {
		gold += amount;
	}
	public static void decreaseGold(int amount) {
		gold -= amount;
		if(gold<0) gold = 0;
	}
	
	public static void setSelectedTower(Tower tower) {
		selectedTower = tower;
		System.out.println("selected");
	}
	public static void sellTower() {
		if(selectedTower != null) {
			addGold(selectedTower.getPrice()/2);
			selectedTower.destroy();
			selectedTower = null;
		}
	}
	
	public static void setBuyStatus(int number) {
		buyStatus = number; //TODO set If the gold is enough to buy
	}
	public static int getBuyStatus() {
		return buyStatus;
	}
	public static void placeTower(int row,int column) {
		if(buyStatus != 0) {
			boolean canPlace=true;
			for(Tower tower:GameLogic.getTower()) {
				if(tower.getRow() == row && tower.getColumn() == column) canPlace = false;
			}
			if(canPlace) {
				if(buyStatus == 1) {
					ArrowTower arrowTower = new ArrowTower(row,column);
					GameLogic.gameObjectContainer.add(arrowTower);
					RenderableHolder.getInstance().add(arrowTower);
				}
				if(buyStatus == 2) {
					IceTower iceTower = new IceTower(row,column);
					GameLogic.gameObjectContainer.add(iceTower);
					RenderableHolder.getInstance().add(iceTower);
				}
				else {
					
				}
			}
			else {
				System.out.println("That cell already has a tower!!!");
			}
			buyStatus = 0;
		}
	}
}