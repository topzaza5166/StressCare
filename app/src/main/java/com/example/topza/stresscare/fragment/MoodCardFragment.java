package com.example.topza.stresscare.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.topza.stresscare.R;
import com.example.topza.stresscare.event.CloseButtonClick;
import com.example.topza.stresscare.view.seekbar.CustomSeekBar;
import com.example.topza.stresscare.view.seekbar.ProgressItem;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MoodCardFragment extends Fragment {

    private ImageView xClose;
    private GraphView graphView;
    private CustomSeekBar seekbar;
    private ArrayList<ProgressItem> progressItemList;
    private ProgressItem mProgressItem;

    private float totalSpan = 300;
    private float redSpan = 100;
    private float greenSpan = 100;
    private float yellowSpan = 100;


    public MoodCardFragment() {
        super();
    }

    public static MoodCardFragment newInstance() {
        MoodCardFragment fragment = new MoodCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mood_card, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        xClose = (ImageView) rootView.findViewById(R.id.x_close_button);
        xClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new CloseButtonClick());
            }
        });

        graphView = (GraphView) rootView.findViewById(R.id.graphView);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setColor(Color.WHITE);
        graphView.addSeries(series);
        graphView.getViewport().setScrollable(true);
        graphView.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        graphView.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graphView.getGridLabelRenderer().setGridColor(Color.WHITE);

        seekbar = ((CustomSeekBar) rootView.findViewById(R.id.seekBar0));
        initDataToSeekbar();
    }

    private void initDataToSeekbar() {
        progressItemList = new ArrayList<ProgressItem>();

        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = ((greenSpan / totalSpan) * 100);
        mProgressItem.color = Color.GREEN;
        progressItemList.add(mProgressItem);

        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (yellowSpan / totalSpan) * 100;
        mProgressItem.color = Color.YELLOW;
        progressItemList.add(mProgressItem);

        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = (redSpan / totalSpan) * 100;
        mProgressItem.color = Color.RED;
        progressItemList.add(mProgressItem);

        seekbar.initData(progressItemList);
        seekbar.invalidate();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
