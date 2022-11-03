package mainDir.textUI;

import mainDir.Command;
import mainDir.Game;

import java.util.Scanner;


public class Parser
{
    private Scanner reader;
    private final Game game;

    public Parser(Game game)
    {
        this.game = game;
        this.reader = new Scanner(System.in);
    }

    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();
//        inputLine = inputLine.toLowerCase();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(word1.contains("go")){
                StringBuilder commandWord = new StringBuilder(word1);

                commandWord.append(" ");
                commandWord.append(tokenizer.next());
                word1 = commandWord.toString();

                if(tokenizer.hasNext()){
                    word2 = tokenizer.nextLine().strip();
                }
                return game.getCommand(word1, word2);
            }
            if (word1.contains("build")){
                return buildCommand(word1, tokenizer);
            }
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return game.getCommand(word1,word2);
    }

    private Command buildCommand(String word1, Scanner tokenizer) {
        StringBuilder Word2 = new StringBuilder();
        String word2 = null;
        if(tokenizer.hasNext()){
            Word2.append(tokenizer.nextLine().strip());
            word2 = Word2.toString();
            return game.getCommand(word1, word2);
        }
        return game.getCommand(word1, word2);
    }
}
