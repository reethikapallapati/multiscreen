package com.example.android.multiscreen;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class familyActivity extends AppCompatActivity {
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

        setContentView(R.layout.activity_family);
        final ArrayList<word> words = new ArrayList<word>();
                words.add(new word("father", "әpә", R.drawable.family_father, R.raw.family_father));
                words.add(new word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
                words.add(new word("son", "angsi", R.drawable.family_son, R.raw.family_son));
                words.add(new word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new word("grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words,R.color.cfamily);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list2);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            //the below line is added coz, after onStop method obj. value will cleared
                            releaseMediaPlayer();
                            // Get the {@link Word} object at the given position the user clicked on
            word word = words.get(position);
            // Create and setup the {@link MediaPlayer} for the audio resource associated
            // with the current word
            mMediaPlayer = MediaPlayer.create(familyActivity.this, word.getAudioResId());
            // Start the audio file
            mMediaPlayer.start();
                           /* //for clearing resources
                            //https://github.com/udacity/ud839_Miwok/commit/c2a89bc69a3af9e8aa6d37f1fdaa16e3f6dc4514
                            //i have used code from comment section
                            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    mp.stop();
                                    mp.release();
                                    mMediaPlayer=null;
                                }
                            });*/
                            // Setup a listener on the media player, so that we can stop and release the
                            // media player once the sound has finished playing.
                            mMediaPlayer.setOnCompletionListener(mCompletionListener);
                            }

            });
    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
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
}
