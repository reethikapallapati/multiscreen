package com.example.android.multiscreen;

/**
 * Created by kanny on 01/01/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.id;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudioResId;

    private int mResId = imgid;

    private static final int imgid = -1;

    public  word(String defaultTranslation, String MiwokTranslation, int ResId, int AudioResId){
        mMiwokTranslation= defaultTranslation;
                mDefaultTranslation= MiwokTranslation;
        mResId=ResId;
        mAudioResId=AudioResId;
    }
    public  word(String defaultTranslation, String MiwokTranslation, int AudioResId){
        mMiwokTranslation= defaultTranslation;
        mDefaultTranslation= MiwokTranslation;
        mAudioResId=AudioResId;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }
    public int getmResId(){return mResId;}
    public boolean checkImg(){return mResId != imgid; }
    public int getAudioResId(){return mAudioResId;}

}
