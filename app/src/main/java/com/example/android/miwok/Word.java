package com.example.android.miwok;

/**
 * Created by annika on 1/6/2017.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudioResourceId;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //get default translation of a word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //get miwok translation of a word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //get image resource of a word
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // returns whether or not there is an image for this word
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // get audio file
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
