package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Tower;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	public static Image mapSprite;
	public static Image arrowTowerSprite;
	public static Image iceTowerSprite;
	public static Image bottomMenuSprite;
	public static Image towerMenuSprite;
	public static Image arrowButton;
	public static Image iceButton;
	public static Image sellButton;
	//public static AudioClip  explosionSound;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		//mapSprite = new Image("file:res/NewMap.png");
		mapSprite = new Image(ClassLoader.getSystemResource("NewMap.png").toString());
		arrowTowerSprite = new Image(ClassLoader.getSystemResource("ArrowTower.png").toString());
		//iceTowerSprite = new Image(ClassLoader.getSystemResource("IceTower.png").toString());
		bottomMenuSprite = new Image(ClassLoader.getSystemResource("BottomMenu.png").toString());
		towerMenuSprite = new Image(ClassLoader.getSystemResource("TowerMenu.png").toString());
		sellButton = new Image(ClassLoader.getSystemResource("remove.png").toString());
		iceButton = new Image(ClassLoader.getSystemResource("IceButton.png").toString());
		arrowButton = new Image(ClassLoader.getSystemResource("ArrowButton.png").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		System.out.println(entity.toString()+"Added");
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			
			if (entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
			
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
	public List<Tower> getTowers(){
		List<Tower> towerList = new ArrayList<Tower>();
		for(IRenderable entity: RenderableHolder.getInstance().getEntities()) {
			if(entity instanceof Tower && entity.isDestroyed() == false && entity.isVisible()) {
				towerList.add((Tower)entity);
			}
		}
		return towerList;
	}
}
