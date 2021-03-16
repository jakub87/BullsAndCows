package bullscows.service;

import bullscows.repo.gameRepository;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BullCows implements gameRepository {
    private String secretCodeLength;
    private String rangePossibleCharacters;
    private String possibleCharacters;
    private StringBuilder secretCode;
    private Scanner scanner;

    public BullCows() {
        possibleCharacters = "0123456789abcdefghijklmnopqrstuvwxyz";
        scanner = new Scanner(System.in);
        secretCode = new StringBuilder();
    }

    @Override
    public void validation() {
        System.out.println("Input the length of the secret code:");
        secretCodeLength = scanner.nextLine();
        boolean secretCodeLengthValidation = Pattern.matches("^[0-9]{1,2}$", secretCodeLength);
        if (!secretCodeLengthValidation) {
            System.out.println("Error: \"" + secretCodeLength + "\" isn't a valid number.");
            System.exit(0);
        } else if (Integer.parseInt(secretCodeLength) > 36 || Integer.parseInt(secretCodeLength) == 0){
            System.out.println("Error: The length of the secret code must be in 1-36.");
            System.exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        rangePossibleCharacters = scanner.nextLine();
        boolean rangePossibleCharactersValidation = Pattern.matches("^[0-9]{1,2}$", rangePossibleCharacters);
        if (!rangePossibleCharactersValidation) {
            System.out.println("Error: \"" + rangePossibleCharacters + "\" isn't a valid number.");
            System.exit(0);
        } else if (Integer.parseInt(rangePossibleCharacters ) > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }  else if (Integer.parseInt(secretCodeLength) > Integer.parseInt(rangePossibleCharacters)) {
            System.out.println("Error: it's not possible to generate a code with a length of " + secretCodeLength + " with " + rangePossibleCharacters + " unique symbols.");
            System.exit(0);
        }
    }

    @Override
    public void generateSecretCode() {
        int randomPosition, step = 0;
        while(step != Integer.parseInt(secretCodeLength)) {
            randomPosition = (int)(Math.random() * Integer.parseInt(rangePossibleCharacters));
            char randomChar = possibleCharacters.charAt(randomPosition);
            if (!String.valueOf(secretCode).contains(String.valueOf(randomChar))) {
                secretCode.append(randomChar);
                step++;
            }
        }
    }

    @Override
    public void startGame() {
        StringBuilder userOutput = new StringBuilder();
        userOutput.append("The secret is prepared: ");
        for (int i = 0; i < Integer.parseInt(secretCodeLength); i++) {
            userOutput.append("*");
        }

        if (Integer.parseInt(rangePossibleCharacters) <= 10) {
            userOutput.append(" (0-" + possibleCharacters.charAt(Integer.parseInt(rangePossibleCharacters) - 1) + ").");
        } else {
            userOutput.append(" (0-9, a-" + possibleCharacters.charAt(Integer.parseInt(rangePossibleCharacters) - 1) + ").");
        }

        System.out.println(userOutput);
        int turnCounter = 0;
        System.out.println("Okay, let's start a game!");
        while(true) {
            turnCounter++;
            System.out.println("Turn " + turnCounter + ":");
            String userSecretCode = scanner.nextLine();
            int cows = 0, bulls = 0;
            for (int i = 0; i < Integer.parseInt(secretCodeLength); i++) {
                if (userSecretCode.charAt(i) == secretCode.charAt(i)) {
                    bulls++;
                } else {
                    if (String.valueOf(secretCode).contains(String.valueOf(userSecretCode.charAt(i)))) {
                        cows++;
                    }
                }
            }
            if (bulls == secretCode.length() ) {
                System.out.println("Grade: " + bulls + " bulls\nCongratulations! You guessed the secret code.");
                break;
            } else {
                System.out.println("Grade: " + bulls +" bulls and " + cows + " cow");
            }
        }
    }
}
