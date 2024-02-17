package src.view.layout;

import javafx.scene.layout.VBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

import src.controller.GameController;
import src.view.components.PlayerView;

public class TopBarView extends VBox {
    public BorderPane playersContainer;
    public PlayerView playerLeftView;
    public PlayerView playerRightView;
    public MenuBar menuBar;
    public Menu gameSettings;
    public Menu playersName;
    public Menu rackets;
    public MenuItem exit;
    public MenuItem endGameScore;
    public MenuItem racketSize;
    public MenuItem ballSpeed;
    public MenuItem increaseRate;
    public MenuItem player1;
    public MenuItem player2;

    public TopBarView() {
        // Adding players names/scores
        playersContainer = new BorderPane();
        playersContainer.setPadding(new Insets(50));
        playerLeftView = GameController.getInstance().playerLeftController.getView();
        playerRightView = GameController.getInstance().playerRightController.getView();
        playersContainer.setLeft(playerLeftView);
        playersContainer.setRight(playerRightView);

        // Menu
        menuBar = new MenuBar();

        // Items
        gameSettings = new Menu("Game settings");
        playersName = new Menu("Players settings");

        // subItems
        endGameScore = new MenuItem("End game score");
        racketSize = new MenuItem("Rackets size");
        ballSpeed = new MenuItem("Ball speed");
        increaseRate = new MenuItem("Speed increase rate");
        exit = new MenuItem("Exit");
        player1 = new MenuItem(GameController.getInstance().playerLeftController.getName());
        player2 = new MenuItem(GameController.getInstance().playerRightController.getName());

        // Adding to the menu items
        gameSettings.getItems().addAll(endGameScore, racketSize, ballSpeed, increaseRate, exit);
        playersName.getItems().addAll(player1, player2);
        menuBar.getMenus().addAll(gameSettings, playersName);

        // Adding to the top bar
        this.getChildren().add(menuBar);
        this.getChildren().add(playersContainer);
    }
}
