package mainDir;

public enum Difficulty {
    EASY(1000, 700),
    Medium(2000, 600),
    HARD(3000, 500);

    private final double totalEnergy;
    private final int walletAmount;

    Difficulty(double totalEnergy, int walletAmount) {
        this.totalEnergy = totalEnergy;
        this.walletAmount = walletAmount;
    }

    public double getTotalEnergy() {
        return totalEnergy;
    }

    public int getWalletAmount() {
        return walletAmount;
    }
}
