package com.example.languagetranslator.Adapter;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;

import com.example.languagetranslator.MainActivity;
import com.example.languagetranslator.Tools.Constants;

import java.util.Locale;

public class MicImplementation {

    private Intent intent = null;

    public MicImplementation(){}

    public void speaker(){
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to convert into text");

    }

    public Intent getIntent(){
        return intent;
    }
}
