package mainDir;

public class RandomEvent{

    String description;
    int impact; // Impact værdien er en faktor. Fx impact på 1,5 svarer til 50%

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

    public void ImpactPlayer(){
        Forecast.increase(impact);
    }
}
