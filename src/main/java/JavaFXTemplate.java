import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
	private Button startButton, b1;
	private TextField t1, text;
	private MenuBar menu;
	private EventHandler<ActionEvent> myHandler;
	
	int iterations = 0, numPressed = 0;;
	
	HashMap<String, Scene> sceneMap;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));
	EventHandler<ActionEvent> returnButtons, submitAction, randomHandler;
	
	GenericQueue<String> myQueue;
	//ListView<String> displayQueueItems;
	ObservableList<String> storeQueueItemsInListView;
	
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
		//sceneMap.put("ResultsScene", resultsControlScene());
		
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
	
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
	// method to create our first scene with controls
	public Scene createControlScene() {
		
		Button random = new Button();
        random.setText("Random");
        random.setDisable(true);
        
        Button reset = new Button();
        reset.setText("Reset");
        reset.setDisable(true);
        
        Button next = new Button();
        next.setText("Next");
        next.setDisable(true);
		
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
		
///////////// Adding a GridPane and spots toggle in a HBox /////////////////////////////////////////		
		
//		GridPane grid = new GridPane();
//		addGrid(grid); //populate the GridPane with buttons
		
		storeQueueItemsInListView = FXCollections.observableArrayList();
		myQueue = new GenericQueue<String>("The selected numbers are:");
		ListView<String> displayQueueItems = new ListView<String>();
		
		myHandler = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				
				random.setDisable(true);
				
				if (numPressed < iterations) {
					String t = ((Button)e.getSource()).getText();
					System.out.println("button pressed: " + ((Button)e.getSource()).getText());
					Button b1 = (Button)e.getSource();
					//b1.setMinWidth(50);
					b1.setDisable(true);
					myQueue.enqueue(t);
					
					displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
					storeQueueItemsInListView.clear();
					Iterator<String> i = myQueue.createIterator();
					while(i.hasNext()) { 
						storeQueueItemsInListView.add(i.next());
					}
					
					displayQueueItems.setItems(storeQueueItemsInListView);
					numPressed++;
				}else {
					//grid.setDisable(true);
					
				}
			}
		};
		
		GridPane grid = new GridPane();
		addGrid(grid); //populate the GridPane with buttons
		
		// Initially disable the grid so that it doesn't work
		grid.setDisable(true); 
		
	////////////////////////////////////////////////	
		displayQueueItems.setStyle("-fx-font-size: 15;"+"-fx-border-size: 20;"+ 
				"-fx-border-color: purple;");

//////////////// Setup the GridPane in the RIGHT  //////////////////////////////////////
		
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
        
	///////////////////////////////////////////////////
//        Text text2 = new Text();
//        text2.setText("Select the number of drawings");
//        
//        ToggleGroup drawingsGroup = new ToggleGroup();  
//        RadioButton button5 = new RadioButton("1 drawing");  
//        RadioButton button6 = new RadioButton("2 drawings");  
//        RadioButton button7 = new RadioButton("3 drawings");  
//        RadioButton button8 = new RadioButton("4 drawings");  
//        button5.setToggleGroup(drawingsGroup);  
//        button6.setToggleGroup(drawingsGroup);  
//        button7.setToggleGroup(drawingsGroup);  
//        button8.setToggleGroup(drawingsGroup);
        
    /////////////////////////////////////////////////
        Button submitButton = new Button("Submit Changes!");
        //submitButton.setDisable(true);
        
        submitAction = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				grid.setDisable(false); // Enable the grid
				random.setDisable(false);
				next.setDisable(false);
				reset.setDisable(false);
				
//				text1.setDisable(true); // Diable the text before the buttons
				
				spotsGroup.getToggles().forEach(toggle -> { // Disable spotsGroup
				    RadioButton node = (RadioButton) toggle ;
				    node.setDisable(true);
				});
				
				submitButton.setDisable(true);
				
				RadioButton selectedSpotsButton = (RadioButton) spotsGroup.getSelectedToggle();
				String toogleGroupValue = selectedSpotsButton.getText();
				
				if(toogleGroupValue == "1 spot") {
					iterations = 1;
				}else if(toogleGroupValue == "4 spots") {
					iterations = 4;
				}else if(toogleGroupValue == "8 spots") {
					iterations = 8;
				}else if(toogleGroupValue == "10 spots") {
					iterations = 10;
				}
				
			}
        	
        };
        
        submitButton.setOnAction(submitAction);
        
    /////////////////////////////////////////////////    
     		
     	VBox vbox = new VBox();
        vbox.setSpacing(10);  
        vbox.getChildren().addAll(text1,button1,button2,button3,button4,submitButton);
        
    /////////////////////////////////////////////////
        
        randomHandler = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				
				grid.setDisable(true);
				
				Random randNum = new Random();
			    Set<Integer>set = new LinkedHashSet<Integer>();
			    while (set.size() < iterations) {
			       set.add((randNum.nextInt(80)+1));
			    }
			    
			    for (int temp : set) {
			    	myQueue.enqueue(String.valueOf(temp));
			    }
			    
			    displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
				storeQueueItemsInListView.clear();
				Iterator<String> j = myQueue.createIterator();
				while(j.hasNext()) { 
					storeQueueItemsInListView.add(j.next());
				}
				
				displayQueueItems.setItems(storeQueueItemsInListView);
			}
		};
        
        random.setOnAction(randomHandler);
        
        
        //reset.setOnAction();
        //next.setOnAction(e->Scene.setScene(sceneMap.get("GameScene")));
        
/////////////// Setup GridPane View /////////////////////////////////////////////////
		
        VBox main = new VBox();
        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        
        first.getChildren().addAll(grid,vbox);
        first.setSpacing(10);
        second.getChildren().addAll(random,reset);
        second.setSpacing(50);
        third.getChildren().addAll(displayQueueItems,next);
        third.setSpacing(20);
        
        main.getChildren().addAll(menu,first,second,third);
		main.setSpacing(20);
////////////////////////////////////////////////////////////////////////////////////
		
		return new Scene(main, 700,700);
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
				b1.setMinWidth(45);
				grid.add(b1, x, i);
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
//	public Scene resultsControlScene() {
//		
//		Text text2 = new Text();      
//        text2.setText("RESULTS!");
//		return new Scene(b1,700,700);
//	}

}
