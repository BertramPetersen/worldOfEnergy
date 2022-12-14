package mainDir.PredictionService;

import mainDir.util.Colors;

public class EnergyBalance implements PredictionService {
    protected double greenEnergy = 0; // Amount of green energy the player has at the beginning. 0 means the world only has fossil energy at the start
    protected final double totalEnergy = 1125; // Amount of total energy. Determines the difficulty of the game
    protected double fossilEnergy =  totalEnergy - greenEnergy; // Amount of fossil energy. Is determined by the amount of green energy.
    protected double greenPercent; // Amount of green energy in percentage relative to total energy.
    protected double fossilPercent; // Amount of fossil energy in percentage. Is equal to "100 - greenPercent".

    /**
     * Updates the variables {@link #greenEnergy} and {@link #fossilEnergy}. The greenEnergy argument must be a double between 0 and {@link #totalEnergy}
     * <p>
     * This method updates green and fossil energy simultaneously by equaling the parameter greenEnergy to the variable {@link #greenEnergy},
     * and setting {@link #fossilEnergy} equal to {@link #totalEnergy} - {@link #greenEnergy}.
     * </p>
     * @param greenEnergy a double responsible for updating the greenEnergy variable
     * @see #updatePercentage
     */
    public void updateEnergy (double greenEnergy) {
        this.greenEnergy = greenEnergy;
        this.fossilEnergy = totalEnergy - greenEnergy;
    }

    /**
     * Updates the variables {@link #greenPercent} and {@link #fossilPercent}.
     * <p>
     * This method updates {@link #greenPercent} and {@link #fossilPercent} simultaneously by calculating the amount of {@link #greenEnergy} relative to the {@link #totalEnergy} in percentage,
     * and setting {@link #fossilPercent} equal to 100 - {@link #greenPercent}.
     * This method should generally be called after the {@link #updateEnergy} method
     * </p>
     * @see #updateEnergy
     */
    public void updatePercentage() {
        greenPercent = (greenEnergy / totalEnergy) * 100;
        fossilPercent = 100 - greenPercent;
    }

    /**
     * Prints out the energy balance in the form of a bar. The energy balance visualizes the ratio between green and fossil energy.
     * {@link #greenEnergy} and {@link #fossilEnergy} is represented relative to their percentage of the {@link #totalEnergy}.
     * {@link #greenEnergy} is represented by the color green. {@link #fossilEnergy} is represented by the color red.
     * <p>
     *
     * The method converts {@link #greenPercent} and {@link #fossilPercent} to an int then prints out "|" equal to the green and fossil percentage.
     * E.g. if the {@link #greenPercent} and {@link #fossilPercent} is respectively 67.20% and 32,80%, it would print out 67 green "|" and 33 red "|".
     *
     * </p>
     */
    public void show(){
        updatePercentage();
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

    /**
     * @return the amount of {@link #greenEnergy} as a double.
     */
    public double getGreenEnergy() {
        return greenEnergy;
    }

    /**
     * @return the amount of {@link #fossilEnergy} as a double.
     */
    public double getFossilEnergy() {
        return fossilEnergy;
    }

    /**
     * @return the amount of {@link #totalEnergy} as a double.
     */
    public double getTotalEnergy() {
        return totalEnergy;
    }

    /**
     * @return the percentage of {@link #greenEnergy} as a double.
     */
    public double getGreenPercent() {
        return greenPercent;
    }

    /**
     * @return the percentage of {@link #fossilEnergy} as a double.
     */
    public double getFossilPercent() {
        return fossilPercent;
    }

    @Override
    public void update(EnergyBalance energyBalance) {

    }

    @Override
    public int getCurrentYear() {
        return 0;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public double getCO2() {
        return 0;
    }

    @Override
    public double getSeaLevel() {
        return 0;
    }
}



