package org.example.service;

import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public void addWord(String word, String translate, String description) {
        Word word1 = new Word();
        word1.setWord(word);
        word1.setTranslate(translate);
        word1.setDescription(description);
        boolean result = wordRepository.addWord(word1);
        if (result) {
            System.out.println("Added word");
        } else {
            System.err.println("Erro added word");
        }
    }

    public void wordList() {
        List<Word> wordList = wordRepository.wordList();
        for (Word word : wordList) {
            if (word.getDescription().length()==0) {
                System.out.println(word.getId() + "." + word.getWord() + " -> " + word.getTranslate());
            } else {
                System.out.println(word.getId() + "." + word.getWord() + " -> " + word.getTranslate() + " -> " + word.getDescription());
            }
        }
    }
    public void searchWord(String word) {
        List<Word> words = wordRepository.wordList();
        for (Word word1 : words) {
            if (word1 != null && word1.getWord().equals(word)) {
                System.out.println(word1.getWord() + " -> " + word1.getTranslate());
            } else if (word1 != null && word1.getTranslate().equals(word)) {
                System.out.println(word1.getTranslate() + " -> " + word1.getWord());
            } else {
                System.out.println("word not found");
            }
        }
    }

    public void deletewordById(int word) {
        boolean result = wordRepository.deletewordById(word);
        if (result) {
            System.out.println("deleted word");
        } else {
            System.err.println("error deleted word");
        }
    }
}
