package com.yupog2003.tripdiary;

import android.os.Bundle;

import com.yupog2003.tripdiary.data.MyBackupAgent;
import com.yupog2003.tripdiary.fragments.PreferFragment;

public class PreferActivity extends MyActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferFragment())
                .commit();
    }

    @Override
    public void onPause() {
        MyBackupAgent.requestBackup(this);
        super.onPause();
    }
}
