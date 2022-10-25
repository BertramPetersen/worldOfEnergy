public class Wallet {
    public int coins=0;

    public void Wallet(int coins){
        this.coins=coins;
    }

    public int getCoins() {
        return coins;
    }

    // Fedt vi har en setter i tilfældet at vi skal bruge det
    public void setCoins(int coins) {
        this.coins = coins;
    }

    //  Der er ikke lavet nogen logic som rent faktisk tilføjer coins.
    //  F.eks: Coins += input;
    //  Logikken som styrer om der er svaret korrekt på et spørgsmål, eller om der blevet bygget en energySource
    //  styres ikke af Wallet, men af de andre klasser.
    public void addCoions(int conis) {
        this.coins= 100;


    }


    public void addCoions(int conis) {
        this.coins= 100;

    }

    /* Her er mit bud på hvordan man skulle lave addCoins metode:
    *
    *   public void addCoins(int amount){
    *      this.Coins += amount;
    * }
    */

}


