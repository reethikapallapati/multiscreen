package com.example.android.multiscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import com.example.android.multiscreen.R;
import com.example.android.multiscreen.word;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link word} objects.
 */
public class WordAdapter extends ArrayAdapter<word>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link word}s to be displayed.
     */
    public WordAdapter(Context context, ArrayList<word> words, int colorResId) {
        super(context, 0, words);
        mColorResourceId=colorResId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.img);

       if(currentWord.checkImg())
       {
           defaultImageView.setImageResource(currentWord.getmResId());

           defaultImageView.setVisibility(View.VISIBLE);
       }
        else {
           defaultImageView.setVisibility(View.GONE);
       }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.xmllistid);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}