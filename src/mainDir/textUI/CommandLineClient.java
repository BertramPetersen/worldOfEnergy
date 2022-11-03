package mainDir.textUI;

import mainDir.Command;
import mainDir.Commands;
import mainDir.Game;
import mainDir.Wallet;

public class CommandLineClient {
    private Parser parser;
    private Game game;

    public CommandLineClient(){
        this.game = new Game();
        this.parser = new Parser(game);
    }
    public void play(){
        game.welcome();

        boolean finished = false;
        while (!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good Bye.");
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        Commands commandWord = command.getCommandName();

        if (commandWord == Commands.UNKNOWN) {
            System.out.println("I don't recognize this command... :/");
            return false;
        }
        if (commandWord == Commands.HELP) {
            System.out.println("Your commandwords are:");
            printHelp();
            System.out.println("You have: "+Wallet.getCoins()+" Coins");
        } else if (commandWord == Commands.GO_TO){
            if (game.goRoom(command)){
                game.getRoomDescription();
            } else {
                System.out.println("You can't go there. Go to Airport to access all Countries :)");
            }
        } else if (commandWord == Commands.QUIT) {
            if (game.quit(command)) {
                wantToQuit = true;
            }else {
                System.out.println("Quit what?");
            }
        } else if (commandWord == Commands.BUILD) {
            game.construct(command.getCommandValue());
        } else if (commandWord == Commands.END_TURN){
            game.updateTurn();
        }
        return wantToQuit;
    }

    private void printHelp(){
        for (String str : game.getCommandDescription()) {
            System.out.println(str + " ");
        }
    }
    private void sleep(int mili){
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
