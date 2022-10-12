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
        createdRooms.add(southernEurope);
        Room centralEurope = new Room("Central Europe", 40, 40, 55, 40);
        createdRooms.add(centralEurope);
        Room easternEurope = new Room("Eastern Europe", 60, 15, 37, 53);
        createdRooms.add(easternEurope);
        Room scandinavia = new Room("Scandinavia", 90, 20, 40, 60);
        createdRooms.add(scandinavia);
        Room asia = new Room("Asia", 67, 56, 40, 20);
        createdRooms.add(asia);
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
            }else {
                for (Room room1 : createdRooms){
                    if(!room1.getName().equals("Airport")){
                        airport.setExit(room1.getName(), room1);
                    }

                }
            }
        }
    }
    public void updateTurn(){
        turnCounter++;
        Forecast.update();
    }
}
