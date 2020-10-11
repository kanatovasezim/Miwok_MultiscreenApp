package com.example.android.miwok;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int backgroundId;

    public <E extends AppCompatActivity> WordAdapter(E activity, ArrayList<Word> words, int backgroundId) {
        super(activity, 0, words);
        this.backgroundId = backgroundId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Word currentWord = getItem(position);
        TextView miwokName = (TextView) listItemView.findViewById(R.id.miwok_name);
        miwokName.setText(currentWord.getmMiwokTranslation());
        TextView actualName = (TextView) listItemView.findViewById(R.id.actual_name);
        actualName.setText(currentWord.getmDefaultTranslation());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), backgroundId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
