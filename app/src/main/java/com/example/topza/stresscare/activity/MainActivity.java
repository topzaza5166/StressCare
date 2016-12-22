package com.example.topza.stresscare.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.topza.stresscare.R;
import com.example.topza.stresscare.event.CloseButtonClick;
import com.example.topza.stresscare.event.ViewCardSelect;
import com.example.topza.stresscare.fragment.BpmCardFragment;
import com.example.topza.stresscare.fragment.MainFragment;
import com.example.topza.stresscare.fragment.MoodCardFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("");
    }

    @Subscribe
    public void OpenViewCard(ViewCardSelect viewCard) {
        switch (viewCard.card) {
            case ViewCardSelect.MoodCard:
                if (getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer) instanceof MainFragment) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contentContainer, MoodCardFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            case ViewCardSelect.BpmCard:
                if (getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer) instanceof MainFragment) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contentContainer, BpmCardFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void CloseViewCard(CloseButtonClick closeButtonClick) {
        if (closeButtonClick.isClick) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);
            if (!(fragment instanceof MainFragment)) {
                getSupportFragmentManager().popBackStack();
            }
        }
    }

}
