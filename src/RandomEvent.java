public class RandomEvent {
    String description;
    int impact;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public FutureForecast setFutureForecast (FutureForecast forecast) {
        this.forecast = forecast;
    }

    public void ImpactPlayer(){

    }
}