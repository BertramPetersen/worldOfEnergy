package mainDir;

public enum Difficulty {
    EASY(1000, 1000),
    Medium(2000, 750),
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
