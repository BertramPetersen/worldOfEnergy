import java.util.ArrayList;

public class EnergySourceConstructer {
    public static EnergySource construct(String type) {
        if (type.equals("Windmill")){
            WindMill windmill = new WindMill();

            return windmill;
        } else if (type.equals("Hydro PowerPlant")) {
            

        }

    }
}
