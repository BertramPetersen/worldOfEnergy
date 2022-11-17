package mainDir.PredictionService;

import java.time.Year;

public class Forecast implements PredictionService {

    public double seaLevel = 5; // unit cm e.g. 5 cm
    public double temperature = 2; // unit celsius e.g. 2°C
    public double CO2 = 15; // unit billion ton e.g. 15 billion ton
    int currentYear = Year.now().getValue(); // unit year e.g. 2022

    public int getCurrentYear() {
        return currentYear;
    }
    public double getTemperature() {
        return temperature;
    }
    public double getCO2() {
        return CO2;
    }
    public double getSeaLevel() {
        return seaLevel;
    }

    /**
     * Increases the forecast(Sea level, Temperature, C02), prints what the forecast has increased to.
     * The increaseFactor argument must be between 1 < increaseFactor > ∞ .
     *
     * @param increaseFactor dictates the amount forecast(Sea level, Temperature, C02) is increased e.g. 1.5
     *
     */
    public void increase(double increaseFactor) {

        seaLevel = seaLevel * increaseFactor;
        temperature = temperature * increaseFactor;
        CO2 = CO2 * increaseFactor;

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Current Stats:");
        System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton.");
        System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm.");
        System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103.");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    /**
     * Decreases the forecast(Sea level, Temperature, C02), prints what the forecast has decreased to.
     * The decreaseFactor argument must be between 0 < decreaseFactor < 1.
     *
     * @param decreaseFactor dictates by how much forecast(Sea level, Temperature, C02) is decreased e.g. 0.6
     *
     */
    public void decrease(double decreaseFactor) {
        seaLevel = seaLevel * decreaseFactor;
        temperature = temperature * decreaseFactor;
        CO2 = CO2 * decreaseFactor;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Current Stats:");
        System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton.");
        System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm.");
        System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103.");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    public void update(EnergyBalance energyBalance) {
        currentYear++;
        energyBalance.updatePercentage();
        if (energyBalance.getGreenEnergy() <= energyBalance.getFossilEnergy()) {
            double increase = energyBalance.getFossilPercent(); // unit  %
            double seaLevelIncrease = (0.3*(increase));
            double temperatureIncrease = (0.2*(increase));
            double C02Increase = (0.5*(increase));
            seaLevel *= (1 + seaLevelIncrease/100);
            temperature *=  (1 + temperatureIncrease/100);
            CO2 *= (1 + C02Increase/100);
            System.out.println();
            System.out.println("Oh no! The year is now " + currentYear + " and the world's C02 output is still increasing!");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Current Stats:");
            System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton. Increase per year " + String.format("%.2f",C02Increase) + "%");
            System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm. Increase per year " + String.format("%.2f",seaLevelIncrease) + "%");
            System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103. Increase per year " + String.format("%.2f",temperatureIncrease)+ "%");
            System.out.println("---------------------------------------------------------------------------------------");

        } else {
            double decrease = energyBalance.getGreenPercent(); // unit % eg. 60%
            double seaLevelDecrease = (0.6 *(decrease)); // 0.6 is factor between 0-1
            double temperatureDecrease = (0.4 *(decrease));
            double C02Decrease = (1 * (decrease));

            seaLevel = seaLevel - (seaLevel*(seaLevelDecrease/100));
            temperature = temperature - (temperature*(temperatureDecrease/100));
            CO2 = CO2 - (CO2*(C02Decrease/100));

            System.out.println();
            System.out.println("Good job! The year is now " + currentYear + " and the world's C02 output is finally falling");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Current Stats:");
            System.out.println("The C02 emission has decreased to " + String.format("%.2f",CO2) + ". Decrease per year " + String.format("%.2f",C02Decrease) + "%");
            System.out.println("The sea level has fallen with " + String.format("%.2f",seaLevel) + ". Decrease per year " + String.format("%.2f",seaLevelDecrease) + "%");
            System.out.println("The average temperature has fallen to " + String.format("%.2f",temperature) + ". Decrease per year " + String.format("%.2f",temperatureDecrease) + "%");
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void UpdateGreenEnergy(double greenEnergy) {

    }
    @Override
    public double getGreenEnergy() {
        return 0;
    }

    @Override
    public double getTotalEnergy() {
        return 0;
    }

    @Override
    public double getFossilEnergy() {
        return 0;
    }

    @Override
    public void setTotalEnergy(double totalEnergy) {

    }
}

