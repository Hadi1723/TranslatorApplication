package LanguageBridge;

public class ListBridgeImpl implements ListBridge {

    private ListLanguages listLanguages;

    public ListBridgeImpl(){
        this.listLanguages = new ListLanguageStringArray();
    }


    @Override
    public ListLanguages getFromLanguages() {
        return listLanguages;
    }

    @Override
    public ListLanguages getToLanguages() {
        return listLanguages;
    }

    @Override
    public String getSpecificLanguageFrom(int pos) {
        return listLanguages.getFromLanguage(pos);
    }

    @Override
    public String getSpecificLanguageTo(int pos) {
        return listLanguages.getToLanguage(pos);
    }
}
