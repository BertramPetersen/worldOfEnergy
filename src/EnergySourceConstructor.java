public interface EnergySourceConstructor {
    static EnergySource constructWind() {
        WindMill windmill = new WindMill();
        return windmill;

    }
    static EnergySource constructHydro() {
        HydroPowerplant hydro = new HydroPowerplant();
        return hydro;
    }
    static EnergySource constructGeo() {
        GeothermalPowerplant geo = new GeothermalPowerplant();
        return geo;
    }

    static EnergySource constructSolar(){
        SolarPanel solarPanel = new SolarPanel();
        return solarPanel;
    }

    boolean ValidateFunds(EnergySource e);
}
