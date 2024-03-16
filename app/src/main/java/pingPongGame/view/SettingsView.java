package pingPongGame.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import pingPongGame.controller.layout.TopBarController;

/**
 * The view responsible for displaying the game settings.
 * 
 * @author Quentin Macheda
 * @version 1.4
 * @since 2024-03-09
 */
public class SettingsView extends BorderPane {
    /** The top bar controller instance. */
    public TopBarController topBarController;

    /** The main container holding various settings. */
    public VBox mainContainer;

    /** The container holding buttons and the buttons */
    public HBox buttonsContainer;
    public Button backBtn, saveBtn;

    /** The slider for end game score */
    public Slider endGameScoreSlider;

    /** The sliders for racket width and height */
    public Slider widthSlider, heightSlider;
    public TextField newPlayerName;

    /** The radio buttons for ballSpeed and ballSpeedIR */
    public RadioButton optSlowBallSpeed, optNormalBallSpeed, optFastBallSpeed;
    public RadioButton optSlowBallSpeedIR, optNormalBallSpeedIR, optFastBallSpeedIR;

    /**
     * Constructs a new instance of SettingsView.
     */
    public SettingsView() {
        /*
         * Top Bar
         */
        topBarController = new TopBarController();
        topBarController.initView();
        this.setTop(topBarController.getView());

        // Main Container
        mainContainer = new VBox();
        mainContainer.setSpacing(20);
        mainContainer.getStyleClass().add("main-settings-container");
        this.setCenter(mainContainer);

        // Back Button
        backBtn = new Button("Back");
        backBtn.getStyleClass().addAll("btn", "red-btn");

        // Save Button
        saveBtn = new Button("Save");
        saveBtn.getStyleClass().addAll("btn", "orange-btn");

        // Buttons Container
        buttonsContainer = new HBox(backBtn, saveBtn);
        buttonsContainer.setSpacing(20);
        buttonsContainer.getStyleClass().add("btn-container");
    }

    /**
     * Displays the end game score settings.
     *
     * @param currentScore The current end game score.
     */
    public void endGameScoreView(double currentScore) {
        // Text End Game Score
        Text titleText = new Text("Select the end game score");
        titleText.getStyleClass().add("setting-title"); // Add CSS

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
        endGameScoreSlider.getStyleClass().add("slider"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, endGameScoreSlider, buttonsContainer);
    }

    /**
     * Displays the racket size settings.
     *
     * @param currentWidth  The current racket width.
     * @param currentHeight The current racket height.
     */
    public void racketSizeView(double currentWidth, double currentHeight) {
        // Text Rackets's Width
        Text textWidth = new Text("Select the rackets's width");
        textWidth.getStyleClass().add("setting-title"); // Add CSS

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
        widthSlider.getStyleClass().add("slider"); // Add CSS

        // Text Rackets's Height
        Text textHeight = new Text("Select the rackets's height");
        textHeight.getStyleClass().add("setting-title"); // Add CSS

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
        heightSlider.getStyleClass().add("slider"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(textWidth, widthSlider, textHeight, heightSlider, buttonsContainer);
    }

    /**
     * Displays the ball speed settings.
     *
     * @param optSelected The currently selected ball speed option.
     */
    public void ballSpeedView(String optSelected) {
        // Text End Game Score
        Text titleText = new Text("Select the ball speed");
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Radio Buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        optSlowBallSpeed = new RadioButton("Slow");
        optNormalBallSpeed = new RadioButton("Normal");
        optFastBallSpeed = new RadioButton("Fast");

        optSlowBallSpeed.setToggleGroup(toggleGroup);
        optNormalBallSpeed.setToggleGroup(toggleGroup);
        optFastBallSpeed.setToggleGroup(toggleGroup);

        // Set the current selected option
        if (optSelected.equals("slow"))
            optSlowBallSpeed.setSelected(true);
        else if (optSelected.equals("fast"))
            optFastBallSpeed.setSelected(true);
        else
            optNormalBallSpeed.setSelected(true);

        HBox optionsContainer = new HBox(new VBox(10, optSlowBallSpeed, optNormalBallSpeed, optFastBallSpeed));
        optionsContainer.setAlignment(Pos.CENTER);

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, optionsContainer, buttonsContainer);
    }

    /**
     * Displays the ball speed increase rate settings.
     *
     * @param optSelected The currently selected ball speed increase rate option.
     */
    public void ballSpeedIRView(String optSelected) {
        // Text End Game Score
        Text titleText = new Text("Select the ball speed increase rate");
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Radio Buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        optSlowBallSpeedIR = new RadioButton("Slow");
        optNormalBallSpeedIR = new RadioButton("Normal");
        optFastBallSpeedIR = new RadioButton("Fast");

        optSlowBallSpeedIR.setToggleGroup(toggleGroup);
        optNormalBallSpeedIR.setToggleGroup(toggleGroup);
        optFastBallSpeedIR.setToggleGroup(toggleGroup);

        // Set the current selected option
        if ("slow".equals(optSelected))
            optSlowBallSpeedIR.setSelected(true);
        else if ("fast".equals(optSelected))
            optFastBallSpeedIR.setSelected(true);
        else
            optNormalBallSpeedIR.setSelected(true);

        HBox optionsContainer = new HBox(new VBox(10, optSlowBallSpeedIR, optNormalBallSpeedIR, optFastBallSpeedIR));
        optionsContainer.setAlignment(Pos.CENTER);

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, optionsContainer, buttonsContainer);
    }

    /**
     * Displays the player name settings.
     *
     * @param currentPlayerName The current player name.
     */
    public void playerNameView(String currentPlayerName) {
        // Text
        Text titleText = new Text("Enter a new name for " + currentPlayerName);
        titleText.getStyleClass().add("setting-title"); // Add CSS

        // Textfield
        newPlayerName = new TextField();
        newPlayerName.setPadding(new Insets(15));
        newPlayerName.getStyleClass().add("text-field"); // Add CSS

        // Add both to a VBox
        mainContainer.getChildren().addAll(titleText, newPlayerName, buttonsContainer);
    }
}
