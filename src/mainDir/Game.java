package mainDir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Game {
    int turnCounter;
    private Room location;
    ArrayList<Room> createdRooms;
    HashMap<String, Room> roomMap;
    private CommandWords commands;

    Quiz quiz;

    public Game() {
        this.turnCounter = 0;
        createdRooms = new ArrayList<>();
        this.quiz = new Quiz();
        this.commands = new CommandWordsImplementation();
        Wallet.setCoins(500);
        createRooms();
        this.location = roomMap.get("Airport");
    }

    private void createRooms() {
        roomMap = new HashMap<>();
        Room southernEurope = new Room("Southern Europe", 25, 80, 30, 40);
        createdRooms.add(southernEurope);
        roomMap.put("Southern Europe", southernEurope);
        Room centralEurope = new Room("Central Europe", 40, 40, 55, 40);
        createdRooms.add(centralEurope);
        roomMap.put("Central Europe", centralEurope);
        Room easternEurope = new Room("Eastern Europe", 60, 15, 37, 53);
        createdRooms.add(easternEurope);
        roomMap.put("Eastern Europe", easternEurope);
        Room scandinavia = new Room("Scandinavia", 90, 20, 40, 60);
        createdRooms.add(scandinavia);
        roomMap.put("Scandinavia", scandinavia);
        Room asia = new Room("Asia", 67, 56, 40, 20);
        createdRooms.add(asia);
        roomMap.put("Asia", asia);
        Room southAmerica = new Room("South America", 10, 75, 55, 66);
        createdRooms.add(southAmerica);
        roomMap.put("South America", southAmerica);
        Room centralAmerica = new Room("Central America", 20, 78, 5, 68);
        createdRooms.add(centralAmerica);
        roomMap.put("Central America", centralAmerica);
        Room australia = new Room("Australia", 20, 75, 5, 6);
        createdRooms.add(australia);
        roomMap.put("Australia", australia);
        Room airport = new Room();
        createdRooms.add(airport);
        roomMap.put("Airport", airport);


        for (Room room : createdRooms) {
            if (!room.getName().equals("Airport")){
                room.setExit("Airport", airport);
            }
        }
        for (Room room : createdRooms) {
            if (!room.getName().equals("Airport")) {
                airport.setExit(room.getName(), room);
            }
        }
    }

    public boolean goRoom(Command command) {
        if (!command.hasCommandValue()) {
            // No destination on command.
            // Can't continue with GO_TO command.
            return false;
        }
        String destination = command.getCommandValue();
        Room destinationRoom = this.location.getExit(destination);

        if (destinationRoom == null) {
            System.out.println("Destination Room is equal to null");
            return false;
        } else {
            this.location = destinationRoom;
            return true;
        }
    }
    public CommandWords getCommands(){
        return commands;
    }
    public Command getCommand(String word1, String word2) {
        return new CommandImplementation(commands.getCommand(word1), word2);
    }
    public void getRoomDescription() {
        if(this.location.getName().equals("Airport")){
            System.out.println("You are now at the airport, and can go to any region in World of Energy");
            System.out.println("You can go to any of these destination:");
            for(Room room : createdRooms){
                if(!room.getName().contains("Airport")){
                    System.out.println(room.getName());
                }
            }
        }else{
            location.getLongDescription();
        }
    }
    public List<String> getCommandDescription(){
        System.out.println(this.location.getName());
        return commands.getCommandWords();
    }
    public void updateTurn(){
        turnCounter++;
        Forecast.update();
        EnergyBalance.UpdateGreenEnergy(getTotalPowerOutput());
        System.out.println();
        EnergyBalance.show();
        System.out.println(" \n \n");
        quiz.takeQuiz();
    }

    public double getTotalPowerOutput(){
        double p = 0;
        for (Room room : createdRooms){
            p += room.getRealPowerOutput();
        }
        return p;
    }

    public void promptEnterKey(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void welcome(){
        System.out.println("Welcome to World of Energy\n" +
                "Press \"ENTER\" to continue...");
        promptEnterKey();
        System.out.println("Do you want an introduction to World of Energy?\n" +
                "Y/N");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext("N")){

            System.out.println("A turn-based game where you have to save the world from global warming...");
            promptEnterKey();
            System.out.println("Your job is to build sustainable energy sources in different countries around the world, to prevent global warming from escalating...");
            promptEnterKey();
            System.out.println("You can go to different countries and view their potential for different energy sources and build energy sources...");
            promptEnterKey();
            System.out.println("""
                    There is 4 energy sources each of which have their own “construction” you can build to take advantage of their respective energy potential:
                    Wind = Windmills
                    Solar = Solar panels
                    Water = Hydropower plant
                    Earth = Geothermal power plant""");
            promptEnterKey();
            System.out.println("The more sustainable energy sources you build, the more favorable the energy balance will become...");
            promptEnterKey();
            System.out.println("But what is this so called energy balance?");
            promptEnterKey();
            System.out.println("Throughout the game you'll see an energy balance. If the cumulative amount of fossil energy is greater than the cumulative amount of green energy, then the sea level, temperature and CO2 levels will rise...");
            promptEnterKey();
            System.out.println("But...");
            promptEnterKey();
            System.out.println("If the cumulative amount of green energy is greater than the cumulative amount of fossil energy, then the sea level, temperature and CO2 levels will decrease...");
            promptEnterKey();
            System.out.println("So what is the catch you think?");
            promptEnterKey();
            System.out.println("Energy sources cost money to build!");
            promptEnterKey();
            System.out.println("There are different ways to earn money...");
            promptEnterKey();
            System.out.println("You can energy source to passively earn you money. You can also earn additional money by correctly answering the quiz questions, which will appear after you have finished your turn.");
            promptEnterKey();
        }
    }
    public boolean construct(String type){
        return this.location.constructEnergy(type);
    }
    public boolean quit(Command command) {
        return !command.hasCommandValue();
    }
}
