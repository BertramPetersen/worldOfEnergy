package mainDir;

import mainDir.util.Colors;

public class EnergyBalance {
    private static double greenEnergy;
    private final static int totalEnergy = 1125;
    private static int fossileEnergy = (int) (totalEnergy - greenEnergy);
    public static void UpdateGreenEnergy(double greenEnergy) {

        EnergyBalance.greenEnergy = greenEnergy;
        fossileEnergy = (int)(totalEnergy - greenEnergy);
    }

    public static double getGreenEnergy(){
        return greenEnergy;
    }
    public static int getTotalEnergy(){
        return totalEnergy;
    }



    public static void show(){
        double greenPercent = (greenEnergy / totalEnergy) * 100;
        double fosilePercent = 100 - greenPercent;
        System.out.printf("The Energy balance (Green/Fossil) is: %.2f / %.2f\n", greenPercent, fosilePercent);
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



