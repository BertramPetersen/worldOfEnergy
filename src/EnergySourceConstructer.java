import java.util.ArrayList;

public class EnergySourceConstructer {
    public static ArrayList<EnergySource> construct(String type) {
        if (type.equals("Windmill")){
            WindMill windmill = new WindMill();

            return windmill;
        }
    }
}
