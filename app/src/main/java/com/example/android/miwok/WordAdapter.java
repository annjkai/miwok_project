package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by annika on 1/6/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //resource ID dor background color
    private int mColorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // method to call the word
        Word currentWord = getItem(position);

        // getting the miwok translation
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        // getting the default (english) translation
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        // getting the icon for the individual words
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_icon);


        // specifies whether a list item has an icon or not
        if (currentWord.hasImage()) {
            // set specified image resource
            imageView.setImageResource(currentWord.getImageResourceId());
            // the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // image view is hidden
            imageView.setVisibility(View.GONE);
        }

        // theme color for list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // find color the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // set background color of text container view
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
