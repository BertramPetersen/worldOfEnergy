import java.util.ArrayList;
import java.util.HashMap;

public class Room implements EnergySourceConstructor {
    int windPot, sunPot, waterPot, geoPot;
    String name;

    ArrayList<EnergySource> builtEnergySource = new ArrayList<>();
    HashMap<String, Room> exits = new HashMap<>();

    public Room(String name, int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
        this.name = name;
    }

    public Room(){
        this.name = "Airport";
    }

    public int getWindPot() {
        return windPot;
    }

    public int getSunPot() {
        return sunPot;
    }

    public int getWaterPot() {
        return waterPot;
    }

    public int getGeoPot() {
        return geoPot;
    }

    public String getName() {
        return name;
    }

    public void setExit(String neighborName, Room neighbor)
    {
        exits.put(neighborName, neighbor);
    }

    public ArrayList<EnergySource> getBuiltEnergySource() {
        return builtEnergySource;
    }

    public void constructWindmill(){
        WindMill windMill = (WindMill) EnergySourceConstructor.constructWind();
        if (ValidateFunds(windMill)){
            builtEnergySource.add(windMill);
        }else{
            System.out.println("Insufficient funds for purchase of WindMill");
        }

    }
    public void constructHydro(){
        HydroPowerplant source = (HydroPowerplant) EnergySourceConstructor.constructHydro();
        if (ValidateFunds(source)){
            builtEnergySource.add(source);
        }else{
            System.out.println("Insufficient funds for purchase of Hydro Power Plant");
        }


    }
    public void constructSolar(){
        SolarPanel source = (SolarPanel) EnergySourceConstructor.constructSolar();
        if (ValidateFunds(source)){
            builtEnergySource.add(source);
        }else{
            System.out.println("Insufficient funds for purchase of Solar Panel");
        }
    }
    public void constructGeoTherm(){
        GeothermalPowerplant source = (GeothermalPowerplant) EnergySourceConstructor.constructGeo();
        if (ValidateFunds(source)){

            builtEnergySource.add(source);
        }else{
            System.out.println("Insufficient funds for purchase of Geothermal Power Plant");
        }
    }

    @Override
    public boolean ValidateFunds(EnergySource e){
        if (Wallet.getCoins() > e.getPrice){
            Wallet.subtractCoins(e.getPrice);
            return true;
        } else{return false;}
    }
}
