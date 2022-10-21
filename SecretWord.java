import java.util.Random;
import java.util.Scanner;

/**
 * We are trying to get the user to guess the word based on a list of words.
 *
 * @author (Tushar Ganta & Prajeet Pounraj)
 * @version (11/10/21)
 */
public class SecretWord {
  String[] words = { "bike", "door", "flower", "coffee", "table" };
  String secretWord; // randomly chosen secret word
  char[] guessedLetters; // letters array to record guesses (max 100)
  int guesses; // total number of guesses
  int badGuesses; // total number of guesses that are not in secret word
  int maxGuesses; // maximum bad guesses allowed
  char[] blankLetters;

  // Create new SecretWord object
  // set secretWord, guessedLetters, guesses, maxGuesses and badGuesses
  SecretWord() {
    Random rand = new Random();
    int x = rand.nextInt(5);
    secretWord = "dragalia";
    guessedLetters = new char[100];
    guesses = 0;
    badGuesses = 0;
    maxGuesses = secretWord.length() - 1;
    setBlanks();
  }

  void setBlanks() {
    blankLetters = new char[secretWord.length()];
    for (int i = 0; i < blankLetters.length; i++) {
      blankLetters[i] = '_';
    }
  }

  void printBlanks() {
    for (int i = 0; i < blankLetters.length; i++) {
      System.out.print(blankLetters[i] + " ");
    }
    System.out.println();
  }

  // return true if the given letter is in secretWord
  boolean letterInSecretWord(char letter) {
    for (int i = 0; i < secretWord.length(); i++) {
      if (letter == secretWord.charAt(i)) {
        return true;
      }
    }
    return false;
  }

  // return true if given letter is already in guessedLetters
  boolean letterAlreadyGuessed(char c) {
    for (int i = 0; i < guessedLetters.length; i++) {
      if (c == guessedLetters[i]) {
        return true;
      }
    }
    return false;
  }

  // return true if all the letters in the secretWord
  // are also in the array guessedLetters
  boolean gotAllLetters() {
    int words = secretWord.length();
    int j = 0;
    for (int i = 0; i < blankLetters.length; i++) {
      if (secretWord.charAt(j) == blankLetters[i]) {
        words--;
      }
      j++;
    }
    if (words == 0) {
      return true;
    }
    return false;
  }

  // print the secret word using blanks
  // door is printed as _ _ _ _
  // when 'o' has been guessed, it is printed as _ o o _

  void update(char letter) {
    for (int i = 0; i < secretWord.length(); i++) {
      if (letter == secretWord.charAt(i)) {
        blankLetters[i] = secretWord.charAt(i);
      }
    }
    displaySecretWithBlanks();
  }

  void displaySecretWithBlanks() {
    printBlanks();
  }

  char promptAndGetLetter() {
    Scanner console = new Scanner(System.in);
    System.out.print("Guess a letter: ");
    String letter = console.next();
    while (!isValid(letter)) {
      System.out.println("Bad input!");
      System.out.println("Guess a letter: ");
      letter = console.next();
      guesses++;
    }
    guesses++;
    return letter.charAt(0);
  }

  boolean isValid(String str) {
    if (str.length() != 1) {
      return false;
    }
    for (char i = 'a'; i <= 'z'; i++) {
      if (str.charAt(0) == i) {
        return true;
      }
    }
    return false;
  }

  // play the SecretWord game
  void play() {
    System.out.println("Welcome to SecretWord");
    char letter = promptAndGetLetter();
    update(letter);
    while ((badGuesses < maxGuesses) && (!gotAllLetters())) {
      System.out.println(maxGuesses - badGuesses + " guesses left");
      letter = promptAndGetLetter();
      if (letterAlreadyGuessed(letter)) {
        System.out.println("Letter already guessed");
      }
      if (letterInSecretWord(letter)) {
        System.out.println("Good guess, " + letter);
        update(letter);
        guesses++;
      } else {
        System.out.println("Bad guess, " + letter);
        update(letter);
        badGuesses++;
        guesses++;
      }
    }
    System.out.println("The answer was: " + secretWord);
    if (gotAllLetters()) {
      System.out.println("Congratulations!!!");
    }
    if (badGuesses == maxGuesses) {
      System.out.println("You lost :-(");
    }
  }
}
