package mainDir;

import java.time.Year;

public class Forecast extends EnergyBalance {

    static double seaLevel = 10; // unit cm
    static double temperature = 15; // unit celsius
    static double CO2 = 15; // unit billion ton

    static double decrease = ((EnergyBalance.getGreenEnergy()/EnergyBalance.getTotalEnergy())*100);// unit %

    static int currentYear = Year.now().getValue();
    public static void increase(double increaseFactor) {

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

    public static void decrease(double decrease) {
        seaLevel = seaLevel * decrease;
        temperature = temperature * decrease;
        CO2 = CO2 * decrease;

        System.out.printf("the sea level has decreased to:  %.2f cm.\n", seaLevel);
        System.out.printf("the temperature has decreased to:  %.2f degrees \n", temperature);
        System.out.printf("the CO2 level has decreased to:  %.2f ton \n", CO2);

    }
    public static void update() {
        if (EnergyBalance.getGreenEnergy() <= EnergyBalance.getTotalEnergy()) {
            double waterIncrease = 100-((EnergyBalance.getGreenEnergy()/EnergyBalance.getTotalEnergy())*100); // unit  %
            double temperatureIncrease = 100-((EnergyBalance.getGreenEnergy()/EnergyBalance.getTotalEnergy())*100); // unit %
            double CO2Increase = 100-((EnergyBalance.getGreenEnergy()/EnergyBalance.getTotalEnergy())*100);// unit %

            seaLevel *= (1 + (waterIncrease/100));
            temperature *=  (1 + (temperatureIncrease/100));
            CO2 *= (1 + (CO2Increase/100));
            System.out.println();
            System.out.println("Oh no! The year is now " + currentYear + " and the world's C02 output is still rising!");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Current Stats:");
            System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + " billion ton. Increase per year " + CO2Increase+ "%");
            System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + "cm. Increase per year " + waterIncrease + "%");
            System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + "\u2103. Increase per year " + temperatureIncrease+ "%");
            System.out.println("---------------------------------------------------------------------------------------");

        } else {
            seaLevel *= decrease;
            temperature *= decrease;
            CO2 *= decrease;
            System.out.println();
            System.out.println("Good job! The year is now " + currentYear + " and the world's C02 output is finally falling");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Current Stats:");
            System.out.println("The C02 emission has increased to " + String.format("%.2f",CO2) + ". Decrease per year " + decrease + "%");
            System.out.println("The sea level has risen with " + String.format("%.2f",seaLevel) + ". Decrease per year " + decrease + "%");
            System.out.println("The average temperature has risen to " + String.format("%.2f",temperature) + ". Decrease per year " + decrease + "%");
            System.out.println("---------------------------------------------------------------------------------------");
        }
        currentYear++;
    }
}

