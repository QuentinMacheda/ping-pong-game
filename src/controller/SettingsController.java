package src.controller;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import src.model.GameModel;
import src.view.SettingsView;

public class SettingsController {
    public SettingsView settingsView;
    private double racketCurrentWidth;
    private double racketCurrentHeight;

    public SettingsController(String type) {
        settingsView = new SettingsView();
        racketCurrentWidth = GameController.getInstance().racketLeftController.getView().racket.getWidth();
        racketCurrentHeight = GameController.getInstance().racketLeftController.getView().racket.getHeight();

        /*
         * Display the right setting view
         */
        switch (type) {
            case "endGameScore":
                settingsView.endGameScoreView(GameModel.getInstance().getEndGameScore());
                enterKeyPressedSlider(type, settingsView.endGameScoreSlider);
                break;
            case "racketSize":
                settingsView.racketSizeView(racketCurrentWidth, racketCurrentHeight);
                enterKeyPressedSlider(type, settingsView.widthSlider);
                break;
            case "ballSpeed":
                settingsView.ballSpeedView(GameController.getInstance().ballController.getSpeed());
                break;
            case "ballSpeedIR":
                settingsView.ballSpeedIRView(GameController.getInstance().ballController.getSpeedIR());
                break;
            case "player1":
                settingsView.playerNameView(GameController.getInstance().playerLeftController.getName());
                enterKeyPressedTF(type, settingsView.newPlayerName);
                break;
            case "player2":
                settingsView.playerNameView(GameController.getInstance().playerRightController.getName());
                enterKeyPressedTF(type, settingsView.newPlayerName);
                break;
            default:
                break;
        }

        // Call save() function onclick save button
        settingsView.saveBtn.setOnAction(e -> save(type));
        settingsView.backBtn.setOnAction(e -> back());
    }

    /*
     * Save settings (change the values)
     */
    private void save(String type) {
        switch (type) {
            case "endGameScore":
                GameModel.getInstance().updateEndGameScore((int) settingsView.endGameScoreSlider.getValue());
                break;
            case "racketSize":
                GameController.getInstance().racketLeftController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                GameController.getInstance().racketRightController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                break;
            case "ballSpeed":
                if (settingsView.optSlowBallSpeed.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeed("slow");
                } else if (settingsView.optFastBallSpeed.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeed("fast");
                } else {
                    GameController.getInstance().ballController.setSpeed("normal");
                }
                break;
            case "ballSpeedIR":
                if (settingsView.optSlowBallSpeedIR.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeedIR("slow");
                } else if (settingsView.optFastBallSpeedIR.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeedIR("fast");
                } else {
                    GameController.getInstance().ballController.setSpeedIR("normal");
                }
                break;
            case "player1":
                if (settingsView.newPlayerName.getText().length() > 0) {
                    GameController.getInstance().playerLeftController.updateName(settingsView.newPlayerName.getText());
                }
                break;
            case "player2":
                if (settingsView.newPlayerName.getText().length() > 0) {
                    GameController.getInstance().playerRightController.updateName(settingsView.newPlayerName.getText());
                }
                break;
            default:
                break;
        }

        MainController.getInstance().hideSettings();
    }

    /*
     * Do not save the settings and go back
     */
    private void back() {
        MainController.getInstance().hideSettings();
    }

    /*
     * Call save() function if key pressed ENTER for TextField
     */
    private void enterKeyPressedTF(String type, TextField textField) {
        // Call save() function if key pressed ENTER
        textField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                save(type);
            }
        });
    }

    /*
     * Call save() function if key pressed ENTER for Slider
     */
    private void enterKeyPressedSlider(String type, Slider slider) {
        // Call save() function if key pressed ENTER
        slider.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                save(type);
            }
        });
    }
}
