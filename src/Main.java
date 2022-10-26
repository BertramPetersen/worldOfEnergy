public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Room s = game.roomMap.get("Scandinavia");
        s.viewPotentials();
        s.constructWind();
        System.out.println("You now have this many coins: " + Wallet.getCoins());
        System.out.println();
        game.updateTurn();
        EnergyBalance.show();
        System.out.println();
        for (int i = 0; i < 7; i++) {
            game.quiz.takeQuiz();
        }
        game.updateTurn();
    }
}