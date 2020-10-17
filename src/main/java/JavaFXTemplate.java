import java.util.HashMap;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
//	TextField t1;
//	
	private Button startButton, b1;
	private TextField t1, text;
	private MenuBar menu;
	
	HashMap<String, Scene> sceneMap;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));
	EventHandler<ActionEvent> returnButtons;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Keno Game!");

		
		sceneMap = new HashMap<String,Scene>();
		//sceneMap.put("WelcomeScene", createControlScene());
		sceneMap.put("GameScene", createControlScene());
		
		
		//pause for 1 second then switch scene from picture buttons to original layout
//		pause.setOnFinished(e->primaryStage.setScene(sceneMap.get("GameScene")));
		
//		//this handler is used by multiple buttons 
//		returnButtons = new EventHandler<ActionEvent>(){
//			public void handle(ActionEvent event){
//				Button b = (Button)event.getSource();
//				b.setDisable(true);
//				primaryStage.setScene(sceneMap.get("GameScene"));
////				pause.play(); //calls setOnFinished
//			}
//		};
		
		
		// Add an image to the welcome scene
		// the image is a clickable image which takes the user to the
		// game scene where you can play the game
		
		//BorderPane pane = new BorderPane();
		Image pic = new Image("StartupImage.png");
		ImageView v = new ImageView(pic);
		v.setPreserveRatio(true);
		v.fitWidthProperty().bind(primaryStage.widthProperty());
		
		startButton = new Button();
		startButton.setOnAction(e->primaryStage.setScene(sceneMap.get("GameScene")));
		startButton.setGraphic(v);
		
		//pane.setCenter(startButton);
		
		// Add a menu with 1 tab and a few options
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mMenu = new Menu("Menu"); //a menu goes inside a menu bar
		
		// Menu items
		MenuItem iRules = new MenuItem("Rules");
		MenuItem iWinning = new MenuItem("Odds of Winning");
		MenuItem iExit = new MenuItem("Exit");
		
		iExit.setOnAction(e -> Platform.exit());
		
		//Creating a Text object 
	    text = new TextField();
	    text.setText("Hi!  Testing!!!!!");
	    text.setEditable(false);
	    text.setVisible(false);
	      
	    //Setting the text to be added. 
	    //text.setText("Hello how are you"); 
	    iRules.setOnAction(e -> text.setVisible(true));
		
		// Add menu items to menu option
		// Add menus to menu tab
		mMenu.getItems().addAll(iRules, iWinning, iExit);
		menu.getMenus().add(mMenu);
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(new VBox(startButton), text);
		// Set up the scene
		Scene scene = new Scene(new VBox(menu, stackPane), 700, 700);
//		Scene scene = new Scene(startButton, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//method to create our first scene with controls
	public Scene createControlScene() {
		
		b1 = new Button("button 1");
		t1 = new TextField();
		
		//use a lambda expression to attach the event handler to a button
		b1.setOnAction(e->t1.setText("I love this syntax!!!!"));
		
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mOne = new Menu("option 1"); //a menu goes inside a menu bar
		Menu mTwo = new Menu("option 2");
		
		MenuItem iOne = new MenuItem("click me"); //menu items go inside a menu
		
		//event handler for menu item
		iOne.setOnAction(e->t1.setText("menu item was clicked")); 
		
		mOne.getItems().add(iOne); //add menu item to first menu
		
		menu.getMenus().addAll(mOne, mTwo); //add two menus to the menu bar
		
		
		return new Scene(new VBox(menu,b1,t1), 700,700);
	}
	
	//method to create second scene with clickable buttons
//	public Scene createPicScene() {
//		
//		Image pic = new Image("cozmo.jpg");
//		ImageView v = new ImageView(pic);
//		v.setPreserveRatio(true);
//		
//				
//		startButton = new Button();
//		startButton.setOnAction(returnButtons);
//		startButton.setGraphic(v);
//		
//		
//		HBox root = new HBox(5, startButton);
//		root.setStyle("-fx-background-color: lightblue;");
//		
//		return new Scene(root, 900,800);
//		
//	}

}
