package com.company;

import java.util.Scanner;

public class Main {

    private static char maxLetter(char[] array) {
        int count = 0;
        int maxCount = 0;
        char maxChar = '0';
        for (int i = 0; i < array.length; i++) {
            if(array[i] != maxChar){
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == array[i]){
                        count +=1;
                    }
                }
                if (count>maxCount){
                    maxCount=count;
                    maxChar= array[i];
                }
                count = 0;
            }
        }
        return maxChar;
    }
    private static void bruteForce(char[] cypherChar) {
        for (int i = 1; i < 27; i++) {
            for (char letter: cypherChar){
                if (letter!=' '){
                    letter = (char) (letter + i);
                    if (letter > 122){
                        letter =(char) (letter - 26);
                    }
                    System.out.print(letter);
                }
            }
            System.out.println(" ");
        }
    }

    private static void popularLetter(char[] cypherChar, int maxChar) {
        char[] popularLetters = {'e','t','a','i','o','n','s','h','r'};
        for (int i = 0; i < popularLetters.length; i++) {
            int shiftChar = (int) popularLetters[i];
            shiftChar = shiftChar- maxChar;
            for (char letter: cypherChar){
                if (letter!=' '){
                    letter = (char) (letter + shiftChar);
                    if (letter > 122){
                        letter = (char) (letter - 26);
                    }
                    if (letter<97){
                        letter = (char) (letter+26);
                    }
                    System.out.print(letter);
                }
            }
            System.out.println(" ");

        }
    }

    public static void main(String[] args) {

	    Scanner input = new Scanner(System.in);
        System.out.println("Input CypherText: ");
        String cypherString = input.next();
        char[] cypherChar = cypherString.toCharArray();
        int maxChar =(int) maxLetter(cypherChar);

        popularLetter(cypherChar, maxChar);
        System.out.println("Has it cracked the code?");
        String answer = input.next();
        if (answer.equalsIgnoreCase("no")){
            bruteForce(cypherChar);
        }

    }




}
