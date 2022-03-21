package com.harish.usdrivinglicensetest;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import android.preference.Preference;
import android.preference.PreferenceFragment;
public class SettingsFragment extends PreferenceFragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preferences);


        Preference changeState=findPreference(getString(R.string.change_state));
        changeState.setSummary(getPreferences());
        changeState.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                openChangeStateActivity(getActivity());
                return false;
            }
        });
    }

    private void openChangeStateActivity(Activity activity) {
        Intent i = new Intent(activity, StatesActivity.class);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private String getPreferences() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(UserSettings.PREFERENCES,MODE_PRIVATE);
        String state = sharedPreferences.getString(UserSettings.SELECTED_STATE, "None");
        if(!state.equals("None")){
            return state;
        }
        return "";
    }
}
