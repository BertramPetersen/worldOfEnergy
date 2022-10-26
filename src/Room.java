import java.util.ArrayList;
import java.util.HashMap;

public class Room implements EnergySourceConstructor {
    int windPot, sunPot, waterPot, geoPot;
    String name;

    ArrayList<EnergySource> builtEnergySource = new ArrayList<>();
    HashMap<String, Room> exits = new HashMap<>();

    double realPowerOutput;

    public Room(String name, int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
        this.name = name;
        this.realPowerOutput = 0;
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


    public void constructWind(){
        WindMill windMill = (WindMill) EnergySourceConstructor.constructWind();
        if (ValidateFunds(windMill)){
            builtEnergySource.add(windMill);
            updateOutput();
        }else{
            System.out.println("Insufficient funds for purchase of WindMill");
        }

    }
    public void constructHydro(){
        HydroPowerplant source = (HydroPowerplant) EnergySourceConstructor.constructHydro();
        if (ValidateFunds(source)){
            builtEnergySource.add(source);
            updateOutput();
        }else{
            System.out.println("Insufficient funds for purchase of Hydro Power Plant");
        }


    }
    public void constructSolar(){
        SolarPanel source = (SolarPanel) EnergySourceConstructor.constructSolar();
        if (ValidateFunds(source)){
            builtEnergySource.add(source);
            updateOutput();
        }else{
            System.out.println("Insufficient funds for purchase of Solar Panel");
        }
    }
    public void constructGeoTherm(){
        GeothermalPowerplant source = (GeothermalPowerplant) EnergySourceConstructor.constructGeo();
        if (ValidateFunds(source)){
            builtEnergySource.add(source);
            updateOutput();
        }else{
            System.out.println("Insufficient funds for purchase of Geothermal Power Plant");
        }
    }

    @Override
    public boolean ValidateFunds(EnergySource e){
        if (Wallet.getCoins() > e.getPrice()){
            Wallet.subtractCoins(e.getPrice());
            return true;
        } else{return false;}
    }
    public void updateOutput(){
        this.realPowerOutput = 0;
        for(EnergySource source : builtEnergySource){
            if (source instanceof WindMill){
                this.realPowerOutput += source.output * this.windPot;
            }else if (source instanceof HydroPowerplant){
                this.realPowerOutput += source.output * this.waterPot;
            } else if (source instanceof SolarPanel) {
                this.realPowerOutput += source.output * this.sunPot;
            } else if (source instanceof GeothermalPowerplant) {
                this.realPowerOutput += source.output * this.geoPot;
            }
        }
    }

    public double getRealPowerOutput(){ return this.realPowerOutput; }

    public void viewPotentials(){
        System.out.println("The potential for Wind Energy is: "+windPot);
        System.out.println("The potential for Hydro Energy is: "+waterPot);
        System.out.println("The potential for Solar Energy is: "+sunPot);
        System.out.println("The potential for Geothermal Energy is: "+geoPot);
    }
}
