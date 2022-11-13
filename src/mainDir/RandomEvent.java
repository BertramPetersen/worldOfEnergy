package mainDir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RandomEvent {
    private int i;
    public ArrayList<Events> events = new ArrayList<>();

    public RandomEvent() {
        createEvents();
    }

    public void createEvents() {
        events.add(new Events("!ALERT! The brazilian government just announced an almost complete deforestation of the Amazon Rainforest. " +
                "Now all the forest’s carbon storage capacity will be lost to the atmosphere !ALERT!", 1.5));
    }

    private void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void initiateRandomEvent() {
        double x = Math.random(); // Generates random double between 0-1
        if (x > 0.8) {
            Collections.shuffle(events);
            try {
                System.out.println("Wait...");
                promptEnterKey();
                System.out.println("Something is off...");
                promptEnterKey();
                System.out.println("Something happened as the new turn commenced...");
                promptEnterKey();
                System.out.println(events.get(i).description);
                promptEnterKey();
                System.out.println("This will undoubtedly have consequences on the climate forecast and energy balance...");
                promptEnterKey();
                EnergyBalance.show();
                Forecast.increase(events.get(i).impact);
                promptEnterKey();
                System.out.println("Oh no! The forecast has increased with " + (int) ((events.get(i).impact * 100) - 100) + "%!");
            } catch (IndexOutOfBoundsException e) {
                i = 0;
                Collections.shuffle(events);
                initiateRandomEvent();
            }
            i++;
        }
    }
}

