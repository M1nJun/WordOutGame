package WordGame;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args){
        
        WordGame game = null;

        try{
            game = new WordGame();
        }
        catch(Exception ex){
            System.out.println("Could not initialize game.");
            System.exit(1);
        }

        int roundCount = 1;
        
        Scanner sc = new Scanner(System.in);
        
        while(game.getIsGaming()){
            System.out.print("Enter the next word : ");
            String word = sc.next();
            
            boolean result = game.round(word);
            if(result){
                roundCount++;
            }
        }
        
        System.out.println("Game over after " + roundCount + "rounds.");
    }
    
}
