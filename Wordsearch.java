/*
 U A I F L Q B I D R T V D S S
D R H N N N K W R N E A P H F
 U J Y M B O A X U S L O G J N
 N U X D L Z E P C A P X V V I
 B O D S J O T X S C L I X R D
 C A C L Y Y S I O T A N U E B
 K H X N M P P R E S L U E T C
 E K O I K I N T F S T T B S S
 S G D C V C D I U B X Z H B I
 H O N F O Z Y P F K S W J O W
 Z E O W V L E A R H R E R L R
 Q W X A T R A O Z M S J E U N
 Z C N Y M V N T O Z U I F L L
 N T W A Y A S Q E L I D F Q X
 X H N T K S O H J W O P J Z X

FIND THE FOLLOWING WORDS:
FISH        LOBSTER    PIZZA       CHOCOLATE
STEAK       SALAD      POPCORN     THOR
LOKI        ZOD        SUPERMAN

features of the program:

1. generate an N by M puzzle
    (A puzzle includes a list of words, and a grid of letters with those words hidden.)
2. add a bunch of words randomly
3. show the puzzle , or the solution. (have a puzzle have a unique ID so you can recall it later)
4. Use a plain text file as a list of words to add to the puzzle.
           This means we can swap the theme of the puzzle with different files.
5. Be able to reproduce the same puzzle/solution at a later date. This is a VERY useful feature.


data structure: 2-D characters dataay
what functions should this class contain??
1. ranodm letter generator
2. addWordVertical, addWordHorizontal, addWordDiagonal

javac Wordsearch

 possible inputs
java WordSearch rows cols filename
java WordSearch rows cols filename randomSeed
java WordSearch rows cols filename randomSeed answers


java WordSearch 4 4 words.txt
OR
java WordSearch 4 4 words.txt 103
|X Y F B|
|I A I F|
|D E S A|
|M E H R|
Words: FAD, FISH, MEH (seed: 103)

java WordSearch 4 4 words.txt 103 key
|    F  |
|  A I  |
|D   S  |
|M E H  |
Words: FAD, FISH, MEH (seed: 103)


*/

import java.io.*;
import java.util.*;
public class Wordsearch{
    private char[][] data;
    public static Random rng = new Random();

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *param row is the starting height of the WordSearch
     *param col is the starting width of the WordSearch
     */
    public Wordsearch(int rows, int cols){
            data = new char[rows][cols];
            for(int i = 0; i < rows; i ++){
                    for(int j = 0; j < cols; j ++){
                            data[i][j] = '_';
                    }
            }
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
            for(int i = 0; i < data.length; i ++){
                    for(int j = 0; j < data[0].length; j ++){
                            data[i][j] = '_';
                    }
            }
    }

    /**Each row is a new line, there is a space between each letter
     *return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
            String result = "";
            for(int i = 0; i < data.length; i ++){
                    for(int j = 0; j < data[0].length; j ++){
                            result += (data[i][j] + " ");
                    }
                    result += "\n";
            }
            return result;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *param word is any text to be added to the word grid.
     *param row is the vertical locaiton of where you want the word to start.
     *param col is the horizontal location of where you want the word to start.
     *return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWord(String word, int row, int col){
            char[] wordArr = word.toCharArray();
            int x = rng.nextInt() % 2;
            int y = rng.nextInt() % 2;
            if(x == 0 && y == 0){

            }
            int tCol = col;
            int tRow = row;
            try{
                for(int i = 0; i < wordArr.length; i ++){
                        if(data[tRow - 1][tCol - 1] == '_' || data[tRow - 1][tCol - 1] == wordArr[i]){
                                tCol += x;
                                tRow += y;
                        }
                        else{
                                return false;
                        }
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                    return false;
            }
            tCol = col;
            tRow = row;
            for(int i = 0; i < wordArr.length; i ++){
                    data[tRow - 1][tCol - 1] = wordArr[i];
                    tCol += x;
                    tRow += y;
            }
            return true;
    }
    
    //Driver
    public static void main(String[] args) {
            Wordsearch test = new Wordsearch(5,5);
            test.addWord("bob", 3,4);
            System.out.println(test);
            //System.out.println(args[2]);
    }
}
