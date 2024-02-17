package src.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import src.controller.layout.TopBarController;

public class SettingsView extends BorderPane {
    public Button saveBtn;
    public Slider endGameScoreSlider, widthSlider, heightSlider;
    public TextField newPlayerName;

    public SettingsView() {
        // Set Top Bar
        this.setTop(TopBarController.getInstance().getView());

        // Save Button
        saveBtn = new Button("Save");
        saveBtn.setPadding(new Insets(15));
        saveBtn.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        saveBtn.setTextFill(Color.web("#1B1B1E"));
        saveBtn.setStyle("-fx-background-color: #FF910A");
    }

    /*
     * Display settings with endGameScoreView
     */
    public void endGameScoreView(double currentScore) {
        // Text End Game Score
        Text textEndGameScore = new Text("Select the end game score");
        textEndGameScore.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        textEndGameScore.setFill(Color.web("#F1E9DA"));

        // End Game Score Slider
        endGameScoreSlider = new Slider(5, 20, currentScore);
        endGameScoreSlider.setMajorTickUnit(5);
        endGameScoreSlider.setMinorTickCount(1);
        endGameScoreSlider.setSnapToTicks(true);
        endGameScoreSlider.setShowTickLabels(true);
        endGameScoreSlider.setShowTickMarks(true);
        endGameScoreSlider.setBlockIncrement(5);
        endGameScoreSlider.setPrefWidth(300);
        endGameScoreSlider.setMaxWidth(300);

        // Add both to a VBox
        VBox container = new VBox(textEndGameScore, endGameScoreSlider, saveBtn);
        container.setSpacing(20);
        container.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        this.setCenter(container);
    }

    /*
     * Display settings with racketSizeView
     */
    public void racketSizeView(double currentWidth, double currentHeight) {
        // Text Rackets's Width
        Text textWidth = new Text("Select the rackets's width");
        textWidth.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        textWidth.setFill(Color.web("#F1E9DA"));

        // Width Slider
        widthSlider = new Slider(10, 30, currentWidth);
        widthSlider.setMajorTickUnit(10);
        widthSlider.setMinorTickCount(1);
        widthSlider.setSnapToTicks(true);
        widthSlider.setShowTickLabels(true);
        widthSlider.setShowTickMarks(true);
        widthSlider.setBlockIncrement(5);
        widthSlider.setPrefWidth(300);
        widthSlider.setMaxWidth(300);

        // Text Rackets's Height
        Text textHeight = new Text("Select the the rackets's height");
        textHeight.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        textHeight.setFill(Color.web("#F1E9DA"));

        // Height Slider
        heightSlider = new Slider(100, 140, currentHeight);
        heightSlider.setMajorTickUnit(10);
        heightSlider.setMinorTickCount(1);
        heightSlider.setSnapToTicks(true);
        heightSlider.setShowTickLabels(true);
        heightSlider.setShowTickMarks(true);
        heightSlider.setBlockIncrement(5);
        heightSlider.setPrefWidth(300);
        heightSlider.setMaxWidth(300);

        // Add both to a VBox
        VBox container = new VBox(textWidth, widthSlider, textHeight, heightSlider, saveBtn);
        container.setSpacing(20);
        container.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        this.setCenter(container);
    }

    /*
     * Display settings with playerNameView
     */
    public void playerNameView() {
        // Text
        Text text = new Text("Enter a new name");
        text.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        text.setFill(Color.web("#F1E9DA"));

        // Textfield
        newPlayerName = new TextField();
        newPlayerName.setPadding(new Insets(15));
        newPlayerName.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: #F1E9DA; -fx-border-color: #FF910A; -fx-border-width: 2px; -fx-border-radius: 5px;");
        newPlayerName.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        newPlayerName.setPrefWidth(250);
        newPlayerName.setMaxWidth(250);

        // Add both to a VBox
        VBox container = new VBox(text, newPlayerName, saveBtn);
        container.setSpacing(20);
        container.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        this.setCenter(container);
    }
}
