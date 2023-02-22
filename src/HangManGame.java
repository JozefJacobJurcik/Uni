import java.util.Scanner;
public class HangManGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HangMan hm = new HangMan();

        // picks a word to play with
        System.out.println("Do you want to set the solution? y/n");
        String x = sc.nextLine();
        if (x.equals("y")) {
            System.out.println("Type the solution:");
            hm.setSolution(sc.nextLine());
        }else hm.pickSolution();

        hm.visualize();
        while (!(hm.isWon()) && (!hm.isGameOver())){

            System.out.println("Your guess?");

            char guess = hm.makeGuess();
            if (hm.checkGuess(guess)) {
                System.out.println("Correct!");
                hm.visualize();
            }else {
                hm.wrongGuess();
                System.out.println("Nope! Wrong answers left: " + hm.getWrongAnswersLeft());
                hm.visualize();
            }

            hm.nextRound();
        }

        if (hm.isWon())
            System.out.println("You won!");
        else
            System.out.println("Sorry, you lost. The word was " + hm.getSolution());




    }
}
