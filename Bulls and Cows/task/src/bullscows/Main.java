package bullscows;

import bullscows.service.BullCows;

public class Main {
    public static void main(String[] args) {
        BullCows bullCows = new BullCows();
        bullCows.validation();
        bullCows.generateSecretCode();
        bullCows.startGame();
    }
}



