package mainDir;

public class EnergyBalance {
    private static double greenEnergy;
    private final static int totalEnergy = 5000;
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

    public double DisplayGreenEnergy() {
        return greenEnergy;
    }

    public double DisplayFossileEnergy() {
        return fossileEnergy;
    }

    public double DisplayTotalEnergy() {
        return totalEnergy;
    }

    public static void show(){
        System.out.println("Amount of green energy: " + greenEnergy);
        System.out.println("Amount of fossile energy: " + fossileEnergy);;
        double greenPercent = (greenEnergy / totalEnergy) * 100;
        double fosilePercent = 100 - greenPercent;
        System.out.println("The Energy balance (Green/Fossile) is: "+greenPercent+"/"+fosilePercent);

    }
}



