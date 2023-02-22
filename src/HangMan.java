import java.util.Random; import java.util.Scanner;
public class HangMan {

    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    private int wrongAnswersLeft = 10;
    private boolean isWon = false;
    private boolean isGameOver = false;
    private String solution;
    private int numberOfRounds = 0;
    String[] words = {"persist","grounds","orange","reader","classroom","choice","pen","banner","expenditure",
            "oppose","brain", "science","stand","finance","violation","old","conversation","umbrella","appeal",
            "shrink","merchant","consideration", "ratio","drama","consumption","curve","honest","fitness",
            "charter","shallow"};

    char[] guesses = new char[26]; //English has only 26 letters, and I'm too lazy to make a new Array every time

    public void nextRound(){
        numberOfRounds++;
    }
    public void wrongGuess(){
        wrongAnswersLeft--;
        if (wrongAnswersLeft <1)
            isGameOver = true;
    }
    public void pickSolution(){
        solution = words[random.nextInt(words.length)];
    }

    public void setSolution(String s){
        solution = s;
    }

    public void visualize(){
        isWon = true;
        for (int i =0 ; i < solution.length(); i++){

            boolean guessed = false;

            for (char g : guesses) {
                if (g == solution.charAt(i)) {
                    guessed = true;
                    break;
                }
            }
// niečo
            if (guessed)
                System.out.print(solution.charAt(i));
            else {
                System.out.print(" - ");
                isWon = false;
            }
        }
        System.out.println();
    }

    public char makeGuess(){
        String input = sc.nextLine();
        char g = input.charAt(0);
        g = Character.toLowerCase(g);

        boolean isUniqueGuess = true;
        for (char i : guesses){
            if (i == g){
                isUniqueGuess = false;
                break;
            }
        }

        if (!isUniqueGuess){
            System.out.println("Already guessed this letter, try again:");
            return makeGuess();
        }

        guesses[numberOfRounds] = g;

        return g;
    }

    public boolean checkGuess(char g){
        return solution.indexOf(g) != -1 ;
    }

    public boolean isWon(){
        return isWon;
    }
    public boolean isGameOver(){
        return isGameOver;
    }

    public int getWrongAnswersLeft(){
        return wrongAnswersLeft;
    }

    public String getSolution(){return solution;}
}
