package com.example.languagetranslator.Template;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.languagetranslator.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class TranslatorImpl extends Translator {

    public TranslatorImpl(){}

    @Override
    protected TranslaterObj formTranslator(int fromLanguageCode, int toLanguageCode) {
        return new TranslaterObj(fromLanguageCode, toLanguageCode);
    }

    @Override
    public void doTranslate(TextView textView, Context context, String src, TranslaterObj translaterObj) {

        translaterObj.getTranslator().downloadModelIfNeeded(translaterObj.getConditions()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                textView.setText("Translating...");
                translaterObj.getTranslator().translate(src).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        textView.setText(s);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Fail to translate: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context, "Fail to download the language: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
