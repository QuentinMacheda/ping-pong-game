package src.view.layout;

import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import src.controller.GameController;
import src.controller.MainController;
import src.view.components.PlayerView;

public class TopBarView extends VBox {
    public MenuBar menuBar;
    public Menu gameSettings;
    public Menu playersName;
    public Menu rackets;
    public MenuItem exit;
    public MenuItem endGameScore;
    public MenuItem racketSize;
    public MenuItem ballSpeed;
    public MenuItem ballSpeedIncreaseRate;
    public MenuItem player1;
    public MenuItem player2;

    public BorderPane playersContainer;
    public PlayerView playerLeftView;
    public PlayerView playerRightView;

    public TopBarView() {
        /*
         * Menu Bar
         */

        // Menu
        menuBar = new MenuBar();

        // Items
        gameSettings = new Menu("Game settings");
        playersName = new Menu("Players settings");

        // subItems
        endGameScore = new MenuItem("End game score");
        racketSize = new MenuItem("Rackets size");
        ballSpeed = new MenuItem("Ball speed");
        ballSpeedIncreaseRate = new MenuItem("Speed increase rate");
        exit = new MenuItem("Exit");
        player1 = new MenuItem(GameController.getInstance().playerLeftController.getName());
        player2 = new MenuItem(GameController.getInstance().playerRightController.getName());

        // Adding to the menu items
        gameSettings.getItems().addAll(endGameScore, racketSize, ballSpeed, ballSpeedIncreaseRate, exit);
        playersName.getItems().addAll(player1, player2);
        menuBar.getMenus().addAll(gameSettings, playersName);

        /*
         * Main container
         */
        this.getChildren().add(menuBar);

        /*
         * Handle buttons actions
         */
        handleButtonsActions();
    }

    public void handleButtonsActions() {
        // Set End Game Score
        this.endGameScore.setOnAction(e -> {
            MainController.getInstance().displaySettings("endGameScore");
        });

        // Set Racket Size
        this.racketSize.setOnAction(e -> {
            MainController.getInstance().displaySettings("racketSize");
        });

        // Set Ball Speed
        this.ballSpeed.setOnAction(e -> {
            MainController.getInstance().displaySettings("ballSpeed");
        });

        // Set Ball Speed Increase Rate
        this.ballSpeedIncreaseRate.setOnAction(e -> {
            MainController.getInstance().displaySettings("ballSpeedIR");
        });

        // Exit Game
        this.exit.setOnAction(e -> System.exit(0));

        // Change Players Name
        this.player1.setOnAction(e -> {
            MainController.getInstance().displaySettings("player1");
        });
        this.player2.setOnAction(e -> {
            MainController.getInstance().displaySettings("player2");
        });
    }
}
