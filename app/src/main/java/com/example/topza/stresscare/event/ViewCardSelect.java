package com.example.topza.stresscare.event;

/**
 * Created by topza on 22/12/2559.
 */
public class ViewCardSelect {

    public static final int MoodCard = 1;
    public static final int BpmCard = 2;

    public final int card;

    public ViewCardSelect(int card) {
        this.card = card;
    }
}
