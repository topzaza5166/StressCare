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
public class BpmCardFragment extends Fragment {

    public interface OnClickButton{
        void BpmCloseButton();
    }

    private ImageView xClose;

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
                OnClickButton activity = (OnClickButton) getActivity();
                activity.BpmCloseButton();
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
