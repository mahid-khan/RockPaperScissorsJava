package RPS;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class RPS {

    public static String winLogic(String cpuChoice, String userChoice) {
        boolean userWon = false;
        if (userChoice.equals("ROCK") && cpuChoice.equals("PAPER")) {
            userWon = false;
        } else if (userChoice.equals("ROCK") && cpuChoice.equals("SCISSORS")) {
            userWon = true;
        } else if (userChoice.equals("PAPER") && cpuChoice.equals("ROCK")) {
            userWon = true;
        } else if (userChoice.equals("PAPER") && cpuChoice.equals("SCISSORS")) {
            userWon = false;
        } else if (userChoice.equals("SCISSORS") && cpuChoice.equals("ROCK")) {
            userWon = false;
        } else if (userChoice.equals("SCISSORS") && cpuChoice.equals("PAPER")) {
            userWon = true;
        }

        if (userWon) {
            return "Win";
        } else {
            return "Lose";
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        List<String> choices = Arrays.asList("ROCK", "PAPER", "SCISSORS");

        System.out.println("Welcome to Rock, Paper, Scissors! [BEST OF 3]");

        int winCount = 0;
        int lossCount = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i<3; i++) {

            System.out.println("\n[ROUND " + (i+1) + "] Enter your choice below - Rock, Paper, or Scissors:\n");

            String userChoice = scanner.nextLine().toUpperCase();

            if (!(choices.contains(userChoice))) {
                throw new IllegalArgumentException("Invalid choice! Choose only from: Rock, Paper, or Scissors!");
            }

            System.out.println("\nYou chose " + userChoice + ". Computer is choosing now...\n");

            
            Thread.sleep(1500);

            Random rand = new Random();
            int randIndex = rand.nextInt(3);
            String cpuChoice = choices.get(randIndex);
            String gameResult;

            if (cpuChoice.equals(userChoice)) {
                gameResult = "Draw";
            } else {
                gameResult = winLogic(cpuChoice, userChoice);
            }

            System.out.println("Computer chooses " + cpuChoice + ". You " + gameResult + " this round.");

            Thread.sleep(2000);

            if (gameResult.equals("Win")) {
                winCount++;
            } else if (gameResult.equals("Lose")) {
                lossCount++;

            }
        }

        scanner.close();

        if (winCount >= 2){
            System.out.println("BEST OF 3 RESULT: YOU WIN!");
        } else if (lossCount >= 2) {
            System.out.println("BEST OF 3 RESULT: YOU LOSE! - COMPUTER TAKES THE WIN THIS TIME.");
        } else {
            System.out.println("BEST OF 3 RESULT: ITS A TIE!");
        }
        
        
    } 

}
