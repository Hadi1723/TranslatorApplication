package LanguageBridge;

import java.util.List;

public interface ListLanguages {

    public List getFromLanguages();

    public List getToLanguages();

    public String getFromLanguage(int pos);

    public String getToLanguage(int pos);
}
