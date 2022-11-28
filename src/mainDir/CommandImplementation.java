package mainDir;

public class CommandImplementation implements Command {
    /**
     * A variable of the Enum class {@link Commands} used in the {@link CommandImplementation} constructor.
     */
    private final Commands commandName;
    /**
     * A String variable used in the {@link CommandImplementation} constructor.
     */
    private final String commandValue;

    /**
     * This constructor takes the player's input and equals the first part to {@link #commandName} and the second part to {@link #commandValue}.
     * E.g. if the player types "go to Asia", "go to" is the commandWord and "Asia" is the secondWord.
     * Thereby this constructor enables the player to use the given commands.
     * @param commandWord the command the player types. Has to be one of the Enums in {@link Commands} E.g. "go to", "build", "help" etc.
     * @param secondWord the second command/word the player types. E.g. "Asia", "windmill" etc.
     */
    public CommandImplementation(Commands commandWord, String secondWord) {
        this.commandName = commandWord;
        this.commandValue = secondWord;
    }
    @Override
    public Commands getCommandName(){
        return commandName;
    }
    @Override
    public String getCommandValue() {
        return commandValue;
    }
    @Override
    public boolean isUnknown(){
        return (commandName == Commands.UNKNOWN);
    }
    @Override
    public boolean hasCommandValue(){
        return (commandValue != null);
    }
}
