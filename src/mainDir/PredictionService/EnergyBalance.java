package mainDir.PredictionService;

import mainDir.util.Colors;

public class EnergyBalance implements PredictionService {
    protected static double greenEnergy;
    protected final static int totalEnergy = 1125;
    protected static int fossileEnergy = (int) (totalEnergy - greenEnergy);
    public static void UpdateGreenEnergy(double greenEnergy) {

        EnergyBalance.greenEnergy = greenEnergy;
        fossileEnergy = (int)(totalEnergy - greenEnergy);
    }

    public static void show(){
        double greenPercent = (greenEnergy / totalEnergy) * 100;
        double fossilPercent = 100 - greenPercent;
        System.out.printf("The Energy balance (Green/Fossil) is: %.2f / %.2f\n", greenPercent, fossilPercent);
        System.out.print("["+ Colors.GREEN);
        for (int i = 0; i <= (int) greenPercent; i++) {
            System.out.print("|");
        }
        for (int i = 0; i < (100 - (int) greenPercent); i++) {
            System.out.print(Colors.RED+"|");
        }
        System.out.print(Colors.RESET+"]\n");
        System.out.println("Press Enter to continue");


    }
}



