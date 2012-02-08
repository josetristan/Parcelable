package com.jtristan.parcelable;

import android.app.Activity;
import android.os.Bundle;

public class ParcelableActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}