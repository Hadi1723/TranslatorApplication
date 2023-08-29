package com.example.languagetranslator.Bridge;

public class LanguageBridgeImpl implements LanguageBridge{

    private LanguageConditions languageConditions;

    public LanguageBridgeImpl(){
        this.languageConditions = new LanguageConditionImpl();
    }

    @Override
    public int getTranslatedLanguage(String language) {

        languageConditions.setLanguage(language);

        return languageConditions.getLanguageCode();
    }
}
