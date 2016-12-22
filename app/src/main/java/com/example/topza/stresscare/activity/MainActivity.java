package com.example.topza.stresscare.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.topza.stresscare.R;
import com.example.topza.stresscare.fragment.BpmCardFragment;
import com.example.topza.stresscare.fragment.MainFragment;
import com.example.topza.stresscare.fragment.MoodCardFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnclickButtonView,
        BpmCardFragment.OnClickButton,
        MoodCardFragment.OnClickButton {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }

        initInstances();
    }

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
    }


    @Override
    public void OnClinkMoodView() {
        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) instanceof MainFragment) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MoodCardFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void OnClickBpmView() {
        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) instanceof MainFragment) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, BpmCardFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void BpmCloseButton() {
        if (getSupportFragmentManager()
                .findFragmentById(R.id.contentContainer) instanceof BpmCardFragment) {
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void MoodCloseButton() {
        if (getSupportFragmentManager()
                .findFragmentById(R.id.contentContainer) instanceof MoodCardFragment) {
            getSupportFragmentManager().popBackStack();
        }
    }
}
