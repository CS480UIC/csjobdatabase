import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {
	
	private Button startButton, b1, next, reset;
	private TextField t1, text;
	private MenuBar menu;
	private EventHandler<ActionEvent> myHandler;
	
	ArrayList<String> matchedNums = new ArrayList<String>();
	int iterations = 0, numPressed = 0, drawingLoops = 0;
	int numCounter = 0;
	String temp = "The draw is: ";
	String matches = "";
	int selectedSpot;
	int gameScore = 0;
	
	HashMap<String, Scene> sceneMap;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));
	EventHandler<ActionEvent> returnButtons, submitAction, randomHandler, drawingsHandler, checker, finalNumEvent;
	
	Queue<String> myQueue;
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
		sceneMap.put("ResultsScene", resultsControlScene());
		
		next.setOnAction( e->primaryStage.setScene(sceneMap.get("ResultsScene")));
		//reset.setOnAction(e->primaryStage.setScene(sceneMap.get("GameScene")));
		
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
 
		Dialog<String> dialogRules = new Dialog<String>();
        //Setting the title
        dialogRules.setTitle("Rules");
        ButtonType typeRules = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogRules.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogRules.getDialogPane().getButtonTypes().add(typeRules);
		
		iRules.setOnAction(e -> {
			dialogRules.showAndWait();
	    });
		
		Dialog<String> dialogOdds = new Dialog<String>();
        //Setting the title
        dialogOdds.setTitle("Odds of Winning");
        ButtonType typeOdds = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogOdds.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogOdds.getDialogPane().getButtonTypes().add(typeOdds);
		
		iWinning.setOnAction(e -> {
			dialogOdds.showAndWait();
	    });
		
		// Add menu items to menu option
		// Add menus to menu tab
		
		mMenu.getItems().addAll(iRules, iWinning, iExit);
		menu.getMenus().add(mMenu);
		
/////////////////////////////////////////////////////////////////////////////////////
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(new VBox(startButton));
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
		
		//BorderPane pane = new BorderPane();
		
		Button random = new Button();
        random.setText("Random");
        random.setDisable(true);
        
        reset = new Button();
        reset.setText("Reset");
        reset.setDisable(true);
        
        next = new Button();
        next.setText("Next");
        next.setDisable(true);
		
////////////// Adding A Menu at the TOP////////////////////////////////////////////
		
		// Add a menu with 1 tab and a few options
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mMenu = new Menu("Menu"); //a menu goes inside a menu bar
		
		// Menu items
		MenuItem iRules = new MenuItem("Rules");
		MenuItem iWinning = new MenuItem("Odds of Winning");
		MenuItem iLook = new MenuItem("New Look");
		MenuItem iExit = new MenuItem("Exit");
		
		iExit.setOnAction(e -> Platform.exit());
		
		//iLook.setOnAction(e-> pane.setStyle("-fx-background-color: lightBlue;"));
		
		Dialog<String> dialogRules = new Dialog<String>();
        //Setting the title
        dialogRules.setTitle("Rules");
        ButtonType typeRules = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogRules.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogRules.getDialogPane().getButtonTypes().add(typeRules);
		
		iRules.setOnAction(e -> {
			dialogRules.showAndWait();
	    });
		
		Dialog<String> dialogOdds = new Dialog<String>();
        //Setting the title
        dialogOdds.setTitle("Odds of Winning");
        ButtonType typeOdds = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogOdds.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogOdds.getDialogPane().getButtonTypes().add(typeOdds);
		
		iWinning.setOnAction(e -> {
			dialogOdds.showAndWait();
	    });
		
		// Add menu items to menu option
		// Add menus to menu tab
		mMenu.getItems().addAll(iRules, iWinning, iLook, iExit);
		menu.getMenus().add(mMenu);
		
///////////// Adding a GridPane and spots toggle in a HBox /////////////////////////////////////////		
		
		storeQueueItemsInListView = FXCollections.observableArrayList();
		myQueue = new LinkedList<String>();
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
					//myQueue.enqueue(t);
					myQueue.add(t);
					
					displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
					storeQueueItemsInListView.clear();
					//Iterator<String> i = myQueue.createIterator();
					
					for(String a:myQueue) {
						storeQueueItemsInListView.add(a);
					}
					
//					
//					while(i.hasNext()) { 
//						storeQueueItemsInListView.add(i.next());
//					}
					
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
				//selectedSpot = toogleGroupValue;
				
				if(toogleGroupValue == "1 spot") {
					iterations = 1;
				}else if(toogleGroupValue == "4 spots") {
					iterations = 4;
				}else if(toogleGroupValue == "8 spots") {
					iterations = 8;
				}else if(toogleGroupValue == "10 spots") {
					iterations = 10;
				}
				selectedSpot = iterations;
				
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
			    	//myQueue.enqueue(String.valueOf(temp));
			    	myQueue.add(String.valueOf(temp));
			    }
			    
			    displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
				storeQueueItemsInListView.clear();
//				Iterator<String> j = myQueue.createIterator();
//				while(j.hasNext()) { 
//					storeQueueItemsInListView.add(j.next());
//				}
				
				for(String j:myQueue) {
					storeQueueItemsInListView.add(j);
				}
				
				displayQueueItems.setItems(storeQueueItemsInListView);
				
//				Iterator<String> y = myQueue.createIterator();
//				while(y.hasNext()) { 
//					System.out.println(y.next());
//				}
				for(String y:myQueue) {
					System.out.println(y);
				}
				
			}
		};
        
        random.setOnAction(randomHandler);
                
//        reset.setOnAction(e->primaryStage.setScene(sceneMap.get("GameScene")));
        
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
		
		//pane.setCenter(main);
		iLook.setOnAction(e-> main.setStyle("-fx-background-color: lightBlue;"));		
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
	
	public Scene resultsControlScene() {
		
//////////////Adding A Menu at the TOP////////////////////////////////////////////
		
	// Add a menu with 1 tab and a few options
		menu = new MenuBar(); //a menu bar takes menus as children
		Menu mMenu = new Menu("Menu"); //a menu goes inside a menu bar
		
		// Menu items
		MenuItem iRules = new MenuItem("Rules");
		MenuItem iWinning = new MenuItem("Odds of Winning");
		MenuItem iLook = new MenuItem("New Look");
		MenuItem iExit = new MenuItem("Exit");
		
		iExit.setOnAction(e -> Platform.exit());
		
		Dialog<String> dialogRules = new Dialog<String>();
        //Setting the title
        dialogRules.setTitle("Rules");
        ButtonType typeRules = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogRules.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogRules.getDialogPane().getButtonTypes().add(typeRules);
		
		iRules.setOnAction(e -> {
			dialogRules.showAndWait();
	    });
		
		Dialog<String> dialogOdds = new Dialog<String>();
        //Setting the title
        dialogOdds.setTitle("Odds of Winning");
        ButtonType typeOdds = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogOdds.setContentText("This is a sample dialog");
        //Adding buttons to the dialog pane
        dialogOdds.getDialogPane().getButtonTypes().add(typeOdds);
		
		iWinning.setOnAction(e -> {
			dialogOdds.showAndWait();
	    });
		
		// Add menu items to menu option
		// Add menus to menu tab
		mMenu.getItems().addAll(iRules, iWinning, iLook, iExit);
		menu.getMenus().add(mMenu);
		
		/////////////////////////////////////////////////////////////////
		
		Text drawingsText = new Text();      
        drawingsText.setText("Select the number of drawings");
        
	    ToggleGroup drawingsGroup = new ToggleGroup();  
	    RadioButton button5 = new RadioButton("1 drawing");  
	    RadioButton button6 = new RadioButton("2 drawings");  
	    RadioButton button7 = new RadioButton("3 drawings");  
	    RadioButton button8 = new RadioButton("4 drawings");  
	    button5.setToggleGroup(drawingsGroup);  
	    button6.setToggleGroup(drawingsGroup);  
	    button7.setToggleGroup(drawingsGroup);  
	    button8.setToggleGroup(drawingsGroup);
		
	    HBox drawings = new HBox();
	    drawings.getChildren().addAll(button5,button6,button7,button8);
	    drawings.setSpacing(10);
	    
	    Button drawingsSubmit = new Button();
	    drawingsHandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				drawingsSubmit.setDisable(true);
				
				drawingsGroup.getToggles().forEach(toggle -> { // Disable spotsGroup
				    RadioButton node = (RadioButton) toggle ;
				    node.setDisable(true);
				});
				
				drawingsSubmit.setDisable(true);
				
				RadioButton selectedDrawingsButton = (RadioButton) drawingsGroup.getSelectedToggle();
				String toogleGroupValue = selectedDrawingsButton.getText();
				
				if(toogleGroupValue == "1 drawing") {
					drawingLoops = 1;
				}else if(toogleGroupValue == "2 drawings") {
					drawingLoops = 2;
				}else if(toogleGroupValue == "3 drawings") {
					drawingLoops = 3;
				}else if(toogleGroupValue == "4 drawings") {
					drawingLoops = 4;
				}
				System.out.println(drawingLoops);
				
				
			}	
        };
        drawingsSubmit.setText("Submit");
        drawingsSubmit.setOnAction(drawingsHandler);
        
        Button checkDraws = new Button("Check Draws!");
        
        int[] array = new int[80];
        
        for(int i=0; i<80; i++) {
        	array[i] = i+1;
        }
        
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
        
//        ArrayList<String> matchedNums = new ArrayList<String>();
        
        TextField roundGameScore = new TextField();
        roundGameScore.setVisible(false);
        roundGameScore.setEditable(false);
        roundGameScore.setMinWidth(300);
        
        TextField totalGameScore = new TextField();
        totalGameScore.setVisible(false);
        totalGameScore.setEditable(false);
        totalGameScore.setMinWidth(300);
        
        HBox pointer = new HBox();
        pointer.getChildren().addAll(roundGameScore,totalGameScore);
        
        
        TextField drawNumbers = new TextField();
        drawNumbers.setEditable(false);
        
        TextField matchedNumbers = new TextField();
        matchedNumbers.setEditable(false);
        matchedNumbers.setVisible(false);
        
        Set<Integer>bigSet = new LinkedHashSet<Integer>();

        checker = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				//System.out.println("here");
				bigSet.add(array[numCounter]);
				temp = temp + String.valueOf(array[numCounter]) + "  ";
				drawNumbers.setText(temp);
				numCounter++;
				
				if(bigSet.size() == 20) {

			        //matches = matches + matcher(bigSet,myQueue);
					matchedNums = matcher(bigSet,myQueue);
			        System.out.println("Passed it");
			    	//System.out.println(matches);
			        String str = "The matched numbers are: ";
			        matchedNumbers.setVisible(true);
			        
			        if(matchedNums.size() > 0) {
			        	for(String s:matchedNums) {
				        	str = str + s + "  "; 
				        }
				        matchedNumbers.setText(str);
			        }else {
			        	matchedNumbers.setText("Sorry! Try again!");
			        }
			        int roundScore = scorings(selectedSpot, matchedNums.size());
			        roundGameScore.setVisible(true);
			        totalGameScore.setVisible(true);
			        roundGameScore.setText("Round Score: " + roundScore);
			        gameScore = gameScore + roundScore;
			        totalGameScore.setText("Total Score = " + gameScore);
			        // Empty everything
			        bigSet.clear();
			        temp = "The next draw is: ";
			        numCounter = 0;
			        str = "";
			        roundScore = 0;
			        
			        // make a new shuffled array
			        Random rand = new Random();
			        for (int i = 0; i < array.length; i++) {
						int randomIndexToSwap = rand.nextInt(array.length);
						int temp = array[randomIndexToSwap];
						array[randomIndexToSwap] = array[i];
						array[i] = temp;
					}
				}
				
				

			}        	
        };
        
        Timeline timeline = new Timeline(
        		new KeyFrame(Duration.seconds(1), checker),
        		new KeyFrame(Duration.millis(1000))
        );
        
        timeline.setCycleCount(20);
       	       	
        checkDraws.setOnAction(e -> {
        	timeline.play();       	
        });

        
        Button nextDraw = new Button("Next Draw");
        nextDraw.setOnAction(e -> {
        	timeline.play();
        });
        //nextDraw.setDisable(true);

        
		VBox topDown = new VBox();
		topDown.getChildren().addAll(menu,drawingsText,drawings,drawingsSubmit,checkDraws,drawNumbers,nextDraw,matchedNumbers,pointer);
		topDown.setSpacing(10);
		
		iLook.setOnAction(e-> topDown.setStyle("-fx-background-color: lightGreen;"));
		return new Scene(topDown, 700,700);
	}

	public ArrayList<String> matcher(Set<Integer> bigSet, Queue<String> myQueue) {
			//String answer = "";
			ArrayList<String> matched = new ArrayList<String>();
			System.out.println("Reached the function");

			
			for(String y:myQueue) {
				if(bigSet.contains(Integer.parseInt(y))) {
					matched.add(y);
					//answer = answer + y.next() + "  ";
				}
			}

		return matched;
		
	}
	
	public int scorings(int spots, int matches) {
		int score = 0;
		
		if(spots == 1) {
			
			if (matches == 1) {
				score = 2;
			}
			
		}else if(spots == 4) {
			
			if(matches == 2) {
				score = 1;
			}else if(matches == 3) {
				score = 5;
			}else if(matches == 4) {
				score = 75;
			}
			
		}else if(spots == 8) {
			if(matches == 4) {
				score = 2;
			}else if(matches == 5) {
				score = 12;
			}else if(matches == 6) {
				score = 50;
			}else if(matches == 7) {
				score = 750;
			}else if(matches == 8) {
				score = 10000;
			}
		}else if(spots == 10) {
			if(matches == 0) {
				score = 5;
			}else if(matches == 5) {
				score = 2;
			}else if(matches == 6) {
				score = 15;
			}else if(matches == 7) {
				score = 40;
			}else if(matches == 8) {
				score = 450;
			}else if(matches == 9) {
				score = 4250;
			}else if(matches == 10) {
				score = 100000;
			}
		}
		
		return score;
	}

}
