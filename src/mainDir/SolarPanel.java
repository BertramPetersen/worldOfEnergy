package mainDir;

public class SolarPanel extends EnergySource {
    public SolarPanel() {
        super.price = 50;
        super.output = 0.2;
        super.type = "Solar";
    }
}