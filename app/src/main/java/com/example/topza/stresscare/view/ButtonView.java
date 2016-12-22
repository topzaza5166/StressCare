package com.example.topza.stresscare.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topza.stresscare.R;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ButtonView extends BaseCustomViewGroup {

    private ImageView imageView;
    private TextView textView;

    private int imageSrc;
    private String buttonText;

    public ButtonView(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public ButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initWithAttrs(attrs, 0, 0);
        initInstances();
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initWithAttrs(attrs, defStyleAttr, 0);
        initInstances();
    }

    @TargetApi(21)
    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.view_button, this);
    }

    private void initInstances() {
        // findViewById here
        imageView = (ImageView) findViewById(R.id.icon_button);
        if (imageSrc != 0)
            imageView.setImageResource(imageSrc);

        textView = (TextView) findViewById(R.id.icon_text);
        textView.setText(buttonText);

    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ButtonView,
                defStyleAttr, defStyleRes);

        try {
            imageSrc = a.getResourceId(R.styleable.ButtonView_ButtonIcon, 0);
            buttonText = a.getString(R.styleable.ButtonView_ButtonText);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

}
