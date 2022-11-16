package mainDir.PredictionService;

public interface PredictionService {

    static int getCurrentYear(){
        return Forecast.currentYear;
    }

    static double getCO2(){
        return Forecast.CO2;
    }
    static double getTemperature(){
        return Forecast.temperature;
    }
    static double getSealevel(){
        return Forecast.seaLevel;
    }

    static int getTotalEnergy(){
        return EnergyBalance.totalEnergy;
    }
    static double getGreenEnergy(){
        return EnergyBalance.greenEnergy;
    }
    static void UpdateGreenEnergy(double greenEnergy) {
        EnergyBalance.UpdateGreenEnergy(greenEnergy);
    }
}
