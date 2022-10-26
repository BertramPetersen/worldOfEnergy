import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    int turnCounter;
    Room location;
    ArrayList<Room> createdRooms;
    HashMap<String, Room> roomMap;

    Quiz quiz;

    public Game() {
        this.turnCounter = 0;
        createdRooms = new ArrayList<>();
        createRooms();
        Wallet.setCoins(500);
        this.quiz = new Quiz();
        location = roomMap.get("Airport");
        welcome();
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
        Room centralAmerica = new Room("Central America", 20, 78, 5, 68);
        createdRooms.add(centralAmerica);
        Room australia = new Room ("Australia", 20, 75, 5, 6);
        createdRooms.add(australia);
        Room airport = new Room();
        createdRooms.add(airport);

        for (Room room : createdRooms) {
            if (!room.getName().equals("Airport")){
                room.setExit("Airport", airport);
            }
        }
        for (Room room : createdRooms){
            if(!room.getName().equals("Airport")){
                airport.setExit(room.getName(), room);
            }
        }
    }
    public void updateTurn(){
        turnCounter++;
        Forecast.update();
        EnergyBalance.UpdateGreenEnergy(getTotalPowerOutput());
        quiz.takeQuiz();
    }

    public double getTotalPowerOutput(){
        double p = 0;
        for (Room room : createdRooms){
            p += room.getRealPowerOutput();
        }
        return p;
    }

    public void welcome(){
        System.out.println("Welcome to World of Energy");
        System.out.println();
        System.out.println("Your job is to build sustainable energy sources \n" +
                "in different countries around the world, to prevent global warming from escalating.");
        System.out.println();
        System.out.println("""
                You can go to different countries and view their potential for different energy sources,
                and build energy sources. Beware that energy sources cost money to build.\s
                To earn money, you have to answer questions throughout the game correctly.\s
                The more sustainable energy sources you build, the more the energy balance turns in your favour.""");
        System.out.println();
        System.out.println();
    }

}
