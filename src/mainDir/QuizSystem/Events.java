package mainDir.QuizSystem;

public class Events {
    String description; // description of the random event
    double impact; // The impact value is a factor. An impact value of 1.5 is equal to 50% increase

    /**
     * Constructor that creates events. An event has a description and an impact.
     * @param description a String description of the random event.
     * @param impact a double determining the impact value. An impact value of 1.5 is equal to 50% increase
     */
    public Events (String description, double impact) {
        this.description = description;
        this.impact = impact;
    }

}
