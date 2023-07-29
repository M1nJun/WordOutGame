package WordGame;
import java.util.*;
import java.io.File;

public class WordGame {
    //member variables
    private boolean isGaming;
    private ArrayList<String> wordList;
    private boolean[] Used;
    
    //Constructor
    public WordGame() throws Exception{
        isGaming = true;
        
        this.wordList = new ArrayList();
        Scanner input = new Scanner(new File("words.txt"));
        while(input.hasNext()){
            String temp = input.next();
            wordList.add(temp);
        }
        
        this.Used = new boolean[26];
        
        //get random word and play 1 round with it
        int randIndex = (int)(Math.round((Math.random() * (wordList.size()-1))));
        String randWord = wordList.get(randIndex);
        System.out.println("The first word is " + randWord);
        //use this because it is an instance of itself
        this.round(randWord);
    }
    
    //check if valid input
    public boolean Allowed(String word){
        char[] temp = word.toCharArray();
        
        //check input has used alphabet
        for(int i=0; i<temp.length; i++){
            if(Used[temp[i] - 'a']){
                return false;
            }
        }
        //check input is less than five char
        if(word.length() != 5){
            return false;
        }
        
        //check if word is in dictionary
        if(!wordList.contains(word)){
            return false;
        }
        
        //update used alphabet
        for(char c:temp){
            Used[c - 'a'] = true;
        }
        
        return true;
        
    }
    
    public boolean round(String word){
        //check if allowed
        if(!Allowed(word)){
            System.out.println("Invalid input or word not in dictionary");
            return false;
        }
        
        char[] temp = word.toCharArray();
        
        
        //remove word from dictionary
        for(int i = wordList.size()-1; i>=0; i--){
            for(char c:temp){
                if(wordList.get(i).indexOf(c) != -1){
                    wordList.remove(i);
                    break;
                }
            }
        }
        
        //check if game ended
        if(wordList.isEmpty()){
            isGaming = false;
            System.out.println("You Win!");
        }
        else{
            System.out.println("There are still " + wordList.size() + " words available.");
            if(wordList.size() < 50){
                    System.out.print("Remaining letters are ");
                for(int i=0; i<Used.length-1; i++){
                    if(!Used[i]){
                        System.out.print((char)(i + 'a'));
                    }
                }
            System.out.println();
            }
        }
        
        return true;
        
        
    }
    
    
    public boolean getIsGaming(){
        return isGaming;
    }
}
