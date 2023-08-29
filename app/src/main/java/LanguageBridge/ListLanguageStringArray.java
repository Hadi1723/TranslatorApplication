package LanguageBridge;

import java.util.Arrays;
import java.util.List;

public class ListLanguageStringArray implements ListLanguages{

    private String[] fromLanguages = {"from","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech", "Welsh", "Hindi", "Urdu"};

    private String[] toLanguages = {"from","English","Afrikaans","Arabic","Belarusian","Bengali","Catalan","Czech", "Welsh", "Hindi", "Urdu"};

    public ListLanguageStringArray(){

    }

    @Override
    public List getFromLanguages() {
        return Arrays.asList(fromLanguages);
    }

    @Override
    public List getToLanguages() {
        return Arrays.asList(toLanguages);
    }

    @Override
    public String getFromLanguage(int pos) {
        return fromLanguages[pos];
    }

    @Override
    public String getToLanguage(int pos) {
        return toLanguages[pos];
    }
}
