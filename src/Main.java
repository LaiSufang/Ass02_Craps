import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int point = 0;
        char userChoice = 'y';
        boolean continuePlaying = true;
        Scanner scanner = new Scanner(System.in);

        do {
            Random random = new Random();
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            sum = dice1 + dice2;

            //If the sum is 2, 3 or 12 it is called "craps" or "crapping out" and the game is over with a loss.
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
                System.out.println("Crapping out! You lose!");
                System.out.println("Do you want to play again? press y or Y to continue or any other key to exit.");
                userChoice = scanner.next().charAt(0);
                if (userChoice != 'y' && userChoice != 'Y') {
                    continuePlaying = false;
                }
            }
            //If the sum is 7 or 11 it is called a ‘natural’ and the game is over with a win.
            else if (sum == 7 || sum == 11) {
                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
                System.out.println("Natural! You win!");
                System.out.println("Do you want to play again? press y or Y to continue or any other key to exit.");
                userChoice = scanner.next().charAt(0);
                if (userChoice != 'y' && userChoice != 'Y') {
                    continuePlaying = false;
                }
            }
            //For all other values, the sum becomes ‘the point’ and the user makes subsequent rolls until they either throw a 7 in which case they loose or they make the point sum in which case they win.
            else {
                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
                point = sum;
                System.out.println("The point is: " + point);
                do {
                    dice1 = random.nextInt(6) + 1;
                    dice2 = random.nextInt(6) + 1;
                    sum = dice1 + dice2;
                    System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);
                    if (sum == 7) {
                        System.out.println("You lose!");
                        break;
                    } else if (sum == point) {
                        System.out.println("The point equals the sum. You win!");
                        break;
                    }
                } while (sum != 7 && sum != point);
                System.out.println("Do you want to play again? press y or Y to continue or any other key to exit.");
                userChoice = scanner.next().charAt(0);
                if (userChoice != 'y' && userChoice != 'Y') {
                    continuePlaying = false;
                }
            }
        } while (continuePlaying);
    }
}