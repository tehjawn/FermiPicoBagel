package tehjawn.fermipicobagel;

import java.util.Random;

/**
 * Created by John on 10/19/2014.
 */
public class Bagels {

        //private Scanner keyb = new Scanner(System.in);
        private Random rng = new Random();
        private int secretNumber;
        private String secretString = String.valueOf(secretNumber);
        boolean win;
        private int count=1;


        public String getCount(){
            return String.valueOf(count);
        }

        public void playGame(String userGuessInput){

            secretString = String.valueOf(secretNumber);

            //System.out.println(secretNumber);
            while (true){
                System.out.print("Input a number between 100-999: ");
                String userGuess = userGuessInput;
                if(isGuessCorrect(userGuess)){
                    win = true;
                    //System.out.println("You win!");
                    break;
                } else {
                    printHint(userGuess);
                    //System.out.println("Try again!");
                    win = false;
                    count++;
                    break;
                }
            }
            if (count>1){
                tries = " tries.";
            }
            else{
                tries = " try.";
            }
            if (count>23){
                tries = " tries... do better next time!";
            }
            //System.out.println("It took you "+count+tries);
        }

        public String tries = "";
        public String getTries(){
            return tries;
        }
        public void resetCount(){ count = 1;}

        public void createSecretNumber(){
            secretNumber = rng.nextInt(900)+100;
        }
        public int getSecretNumber(){
            return secretNumber;
        }

        private boolean doesGuessExist(String guess){

            if (guess.equals(secretString)){
                //System.out.println("True");
                return true;
            } else {
                //System.out.print("False! : ");
                return false;
            }

        }


        private boolean isGuessCorrect(String guess) {
            //System.out.println(guess + " - " + secretString);
            if (guess.equals(secretString)){
                //System.out.println("True");
                return true;
            } else {
                //System.out.print("False! : ");
                return false;
            }
        }

/*

Print hints to System.out to help the user guess the correct number

*/

        private void printHint(String guess){

            char guess0 = guess.charAt(0);
            char guess1 = guess.charAt(1);
            char guess2 = guess.charAt(2);
//    int guessI0 = guess.indexOf(guess.charAt(0));
//    int guessI1 = guess.indexOf(guess.charAt(1));
//    int guessI2 = guess.indexOf(guess.charAt(2));
            char secret0 = secretString.charAt(0);
            char secret1 = secretString.charAt(1);
            char secret2 = secretString.charAt(2);
//    int secretI0 = secretString.indexOf(secretString.charAt(0));
//    int secretI1 = secretString.indexOf(secretString.charAt(1));
//    int secretI2 = secretString.indexOf(secretString.charAt(2));

            if(guess0==secret0){
                //System.out.print("Fermi ");
                hintString+="Fermi ";
            }
            if(guess1==secret1){
                //System.out.print("Fermi ");
                hintString+="Fermi ";
            }
            if(guess2==secret2){
                //System.out.print("Fermi ");
                hintString+="Fermi ";
            }

            if((guess0==secret1)||(guess0==secret2)){
                //System.out.print("Pico ");
                hintString+="Pico ";
            }
            if((guess1==secret0)||(guess1==secret2)){
                //System.out.print("Pico ");
                hintString+="Pico ";
            }
            if((guess2==secret0)||(guess2==secret1)){
                //System.out.print("Pico ");
                hintString+="Pico ";
            }
            if((guess0!=secret0)&&(guess0!=secret1)&&(guess0!=secret2)
                    &&(guess1!=secret0)&&(guess1!=secret1)&&(guess1!=secret2)
                    &&(guess2!=secret0)&&(guess2!=secret1)&&(guess2!=secret2)){
                //System.out.println("Bagel!");
                hintString+="Bagel";
            }
            //System.out.println("");
        }

        public String hintString = "";

        public String getHint(){
            return hintString;
        }

        public void hintReset(){
            hintString = "";
        }
}





