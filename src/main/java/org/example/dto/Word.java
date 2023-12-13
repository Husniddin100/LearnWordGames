package org.example.dto;

public class Word {
    private int id;
    private String word;
    private String translate;
    private String description;

    public Word(String word, String translate, String description ,int id) {
        this.word = word;
        this.translate = translate;
        this.description = description;
        this.id=id;
    }

    public Word() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", translate='" + translate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
