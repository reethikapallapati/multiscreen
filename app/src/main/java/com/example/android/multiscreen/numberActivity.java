package com.example.android.multiscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.media.MediaPlayer;
import static android.R.attr.id;

public class numberActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
       // ArrayList<String> words = new ArrayList<String>();
        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
                words.add(new word("one", "lutti", R.drawable.number_one, R.raw.number_one));
                words.add(new word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
                words.add(new word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
                words.add(new word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
                words.add(new word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
                words.add(new word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
                words.add(new word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
                words.add(new word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.cnumber);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list3);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                {


                    // Release the media player if it currently exists because we are about to
                    // play a different sound file
                    releaseMediaPlayer();

                    // Get the {@link Word} object at the given position the user clicked on
                    word word = words.get(position);

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(numberActivity.this, word.getAudioResId());
                    // Start the audio file
                    mMediaPlayer.start();
                    //for clearing resources
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }           }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
}
