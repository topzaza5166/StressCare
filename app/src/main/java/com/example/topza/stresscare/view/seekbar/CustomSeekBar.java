package com.example.topza.stresscare.view.seekbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.SeekBar;

import java.util.ArrayList;

/**
 * Created by topza on 23/12/2559.
 */
public class CustomSeekBar extends SeekBar{

    private ArrayList<ProgressItem> mProgressItemsList;

    public CustomSeekBar(Context context) {
        super(context);
        initInstances();
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInstances();
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInstances();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomSeekBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInstances();
    }

    public void initData(ArrayList<ProgressItem> progressItemsList) {
        this.mProgressItemsList = progressItemsList;
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        if (mProgressItemsList.size() > 0) {
            int progressBarWidth = getWidth();
            int progressBarHeight = getHeight();
            int thumboffset = getThumbOffset();
            int lastProgressX = 0;
            int progressItemWidth, progressItemRight;
            for (int i = 0; i < mProgressItemsList.size(); i++) {
                ProgressItem progressItem = mProgressItemsList.get(i);
                Paint progressPaint = new Paint();
                progressPaint.setColor(getResources().getColor(
                        progressItem.color));

                progressItemWidth = (int) (progressItem.progressItemPercentage
                        * progressBarWidth / 100);

                progressItemRight = lastProgressX + progressItemWidth;

                // for last item give right to progress item to the width
                if (i == mProgressItemsList.size() - 1
                        && progressItemRight != progressBarWidth) {
                    progressItemRight = progressBarWidth;
                }
                Rect progressRect = new Rect();
                progressRect.set(lastProgressX, thumboffset / 2,
                        progressItemRight, progressBarHeight - thumboffset / 2);
                canvas.drawRect(progressRect, progressPaint);
                lastProgressX = progressItemRight;
            }
            super.onDraw(canvas);
        }
    }

    private void initInstances() {

    }

}
