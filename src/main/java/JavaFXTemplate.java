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
	
	private Button startButton, b1, next, reset, playAgain, random, submitButton, drawingsSubmit, checkDraws, nextDraw, exitButton;
	private TextField t1, text, roundGameScore, drawNumbers, matchedNumbers;
	private MenuBar menu;
	private EventHandler<ActionEvent> myHandler;
	
	ArrayList<String> matchedNums = new ArrayList<String>();
	int iterations = 0, numPressed = 0, drawingLoops = 0,drawingLoopsCounter = 1;
	int numCounter = 0, selectedSpot = 0, gameScore = 0, roundScore = 0;
	String temp = "The draw is: ";
	String matches = "";
	String str = "";
	
	GridPane grid;
	ListView<String> displayQueueItems;
	ToggleGroup spotsGroup, drawingsGroup;
	
	HashMap<String, Scene> sceneMap;
	PauseTransition pause = new PauseTransition(Duration.seconds(1));
	EventHandler<ActionEvent> returnButtons, submitAction, randomHandler, drawingsHandler, checker, finalNumEvent, playAgainhandler;
	
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
		sceneMap.put("GameScene", createControlScene());
		sceneMap.put("ResultsScene", resultsControlScene());
		
		// Change scene on button click
		next.setOnAction( e->primaryStage.setScene(sceneMap.get("ResultsScene")));
		
		// Event handler for play again and reset buttons
        playAgainhandler = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				primaryStage.setScene(sceneMap.get("GameScene"));
				// Reseting All the Buttons
				random.setDisable(true);
				reset.setDisable(true);
				next.setDisable(true);
				submitButton.setDisable(false);
				drawingsSubmit.setDisable(false);
				checkDraws.setDisable(false);
				nextDraw.setDisable(true);
				nextDraw.setVisible(false);
				playAgain.setVisible(false);
				exitButton.setVisible(false);
				b1.setDisable(false);
				
				//clearing the listview
				storeQueueItemsInListView.clear();
				displayQueueItems.getItems().clear();
				myQueue.clear();
				
				//setting all the counters to their original values
				iterations = 0;
				numPressed = 0;
				drawingLoops = 0;
				drawingLoopsCounter = 1;
				numCounter = 0;
				selectedSpot = 0;
				temp = "The draw is: ";
				matches = "";
				str = "";
				roundScore = 0;
				
				//reseting the grid
				resetGrid(grid);
				grid.setDisable(true);
				
				//reseting the toggle switches
				spotsGroup.getToggles().forEach(toggle -> { // Disable spotsGroup
				    RadioButton node = (RadioButton) toggle ;
				    node.setDisable(false);
				});
				
				drawingsGroup.getToggles().forEach(toggle -> { // Disable spotsGroup
				    RadioButton node = (RadioButton) toggle ;
				    node.setDisable(false);
				});
				
				// Setting text field to empty
				roundGameScore.setText("");
				drawNumbers.setText("");
				matchedNumbers.setText("");
			}
		};		
		
		playAgain.setOnAction(playAgainhandler);
		reset.setOnAction(playAgainhandler);
		
		// add an image for the main screen
		Image pic = new Image("StartupImage.png");
		ImageView v = new ImageView(pic);
		v.setPreserveRatio(true);
		v.fitWidthProperty().bind(primaryStage.widthProperty());
		
		startButton = new Button();
		startButton.setOnAction(e->primaryStage.setScene(sceneMap.get("GameScene")));
		startButton.setGraphic(v);
		
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
        dialogRules.setContentText("Instructions for the game: \n"
        		+ "1. Click on play and choose the number of cards you want to choose to have in your bet card. "
        		+ "You can choose 1, 4, 8 or 10 numbers in your bet cards. \n"
        		+ "2. Click on NEXT and choose your numbers from your grid or click on RANDOM to generate random values, "
        		+ "or you can reset your number selection by clicking RESET.\n"
        		+ "3. Click on number of drawings you want, you can choose between 1-4 drawings.\n"
        		+ "4. As each drawing goes through, you will be notified of the numbers you matched and your earnings.");
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
        dialogOdds.setContentText("Odds: \n"
        		+ "2-Spot Game: Overall odds 1 in 16.6\n"
        		+ "4-Spot Game: Overall odds 1 in 3.9\n"
        		+ "8-Spot Game: Overall odds 1 in 9.8\n"
        		+ "10-Spot Game: Overall odds 1 in 9.1\n");
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
		VBox mainScene = new VBox(menu, startButton);
		mainScene.setSpacing(0);
		Scene scene = new Scene(mainScene, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////
	
	// method to create our first scene with controls
	public Scene createControlScene() {
				
		random = new Button();
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
				
		Dialog<String> dialogRules = new Dialog<String>();
        //Setting the title
        dialogRules.setTitle("Rules");
        ButtonType typeRules = new ButtonType("Ok", ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialogRules.setContentText("Instructions for the game: \n"
        		+ "1. Click on play and choose the number of cards you want to choose to have in your bet card. "
        		+ "You can choose 1, 4, 8 or 10 numbers in your bet cards. \n"
        		+ "2. Click on NEXT and choose your numbers from your grid or click on RANDOM to generate random values, "
        		+ "or you can reset your number selection by clicking RESET.\n"
        		+ "3. Click on number of drawings you want, you can choose between 1-4 drawings.\n"
        		+ "4. As each drawing goes through, you will be notified of the numbers you matched and your earnings.");
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
        dialogOdds.setContentText("Odds: \n"
        		+ "2-Spot Game: Overall odds 1 in 16.6\n"
        		+ "4-Spot Game: Overall odds 1 in 3.9\n"
        		+ "8-Spot Game: Overall odds 1 in 9.8\n"
        		+ "10-Spot Game: Overall odds 1 in 9.1\n");
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
		displayQueueItems = new ListView<String>();
		
		myHandler = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				
				random.setDisable(true);
				
				if (numPressed < iterations) {
					String t = ((Button)e.getSource()).getText();
					System.out.println("button pressed: " + ((Button)e.getSource()).getText());
					b1 = (Button)e.getSource();
					b1.setDisable(true);
					myQueue.add(t);
					
					displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
					storeQueueItemsInListView.clear();
					
					for(String a:myQueue) {
						storeQueueItemsInListView.add(a);
					}
					
					displayQueueItems.setItems(storeQueueItemsInListView);
					numPressed++;
				}else {}
			}
		};
		
		grid = new GridPane();
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

        spotsGroup = new ToggleGroup();  
        RadioButton button1 = new RadioButton("1 spot");  
        RadioButton button2 = new RadioButton("4 spots");  
        RadioButton button3 = new RadioButton("8 spots");  
        RadioButton button4 = new RadioButton("10 spots");  
        button1.setToggleGroup(spotsGroup);  
        button2.setToggleGroup(spotsGroup);  
        button3.setToggleGroup(spotsGroup);  
        button4.setToggleGroup(spotsGroup);
        
    /////////////////////////////////////////////////
        submitButton = new Button("Submit Changes!");
        
        submitAction = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				grid.setDisable(false); // Enable the grid
				random.setDisable(false);
				next.setDisable(false);
				reset.setDisable(false);
								
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
			    	myQueue.add(String.valueOf(temp));
			    }
			    
			    displayQueueItems.getItems().removeAll(storeQueueItemsInListView);
				storeQueueItemsInListView.clear();

				for(String j:myQueue) {
					storeQueueItemsInListView.add(j);
				}
				
				displayQueueItems.setItems(storeQueueItemsInListView);
			}
		};
        
        random.setOnAction(randomHandler);
        
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
		
		iLook.setOnAction(e-> main.setStyle("-fx-background-color: lightBlue;"));
		
		main.setStyle("-fx-background-color: lightGrey;");
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
				b1 = new Button(Integer.toString(counter));
				b1.setDisable(false);
				b1.setOnAction(myHandler);
				b1.setMinWidth(45);
				grid.add(b1, x, i);
			}
		}
	}
	
	/*
	 * Method to reset the grid.
	 */
	public void resetGrid(GridPane grid) {
		int counter;
		
		for(int x = 0; x<10; x++) {
			for(int i = 0; i<8; i++) {
				counter  = (10*i) + x + 1;
				b1 = new Button(Integer.toString(counter));
				b1.setDisable(false);
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
        dialogRules.setContentText("Instructions for the game: \n"
        		+ "1. Click on play and choose the number of cards you want to choose to have in your bet card. "
        		+ "You can choose 1, 4, 8 or 10 numbers in your bet cards. \n"
        		+ "2. Click on NEXT and choose your numbers from your grid or click on RANDOM to generate random values, "
        		+ "or you can reset your number selection by clicking RESET.\n"
        		+ "3. Click on number of drawings you want, you can choose between 1-4 drawings.\n"
        		+ "4. As each drawing goes through, you will be notified of the numbers you matched and your earnings.");
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
        dialogOdds.setContentText("Odds: \n"
        		+ "2-Spot Game: Overall odds 1 in 16.6\n"
        		+ "4-Spot Game: Overall odds 1 in 3.9\n"
        		+ "8-Spot Game: Overall odds 1 in 9.8\n"
        		+ "10-Spot Game: Overall odds 1 in 9.1\n");
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
        
	    drawingsGroup = new ToggleGroup();  
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
	    
	    drawingsSubmit = new Button();
	    drawingsHandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				drawingsSubmit.setDisable(true);
				
				drawingsGroup.getToggles().forEach(toggle -> { // Disable spotsGroup
				    RadioButton node = (RadioButton) toggle ;
				    node.setDisable(true);
				});
								
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
			}	
        };
        drawingsSubmit.setText("Submit");
        drawingsSubmit.setOnAction(drawingsHandler);
        
        checkDraws = new Button("Check Draws!");
        
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
                
        roundGameScore = new TextField();
        roundGameScore.setVisible(false);
        roundGameScore.setEditable(false);
        roundGameScore.setMinWidth(300);
        
        TextField totalGameScore = new TextField();
        totalGameScore.setVisible(false);
        totalGameScore.setEditable(false);
        totalGameScore.setMinWidth(300);
        
        HBox pointer = new HBox();
        pointer.getChildren().addAll(roundGameScore,totalGameScore);
        
        
        drawNumbers = new TextField();
        drawNumbers.setEditable(false);
        
        matchedNumbers = new TextField();
        matchedNumbers.setEditable(false);
        matchedNumbers.setVisible(false);
        
        playAgain = new Button("Play Again!");
        playAgain.setVisible(false);
        
        exitButton = new Button("Exit Game");
        exitButton.setVisible(false);
        exitButton.setOnAction(e -> Platform.exit());
        
        Set<Integer>bigSet = new LinkedHashSet<Integer>();

        checker = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				bigSet.add(array[numCounter]);
				temp = temp + String.valueOf(array[numCounter]) + "  ";
				drawNumbers.setText(temp);
				numCounter++;
				
				if(bigSet.size() == 20) {

					matchedNums = matcher(bigSet,myQueue);
			        str = "The matched numbers are: ";
			        matchedNumbers.setVisible(true);
			        
			        if(matchedNums.size() > 0) {
			        	for(String s:matchedNums) {
				        	str = str + s + "  "; 
				        }
				        matchedNumbers.setText(str);
			        }else {
			        	str = "Sorry, No Matches! Try again!";
			        	matchedNumbers.setText(str);
			        }
			        roundScore = scorings(selectedSpot, matchedNums.size());
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
       	
        nextDraw = new Button("Next Draw");
        nextDraw.setDisable(true);
        nextDraw.setVisible(false);
        
        checkDraws.setOnAction(e -> {
        	timeline.play();
        	checkDraws.setDisable(true);
        	if(drawingLoops > 1) {
        		nextDraw.setDisable(false);
            	nextDraw.setVisible(true);
        	}else {
        		playAgain.setVisible(true);
            	exitButton.setVisible(true);
        	}
        });
        
        nextDraw.setOnAction(e -> {
        	timeline.play();
        	drawingLoopsCounter++;
        	if(drawingLoopsCounter == drawingLoops) {
            	nextDraw.setDisable(true);
            	
            	playAgain.setVisible(true);
            	exitButton.setVisible(true);
            }
        });
        
        HBox controls = new HBox();
        controls.getChildren().addAll(playAgain,exitButton);

        
		VBox topDown = new VBox();
		topDown.getChildren().addAll(menu,drawingsText,drawings,drawingsSubmit,checkDraws,drawNumbers,nextDraw,matchedNumbers,pointer,controls);
		topDown.setSpacing(10);
		
		iLook.setOnAction(e-> topDown.setStyle("-fx-background-color: lightGreen;"));
		
		topDown.setStyle("-fx-background-color: lightGrey;");
		return new Scene(topDown, 700,700);
	}

	public ArrayList<String> matcher(Set<Integer> bigSet, Queue<String> myQueue) {
			//String answer = "";
			ArrayList<String> matched = new ArrayList<String>();
			
			for(String y:myQueue) {
				if(bigSet.contains(Integer.parseInt(y))) {
					matched.add(y);
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
