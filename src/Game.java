import java.util.ArrayList;

public class Game {
    int turnCounter;
    Room location;
    ArrayList<Room> createdRooms;

    public Game() {
        this.turnCounter = 0;
        createRooms();
    }

    private void createRooms() {
        Room southernEurope = new Room("Southern Europe", 25, 80, 30, 40);
        Room centralEurope = new Room("Central Europe", 40, 40, 55, 40);
        Room easternEurope = new Room("Eastern Europe", 60, 15, 37, 53);
        Room scandinavia = new Room("Scandinavia", 90, 20, 40, 60);
        Room Asia = new Room("Asia", 67, 56, 40, 20);
        Room southAmerica = new Room("South America", 10, 75, 55, 66);
        Room centralAmerica = new Room("Central America", 20, 78, 5, 68);
        Room australia = new Room ("Australia", 20, 75, 5, 6);
        Room airport = new Room("Airport");
    }
}
