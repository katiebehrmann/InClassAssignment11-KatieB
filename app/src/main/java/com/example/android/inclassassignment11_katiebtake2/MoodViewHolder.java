package com.example.android.inclassassignment11_katiebtake2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by katie on 4/24/17.
 */

public class MoodViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView moodNameText;
    private TextView moodTenText;
    private TextView moodDiscussedText;
    private Context context;

    public MoodViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        moodNameText = (TextView) itemView.findViewById(R.id.mood_description);
        moodTenText = (TextView) itemView.findViewById(R.id.out_of_ten);
        moodDiscussedText = (TextView) itemView.findViewById(R.id.discussed);
        this.context = itemView.getContext();
    }

    public void bind(final Mood mood) {
        moodNameText.setText("I am " + mood.moodName);
        moodTenText.setText("I feel " + mood.moodOutOfTen + "/10");
        moodDiscussedText.setText("I have discussed this with someone. " + mood.moodDiscussed);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, moodNameText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
