package org.example.controller;

import org.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class WordController {
    @Autowired
    private WordService wordService;

    public void menu() {
        System.out.println("** Menu **");
        System.out.println("1.Add word");
        System.out.println("2.Word list");
        System.out.println("3.Multiple choice");
        System.out.println("4.Spelling");
        System.out.println("5.Searching");
        System.out.println("6.Delete by id");
        System.out.println("0.Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        while (t) {
            menu();
            int action = scanner.nextInt();
            switch (action) {
                case 1: addWord();
                    break;
                case 2: wordList();
                    break;
                case 3:multipleChoice();
                    break;
                case 4:spelling();
                    break;
                case 5: searching();
                    break;
                case 6:deleteWordById();
                    break;
                case 0:t=false;
                    break;
                default:
                    System.err.println("Invalid action");
            }
        }
    }

    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Word: ");
        String word = scanner.nextLine();
        System.out.println("Enter Translate: ");
        String translate = scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        wordService.addWord(word, translate, description);
    }

    public void wordList() {
        wordService.wordList();
    }

    public void searching() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter searching word ->");
        System.out.println("including both");
        String word=scanner.nextLine();

        wordService.searchWord(word);
    }
    public void deleteWordById(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        wordService.deletewordById(id);
    }
    public void multipleChoice(){
        wordService.multipleChoice();
    }
    public void spelling(){
        wordService.spelling();
    }
}