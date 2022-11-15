package mainDir.textUI;

import mainDir.Command;
import mainDir.Game;
import mainDir.dataService;

import java.util.Scanner;


public class Parser
{
    private Scanner reader;
    private final dataService dataService;

    public Parser(Game game)
    {
        this.dataService = game;
        this.reader = new Scanner(System.in);
    }

    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;
        boolean timer = false;
        float timeStart = System.currentTimeMillis();
        float timeEnd = timeStart + 500;
        System.out.print("> ");
        while ((reader.nextLine()).isEmpty()) {
            timeStart = System.currentTimeMillis();
            if (timeStart > timeEnd){
                boolean response = endTurnPrompt();
                if (response){
                    return dataService.getCommand("end", "turn");
                } else {
                    timeEnd += 15000;
                }
            }
        }
            inputLine = reader.nextLine();
            //        inputLine = inputLine.toLowerCase();

            Scanner tokenizer = new Scanner(inputLine);
            if (tokenizer.hasNext()) {
                word1 = tokenizer.next();
                if (word1.contains("go")) {
                    StringBuilder commandWord = new StringBuilder(word1);

                    commandWord.append(" ");
                    commandWord.append(tokenizer.next());
                    word1 = commandWord.toString();

                    if (tokenizer.hasNext()) {
                        word2 = tokenizer.nextLine().strip();
                    }
                    return dataService.getCommand(word1, word2);
                }
                if (word1.contains("build")) {
                    return buildCommand(word1, tokenizer);
                }
                if (tokenizer.hasNext()) {
                    word2 = tokenizer.next();
                }
            }

            return dataService.getCommand(word1, word2);
        }


    private boolean endTurnPrompt() {
        boolean Confirmation = false;
        System.out.println("Do you want to end your turn to proceed with the game?");
        System.out.println("Y/N");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.next().equalsIgnoreCase("y")) {
            return false;
        } else return true;
    }

    private Command buildCommand(String word1, Scanner tokenizer) {
        StringBuilder Word2 = new StringBuilder();
        String word2 = null;
        if(tokenizer.hasNext()){
            Word2.append(tokenizer.nextLine().strip());
            word2 = Word2.toString();
            return dataService.getCommand(word1, word2);
        }
        return dataService.getCommand(word1, word2);
    }
}
