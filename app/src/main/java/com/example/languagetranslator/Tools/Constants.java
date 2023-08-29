package com.example.languagetranslator.Tools;

import LanguageBridge.ListBridge;
import LanguageBridge.ListBridgeImpl;
import LanguageBridge.ListLanguages;

public class Constants {

    private static Constants instance = null;

    private int REQUEST_PERMISSION_CODE = 1;
    private int languageCode, fromLanguageCode, toLanguageCode = 0;

    //private ListBridge listBridge = new ListBridgeImpl();

    private Constants() {


    }

    public static Constants getInstance(){
        synchronized (Constants.class){
            if (instance == null){
                instance = new Constants();
            }

            return instance;
        }
    }

    public int getREQUEST_PERMISSION_CODE() {
        return REQUEST_PERMISSION_CODE;
    }

    public void setREQUEST_PERMISSION_CODE(int REQUEST_PERMISSION_CODE) {
        this.REQUEST_PERMISSION_CODE = REQUEST_PERMISSION_CODE;
    }

    public int getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(int languageCode) {
        this.languageCode = languageCode;
    }

    public int getFromLanguageCode() {
        return fromLanguageCode;
    }

    public void setFromLanguageCode(int fromLanguageCode) {
        this.fromLanguageCode = fromLanguageCode;
    }

    public int getToLanguageCode() {
        return toLanguageCode;
    }

    public void setToLanguageCode(int toLanguageCode) {
        this.toLanguageCode = toLanguageCode;
    }
}
