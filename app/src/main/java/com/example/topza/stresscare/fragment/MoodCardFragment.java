package com.example.topza.stresscare.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.topza.stresscare.R;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MoodCardFragment extends Fragment {

    public interface OnClickButton{
        void MoodCloseButton();
    }

    private ImageView xClose;

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
                OnClickButton activity = (OnClickButton) getActivity();
                activity.MoodCloseButton();
            }
        });
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
