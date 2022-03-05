package com.harish.usdrivinglicensetest;

import android.app.Application;

public class UserSettings extends Application {
    public static final String PREFERENCES = "preferences";
    public static final String SELECTED_STATE = "selectedState";

    public String getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState = selectedState;
    }

    private String selectedState;
}
