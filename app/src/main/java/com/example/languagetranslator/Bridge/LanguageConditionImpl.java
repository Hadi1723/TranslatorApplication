package com.example.languagetranslator.Bridge;

import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;

public class LanguageConditionImpl implements LanguageConditions{


    private String language;

    public LanguageConditionImpl(){}


    @Override
    public int getLanguageCode() {

        int LanguageCode = 0;

        switch (language){
            case "English":
                LanguageCode = FirebaseTranslateLanguage.EN;
                break;
            case "Afrikaans":
                LanguageCode = FirebaseTranslateLanguage.AF;
                break;
            case "Arabic":
                LanguageCode = FirebaseTranslateLanguage.AR;
                break;
            case "Belarusian":
                LanguageCode = FirebaseTranslateLanguage.BE;
                break;
            case "Bengali":
                LanguageCode = FirebaseTranslateLanguage.BN;
                break;
            case "Catalan":
                LanguageCode = FirebaseTranslateLanguage.CA;
                break;
            case "Czech":
                LanguageCode = FirebaseTranslateLanguage.CS;
                break;
            case "Welsh":
                LanguageCode = FirebaseTranslateLanguage.CY;
                break;
            case "Hindi":
                LanguageCode = FirebaseTranslateLanguage.HI;
                break;
            case "Urdu":
                LanguageCode = FirebaseTranslateLanguage.UR;
                break;
            default:
                LanguageCode = 0;
        }

        return LanguageCode;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }
}
