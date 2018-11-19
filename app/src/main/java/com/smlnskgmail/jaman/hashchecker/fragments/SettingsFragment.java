package com.smlnskgmail.jaman.hashchecker.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.smlnskgmail.jaman.hashchecker.BuildConfig;
import com.smlnskgmail.jaman.hashchecker.MainActivity;
import com.smlnskgmail.jaman.hashchecker.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @SuppressLint("ResourceType")
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);

        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setHomeAsUpIndicator(ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_back));

        findPreference(getString(R.string.key_version)).setSummary(String.format("%s (%s)", BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(R.string.settings_title);
        actionBar.setDisplayHomeAsUpEnabled(true);
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAdaptiveBackground));
        setDividerHeight(0);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
    }

    public void back() {
        ((MainActivity) getActivity()).showMainFragment(true, R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            back();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
