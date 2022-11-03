package mainDir;

public interface EnergySourceConstructor {
    static EnergySource constructWind() {
        return new WindMill();

    }
    static EnergySource constructHydro() {
        return new HydroPowerplant();
    }
    static EnergySource constructGeo() {
        return new GeothermalPowerplant();
    }

    static EnergySource constructSolar(){
        return new SolarPanel();
    }

    boolean ValidateFunds(EnergySource e);
}
