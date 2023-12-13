package org.example.service;

import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGeneratorFactory;

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
            System.err.println("Error added word");
        }
    }

    public void wordList() {
        List<Word> wordList = wordRepository.wordList();
        for (Word word : wordList) {
            if (word.getDescription().length() == 0) {
                System.out.println(word.getId() + "." + word.getWord() + " -> " + word.getTranslate());
            } else {
                System.out.println(word.getId() + "." + word.getWord() + " -> " + word.getTranslate() + " -> " + word.getDescription());
            }
        }
    }

    public void searchWord(String word) {
        int c = 0;
        List<Word> words = wordRepository.wordList();
        for (Word word1 : words) {
            if (word1 != null && word1.getWord().equals(word)) {
                c++;
                System.out.println(word1.getWord() + " -> " + word1.getTranslate());
            } else if (word1 != null && word1.getTranslate().equals(word)) {
                c++;
                System.out.println(word1.getTranslate() + " -> " + word1.getWord());
            }
        }
        if (c == 0) {
            System.out.println("word not found");
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

    public void multipleChoice() {
    }

    public void spelling(){
        Scanner scanner=new Scanner(System.in);
        Random random = new Random();
        List<Word> words = wordRepository.wordList();
        for (Word word : words) {
            for (int i =0; i < random.nextInt(); i++) {
                System.out.println(word.getTranslate());
                System.out.println("Enter translate");
                String s=scanner.next();
                if (word.getWord().equals(s)){
                    System.out.println("True");
                    return;
                }
            }
        }
    }
}
