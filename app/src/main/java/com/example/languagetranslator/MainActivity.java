package com.example.languagetranslator;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.languagetranslator.Adapter.SpeakerAdapter;
import com.example.languagetranslator.Adapter.SpeakerAdapterImpl;
import com.example.languagetranslator.Bridge.LanguageBridge;
import com.example.languagetranslator.Bridge.LanguageBridgeImpl;
import com.example.languagetranslator.Template.Translator;
import com.example.languagetranslator.Template.TranslatorImpl;
import com.example.languagetranslator.Tools.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import LanguageBridge.ListBridge;
import LanguageBridge.ListBridgeImpl;

public class MainActivity extends AppCompatActivity {

    private SpeakerAdapter speakerAdapter = new SpeakerAdapterImpl();
    private LanguageBridge languageBridge = new LanguageBridgeImpl();
    private Translator translator = new TranslatorImpl();

    private Spinner fromSpinner, toSpinner;
    private TextInputEditText sourceEdt;
    private ImageView micIV;
    private MaterialButton translateBtn;
    private TextView translatedTV;

    private ListBridge listBridge = new ListBridgeImpl();

    private int fromLanguageCode, toLanguageCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = findViewById(R.id.idFromSpinner);
        toSpinner = findViewById(R.id.idToSpinner);
        sourceEdt = findViewById(R.id.idEdtSource);
        micIV = findViewById(R.id.idIVMic);
        translateBtn = findViewById(R.id.idBtnTranslate);
        translatedTV = findViewById(R.id.idTvTranslatedTV);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = getLanguageCode(listBridge.getSpecificLanguageFrom(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {   }
        });

        ArrayAdapter fromAdapter = new ArrayAdapter(this, R.layout.spinner_item, listBridge.getFromLanguages().getFromLanguages());

        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLanguageCode = getLanguageCode(listBridge.getSpecificLanguageTo(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {   }
        });

        ArrayAdapter toAdapter = new ArrayAdapter(this, R.layout.spinner_item, listBridge.getToLanguages().getToLanguages());

        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);

        translateBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                translatedTV.setText("");
                if(sourceEdt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter your text to translate", Toast.LENGTH_SHORT).show();
                }else if(fromLanguageCode == 0){
                    Toast.makeText(MainActivity.this, "Please select source language", Toast.LENGTH_SHORT).show();
                }else if(toLanguageCode == 0){
                    Toast.makeText(MainActivity.this, "Please language to translate", Toast.LENGTH_SHORT).show();
                }else{
                    translateText(fromLanguageCode, toLanguageCode, sourceEdt.getText().toString());
                }

            }
        });

        micIV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = speakerAdapter.getVoice();

                try{
                    startActivityForResult(i, Constants.getInstance().getREQUEST_PERMISSION_CODE());
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.getInstance().getREQUEST_PERMISSION_CODE()){
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                sourceEdt.setText(result.get(0));
            }
        }
    }

    private void translateText(int fromLanguageCode, int toLanguageCode, String src) {
        translatedTV.setText("Downloading Modal...");
        translator.translate(fromLanguageCode, toLanguageCode, translatedTV, MainActivity.this, src);
    }

    private int getLanguageCode(String language) {
        return languageBridge.getTranslatedLanguage(language);
    }

}