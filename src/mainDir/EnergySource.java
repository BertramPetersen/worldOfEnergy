package mainDir;

public abstract class EnergySource {
    int price;
    double output;
    String name;


    public int getPrice(){
        return this.price;
    }

    public String getName() {
        return name;
    }
    //    abstract void upgradeOutput();
}

