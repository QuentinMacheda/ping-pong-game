package src.controller;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import src.view.SettingsView;

public class SettingsController {
    public SettingsView settingsView;
    private double racketCurrentWidth;
    private double racketCurrentHeight;

    public SettingsController(String type) {
        settingsView = new SettingsView();
        racketCurrentWidth = GameController.getInstance().racketLeftController.getView().racket.getWidth();
        racketCurrentHeight = GameController.getInstance().racketLeftController.getView().racket.getHeight();

        // Display the right setting view
        switch (type) {
            case "endGameScore":
                settingsView.endGameScoreView(GameController.getInstance().getEndGameScore());
                enterKeyPressedSlider(type, settingsView.endGameScoreSlider);
                break;
            case "racketSize":
                settingsView.racketSizeView(racketCurrentWidth, racketCurrentHeight);
                enterKeyPressedSlider(type, settingsView.widthSlider);
                break;
            case "ballSpeed":
                settingsView.ballSpeedView(GameController.getInstance().ballController.getSpeed());
                break;
            case "player1":
                settingsView.playerNameView();
                enterKeyPressedTF(type, settingsView.newPlayerName);
                break;
            case "player2":
                settingsView.playerNameView();
                enterKeyPressedTF(type, settingsView.newPlayerName);
                break;
            default:
                break;
        }

        // Call save() function onclick save button
        settingsView.saveBtn.setOnAction(e -> save(type));
        settingsView.backBtn.setOnAction(e -> back());
    }

    private void save(String type) {
        switch (type) {
            case "endGameScore":
                GameController.getInstance().updateEndGameScore((int) settingsView.endGameScoreSlider.getValue());
                break;
            case "racketSize":
                GameController.getInstance().racketLeftController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                GameController.getInstance().racketRightController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                break;
            case "ballSpeed":
                if (settingsView.optSlow.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeed("slow");
                } else if (settingsView.optFast.isSelected() == true) {
                    GameController.getInstance().ballController.setSpeed("fast");
                } else {
                    GameController.getInstance().ballController.setSpeed("normal");
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

    private void back() {
        MainController.getInstance().hideSettings();
    }

    private void enterKeyPressedTF(String type, TextField textField) {
        // Call save() function if key pressed ENTER
        textField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                save(type);
            }
        });
    }

    private void enterKeyPressedSlider(String type, Slider slider) {
        // Call save() function if key pressed ENTER
        slider.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                save(type);
            }
        });
    }
}
