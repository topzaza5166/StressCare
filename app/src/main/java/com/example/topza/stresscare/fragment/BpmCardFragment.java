package com.example.topza.stresscare.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.topza.stresscare.R;
import com.example.topza.stresscare.event.CloseButtonClick;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class BpmCardFragment extends Fragment {

    private ImageView xClose;
    private GraphView graphView;

    public BpmCardFragment() {
        super();
    }

    public static BpmCardFragment newInstance() {
        BpmCardFragment fragment = new BpmCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bpm_card, container, false);
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
        graphView.getViewport().setScalable(true);
        graphView.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        graphView.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graphView.getGridLabelRenderer().setGridColor(Color.WHITE);

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
