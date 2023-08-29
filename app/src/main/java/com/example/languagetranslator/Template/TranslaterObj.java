package com.example.languagetranslator.Template;

import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

public class TranslaterObj {

    private FirebaseTranslatorOptions options ;
    private FirebaseTranslator translator;
    private FirebaseModelDownloadConditions conditions;

    public TranslaterObj(int fromLanguageCode, int toLanguageCode){
        options = new FirebaseTranslatorOptions.Builder().setSourceLanguage(fromLanguageCode).setTargetLanguage(toLanguageCode).build();

        translator = FirebaseNaturalLanguage.getInstance().getTranslator(options);

        conditions = new FirebaseModelDownloadConditions.Builder().build();
    }

    public FirebaseTranslatorOptions getOptions() {
        return options;
    }

    public void setOptions(FirebaseTranslatorOptions options) {
        this.options = options;
    }

    public FirebaseTranslator getTranslator() {
        return translator;
    }

    public void setTranslator(FirebaseTranslator translator) {
        this.translator = translator;
    }

    public FirebaseModelDownloadConditions getConditions() {
        return conditions;
    }

    public void setConditions(FirebaseModelDownloadConditions conditions) {
        this.conditions = conditions;
    }
}
