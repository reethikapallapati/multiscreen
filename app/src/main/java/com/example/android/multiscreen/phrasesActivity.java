package com.example.android.multiscreen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class phrasesActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);

        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going?", "minto wuksus",
                                R.raw.phrase_where_are_you_going));
              words.add(new word("What is your name?", "tinnә oyaase'nә",
                                R.raw.phrase_what_is_your_name));
               words.add(new word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
               words.add(new word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
               words.add(new word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.cphrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list4);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {



                          // Release the media player if it currently exists because we are about to
                          // play a different sound file
                          releaseMediaPlayer();

                          // Get the {@link Word} object at the given position the user clicked on
                                       word word = words.get(position);

                                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                                                // with the current word
                                                        mMediaPlayer = MediaPlayer.create(phrasesActivity.this, word.getAudioResId());

                                        // Start the audio file
                                                mMediaPlayer.start();

                            }
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
