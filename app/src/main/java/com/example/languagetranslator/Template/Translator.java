package com.example.languagetranslator.Template;

import android.content.Context;
import android.widget.TextView;

public abstract class Translator {

    public final void translate(int fromLanguageCode, int toLanguageCode, TextView textView, Context context, String src) {

        TranslaterObj translaterObj = formTranslator(fromLanguageCode, toLanguageCode);

        doTranslate(textView, context, src, translaterObj);

    }

    protected abstract TranslaterObj formTranslator(int fromLanguageCode, int toLanguageCode);

    public abstract void doTranslate(TextView textView, Context context, String src, TranslaterObj translaterObj);
}
