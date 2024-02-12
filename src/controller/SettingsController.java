package src.controller;

import src.view.MainView;
import src.view.SettingsView;

public class SettingsController {
    public MainView mainView;
    public SettingsView settingsView;

    public SettingsController(MainView mainView) {
        settingsView = new SettingsView(mainView);
    }
}
