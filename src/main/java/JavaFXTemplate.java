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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
	private Button startButton, b1;
	private TextField t1, text;
	private MenuBar menu;
	private EventHandler<ActionEvent> myHandler;
	
	HashMap<String, Scene> sceneMap;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));
	EventHandler<ActionEvent> returnButtons;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to Keno Game!");

		
		sceneMap = new HashMap<String,Scene>();
		//sceneMap.put("WelcomeScene", createControlScene());
		sceneMap.put("GameScene", createControlScene());
		
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
		
//////////////////// Add a menu with 1 tab and a few options ///////////////////////
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

/////////////////////////////////////////////////////////////////////////////////////
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(new VBox(startButton), text);
		// Set up the scene
		Scene scene = new Scene(new VBox(menu, stackPane), 700, 700);
//		Scene scene = new Scene(startButton, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// method to create our first scene with controls
	public Scene createControlScene() {
		
		BorderPane border = new BorderPane();
		
////////////// Adding A Menu at the TOP////////////////////////////////////////////
		
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
		
///////////// Adding a GridPane in the CENTER /////////////////////////////////////////
		
		myHandler = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				System.out.println("button pressed: " + ((Button)e.getSource()).getText());
				Button b1 = (Button)e.getSource();
				b1.setDisable(true);
			}
		};
		
		GridPane grid = new GridPane();
		addGrid(grid); //populate the GridPane with buttons

//////////////// Setup the GridPane in the RIGHT  //////////////////////////////////////
		// The plan is make a vbox on the right side of the grid pane
		// which displays all the required text.
		
		VBox vbox = new VBox();
		
   //////////////////////////////////////////////		
        Text text1 = new Text();      
        text1.setText("Select the number of spots");

        ToggleGroup spotsGroup = new ToggleGroup();  
        RadioButton button1 = new RadioButton("1 spot");  
        RadioButton button2 = new RadioButton("4 spots");  
        RadioButton button3 = new RadioButton("8 spots");  
        RadioButton button4 = new RadioButton("10 spots");  
        button1.setToggleGroup(spotsGroup);  
        button2.setToggleGroup(spotsGroup);  
        button3.setToggleGroup(spotsGroup);  
        button4.setToggleGroup(spotsGroup);
        
//        vbox.setSpacing(10);  
//        vbox.getChildren().addAll(text1,button1,button2,button3,button4);  
        
	///////////////////////////////////////////////////
        Text text2 = new Text();
        text2.setText("Select the number of drawings");
        
        ToggleGroup drawingsGroup = new ToggleGroup();  
        RadioButton button5 = new RadioButton("1 drawing");  
        RadioButton button6 = new RadioButton("2 drawings");  
        RadioButton button7 = new RadioButton("3 drawings");  
        RadioButton button8 = new RadioButton("4 drawings");  
        button5.setToggleGroup(drawingsGroup);  
        button6.setToggleGroup(drawingsGroup);  
        button7.setToggleGroup(drawingsGroup);  
        button8.setToggleGroup(drawingsGroup);
        
    /////////////////////////////////////////////////
       
        Button submitButton = new Button("Submit Changes!");
        
    /////////////////////////////////////////////////    
        
        vbox.setSpacing(10);  
        vbox.getChildren().addAll(text1,button1,button2,button3,button4,text2,button5,button6,button7,button8,submitButton);
        
/////////////// Setup GridPane View /////////////////////////////////////////////////
		
		border.setTop(menu);
		border.setCenter(grid);
		border.setRight(vbox);
		
////////////////////////////////////////////////////////////////////////////////////
		
		return new Scene(border, 700,700);
	}
	
	/*
	 * method to populate a GridPane with buttons and attach a handler to each button
	 */
	public void addGrid(GridPane grid) {
		int counter;
		for(int x = 0; x<10; x++) {
			for(int i = 0; i<8; i++) {
				counter  = (10*i) + x + 1;
				Button b1 = new Button(Integer.toString(counter));
				b1.setOnAction(myHandler);
				grid.add(b1, x, i);
			}
		}
	}


}
