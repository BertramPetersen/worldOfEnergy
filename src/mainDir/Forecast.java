package mainDir;

public class Forecast extends EnergyBalance {

    static double seaLevel = 9.7; //enhed cm
    static double temperature = 14; // enhed celsius
    static double CO2 = 15.3; // enhed billion ton

    static double waterIncrease = 1.04; // enhed  %
    static double temperatureIncrease = 1.08; // enhed %
    static double CO2Increase = 1.10;//enhed %

    static double decrease = 0.1;//enhed %


    public static void increase(double increaseFactor) {

        seaLevel = seaLevel * increaseFactor;
        temperature = temperature * increaseFactor;
        CO2 = CO2 * increaseFactor;

        System.out.printf("the sea level has risen to: %.2f cm. \n", seaLevel);
        System.out.printf("The temperature has risen to: %.2f degrees. \n", temperature);
        System.out.printf("The CO2 emission has risen to: %.2f tonnes. \n", CO2);

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
            seaLevel = seaLevel * waterIncrease;
            temperature = temperature * temperatureIncrease;
            CO2 = CO2 * CO2Increase;
            System.out.printf("the sea level has risen to: %.2f cm \n", seaLevel);
            System.out.println("if you continue with this the sea level will increase with: " + waterIncrease + "% per year");
            System.out.printf("The temperature has risen to: %.2f degrees \n", temperature);
            System.out.println("if you continue with this the temperature wil increase with " + temperatureIncrease + "% per year");
            System.out.printf("The CO2 emission has risen to:  %.2f ton \n", CO2);
            System.out.println("if you continue with this the CO2 wil increase with " + CO2Increase + "% per year");
        } else {
            seaLevel = seaLevel * decrease;
            temperature = temperature * decrease;
            CO2 = CO2 * decrease;

            System.out.printf("the sea level has decreased to:  %.2f cm \n", seaLevel);
            System.out.println("Great job, with your work the water level will decrease with " + decrease + "% per year");
            System.out.printf("the temperature has decreased to: %.2f degrees \n", temperature);
            System.out.printf("Great job, with your work the temperature will decrease with %.2f percent per year \n", (decrease - 1) * 100);
            System.out.printf("the CO2 level has decreased to: %.2f ton \n",  CO2);
            System.out.println("Great job, with your work the CO2 level will decrease with " + decrease + "% per year");


        }
    }
}

