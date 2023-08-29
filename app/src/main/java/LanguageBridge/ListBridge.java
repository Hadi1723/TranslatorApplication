package LanguageBridge;

public interface ListBridge {

    ListLanguages getFromLanguages();

    ListLanguages getToLanguages();

    String getSpecificLanguageFrom(int pos);

    String getSpecificLanguageTo(int pos);
}
