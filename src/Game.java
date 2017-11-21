
import drawing.GameScreen;
import drawing.PaneForRenderImageViews;
/*import input.InputUtility;*/
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import menu.BottomMenu;
import menu.TowerMenu;
import sharedObject.RenderableHolder;

public class Game extends Application {

	@Override
	public void start(Stage stage) {
		//---Base---
		GridPane base = new GridPane();
		base.setPrefWidth(800);
		base.setMaxWidth(800);
		base.setMinWidth(800);
		base.setPrefHeight(600);
		base.setMaxHeight(600);
		base.setMinHeight(600);
		
		GridPane topbase = new GridPane();
		GridPane bottombase = new GridPane();
		base.add(topbase, 0, 0);
		base.add(bottombase, 0, 1);
		//---Tower Select Menu
		TowerMenu towerMenu = new TowerMenu(50,500);
		topbase.add(towerMenu, 1, 0);
		//---Bottom Menu
		BottomMenu bottomMenu = new BottomMenu(800,100);
		bottombase.add(bottomMenu, 0, 0);

		//---MainGame:Development stage----
		
		StackPane root = new StackPane();
		

		GameLogic logic = new GameLogic();
		GameScreen gameScreen = new GameScreen(750, 500);
		PaneForRenderImageViews pr = new PaneForRenderImageViews(750,500);
		root.getChildren().add(gameScreen);
		root.getChildren().add(pr);
		//gameScreen.requestFocus();
		

		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logic.logicUpdate();
				RenderableHolder.getInstance().update();
				pr.paintImageView();
				//InputUtility.updateInputState();
			}
		};
		animation.start();
		
		topbase.add(root, 0, 0);
		//------------------------
		
		
		
		//---Add to base

		Scene scene = new Scene(base);
		stage.setScene(scene);
		stage.setTitle("Gem Defender");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
