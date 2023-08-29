package com.example.languagetranslator.Adapter;

import android.content.Intent;

public class SpeakerAdapterImpl implements SpeakerAdapter{

    MicImplementation micImplementation = new MicImplementation();

    public SpeakerAdapterImpl(){}


    @Override
    public Intent getVoice() {
        micImplementation.speaker();
        return micImplementation.getIntent();
    }
}
