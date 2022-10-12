import java.util.ArrayList;

public class Room {
    int hej;
    int windPot;
    int sunPot;
    int waterPot;
    int geoPot;
    ArrayList<EnergySource> builtEnergySource = new ArrayList<>();

    public Room(int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
    }

    public void constructWindmill(){
        builtEnergySource = EnergySourceConstructer.construct("Windmill");
    }
}
