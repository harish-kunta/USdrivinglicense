package com.harish.usdrivinglicensetest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import android.preference.PreferenceFragment;
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preferences);
    }
}
