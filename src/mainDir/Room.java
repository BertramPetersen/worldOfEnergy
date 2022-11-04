package mainDir;

import java.util.ArrayList;
import java.util.HashMap;

public class Room implements EnergySourceConstructor {
    int windPot, sunPot, waterPot, geoPot;
    String name;

    ArrayList<EnergySource> builtEnergySource = new ArrayList<>();
    private HashMap<String, Room> exits = new HashMap<>();

    double realPowerOutput;

    public Room(String name, int windPot, int sunPot, int waterPot, int geoPot) {
        this.windPot = windPot;
        this.sunPot = sunPot;
        this.waterPot = waterPot;
        this.geoPot = geoPot;
        this.name = name;
        this.realPowerOutput = 0;
    }

    public Room() {
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

    public void setExit(String neighborName, Room neighbor) {
        exits.put(neighborName, neighbor);
    }

    public Room getExit(String destination) {
        System.out.println(destination);
        return this.exits.get(destination);
    }

    public ArrayList<EnergySource> getBuiltEnergySource() {
        return builtEnergySource;
    }

    public boolean constructEnergy(String type){
        if (type.contains("Windmill")){
            return constructWind();
        }else if (type.contains("Hydro Powerplant")){
            return constructHydro();
        }else if (type.contains("Solar Panel")){
            return constructSolar();
        }
        else if (type.contains("Geo Powerplant")) {
            return constructGeoTherm();
        }
        return false;
    }
    public boolean constructWind() {
        WindMill windMill = (WindMill) EnergySourceConstructor.constructWind();
        if (ValidateFunds(windMill)) {
            builtEnergySource.add(windMill);
            updateOutput();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of worldOfEnergy.WindMill");
            return false;
        }

    }

    public boolean constructHydro() {
        HydroPowerplant source = (HydroPowerplant) EnergySourceConstructor.constructHydro();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Hydro Power Plant");
            return false;
        }


    }

    public boolean constructSolar() {
        SolarPanel source = (SolarPanel) EnergySourceConstructor.constructSolar();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Solar Panel");
            return false;
        }
    }

    public boolean constructGeoTherm() {
        GeothermalPowerplant source = (GeothermalPowerplant) EnergySourceConstructor.constructGeo();
        if (ValidateFunds(source)) {
            builtEnergySource.add(source);
            updateOutput();
            return true;
        } else {
            System.out.println("Insufficient funds for purchase of Geothermal Power Plant");
            return false;
        }
    }

    @Override
    public boolean ValidateFunds(EnergySource e) {
        if (Wallet.getCoins() > e.getPrice()) {
            Wallet.subtractCoins(e.getPrice());
            return true;
        } else {
            return false;
        }
    }

    public void updateOutput() {
        this.realPowerOutput = 0;
        for (EnergySource source : builtEnergySource) {
            if (source instanceof WindMill) {
                this.realPowerOutput += source.output * this.windPot;
            } else if (source instanceof HydroPowerplant) {
                this.realPowerOutput += source.output * this.waterPot;
            } else if (source instanceof SolarPanel) {
                this.realPowerOutput += source.output * this.sunPot;
            } else if (source instanceof GeothermalPowerplant) {
                this.realPowerOutput += source.output * this.geoPot;
            }
        }
    }

    public double getRealPowerOutput() {
        return this.realPowerOutput;
    }

    public void viewPotentials() {
        System.out.println("The potential for Wind Energy is: " + windPot);
        System.out.println("The potential for Hydro Energy is: " + waterPot);
        System.out.println("The potential for Solar Energy is: " + sunPot);
        System.out.println("The potential for Geothermal Energy is: " + geoPot);
    }

    public void getLongDescription() {
        System.out.println("Welcome to " + this.name);
        System.out.println("This room has potentiel for: ");
        System.out.println("wind potential: " + this.windPot);
        System.out.println("geo potential: " + this.geoPot);
        System.out.println("solar potential: " + this.sunPot);
        System.out.println("water potential: " + this.waterPot);
        System.out.println("This room currently have:");
        System.out.println("This country has the following energy sources:");
        System.out.println("Windmills: "+ getWindmillCount());
        System.out.println("Geoplants: "+getGeoplantCount());
        System.out.println("Solarpanels: "+getSolarPanelCount());
        System.out.println("Waterplants: "+getWaterplantCount());
    }

    public int getWindmillCount() {
        int windMillCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof WindMill) {
                windMillCounter++;
            }
        }
        return windMillCounter;
    }

    public int getGeoplantCount() {
        int GeoplantConter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof GeothermalPowerplant) {
                GeoplantConter++;
            }
        }
        return GeoplantConter;
    }


    public int getSolarPanelCount() {
        int solarPanelCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof SolarPanel) {
                solarPanelCounter++;
            }
        }
        return solarPanelCounter;
    }

    public int getWaterplantCount() {
        int WaterplantCounter = 0;
        for (EnergySource energySource : builtEnergySource) {
            if (energySource instanceof HydroPowerplant) {
                WaterplantCounter++;
            }
        }
        return WaterplantCounter;
    }
}



