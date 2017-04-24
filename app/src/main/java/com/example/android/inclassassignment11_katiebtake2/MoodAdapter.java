package com.example.android.inclassassignment11_katiebtake2;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by katie on 4/24/17.
 */

public class MoodAdapter extends FirebaseRecyclerAdapter<Mood, MoodViewHolder> {

    public MoodAdapter(Query ref) {
        super(Mood.class, R.layout.card_view, MoodViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(MoodViewHolder viewHolder, Mood mood, int position) {
        viewHolder.bind(mood);
    }
}


