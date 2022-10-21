import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Write a description of class Scrabble here. In this assignment, we are
 * counting how many words can be made from a word inputted by the user which is
 * 7 characters long.
 *
 * @author (Tushar Ganta)
 * @version (11/5/21)
 */
public class Scrabble {
  public static String wordFile = "smalllist.txt"; // change to your txt filename

  public static void main(String[] args) {
    findWords();
    // System.out.println(Arrays.toString(getHistogram("word")));
  }

  /**
   * Counts the number of lines for the given file.
   */
  public static int countLines(String filename) {
    int count = 0;
    // to be completed
    try {
      File file = new File(filename);
      Scanner console = new Scanner(file);
      while (console.hasNextLine()) {
        console.nextLine();
        count++;
      }
      console.close();
    } catch (Exception e) {
      System.out.println("no lines found for " + filename);
    }
    return count;
  }

  /**
   * Read all the words in the given file and return them in a String array. Uses
   * countLines to figure out the how big the array of words has to be
   * 
   */
  public static String[] readWordList(String filename) {
    // String words[] = { "ab", "abb", "abe", "bee", "car" };
    // to be completed -- also need to change how words[] is declared
    String[] words = new String[countLines(filename)];
    try {
      File file = new File(filename);
      Scanner console = new Scanner(file);
      int count = 0;
      while (console.hasNextLine()) {
        words[count] = console.nextLine();
        count++;
      }
      console.close();
    } catch (Exception e) {
      System.out.println("file not found");
    }
    return words;
  }

  /*
   * Gets a String from user via keyboard representing the Scrabble tiles The
   * String has to be all lowercase and needs to have 7 letters Steps to compare:
   * 1. input's length is 7 2. input is in lowercase 3. input is in range a-z
   * NOTE: do not use a loop to retake new input from user
   */
  // outputs for this method
  // System.out.println("Enter your tiles: ");
  // System.out.println("Input has " + 0 + " characters, need 7"); // need to
  // replace 0 with actual input's length
  // System.out.println("Input needs to be all lowercase: " + input); // variable
  // input is the input from user
  // System.out.println("Need characters a-z, not: " + input); // variable input
  // is the input from user tiles
  /**
   * In this method we are trying to get a tile, or user input and we shall see if
   * its greater than 7 and then check if there are any words that can be made
   * from it.
   * 
   * @return the tiles given by the user
   */
  public static String getUserTiles() {
    // to be completed -- input from keyboard
    Scanner console = new Scanner(System.in);
    System.out.println("Enter your tiles: ");
    String word = console.nextLine();
    if (word.length() != 7) {
      System.out.println("Input has " + word.length() + " characters, need 7");
    }
    for (int i = 0; i < word.length(); i++) {
      if (!Character.isLowerCase(word.charAt(i))) {
        System.out.println("Input needs to be all lowercase: " + word);
      }
      if (!Character.isLetter(word.charAt(i))) {
        System.out.println("Need characters a-z, not: " + word);
        System.exit(0);
      }
    }
    return word;
  }

  /**
   * Creates a histogram for the given string Histogram shows how many times each
   * letter appears in string The histogram is always an integer array with length
   * 26 where histogram[0] represents how many times 'a' appears histogram[1]
   * represents how many times 'b' appears ... histogram[25] represents how many
   * times 'z' appears The histogram for "age" would be {
   * 1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 } The histogram for
   * "azzz" would be { 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3 }
   */
  public static int[] getHistogram(String str) {
    System.out.println("Getting histogram for " + str);
    int[] histogram = new int[26];
    for (int i = 0; i < str.length(); i++) {
      for (char j = 'a'; j <= 'z'; j++) {
        if (str.charAt(i) == j) {
          histogram[str.charAt(i) - 97]++;
        }
      }
    }
    return histogram;
  }

  /**
   * Given two histograms representing user tiles and dictionary word return true
   * if the dictionary word can be formed from the tiles. For each letter in
   * wordHistogram, we need to have at least that many tiles. tileHistogram and
   * wordHistogram are both length 26. For example, given tileHistogram "abe" {
   * 1,1,0,0,1,0, ... } We can form the word "ab" which has a histogram of {
   * 1,1,0,0,0,0, ... } But we cannot form the word "abb" which has a histogram of
   * { 1,2,0,0,0,0, ... }
   */
  public static boolean canMakeWord(int[] tileHistogram, int[] wordHistogram) {
    // to be completed
    for (int i = 0; i < tileHistogram.length; i++) {
      if (tileHistogram[i] < wordHistogram[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Read the Scrabble dictionary Get user tiles (7 characters long) Find and
   * print all the words that can be made from the given tiles.
   */
  public static void findWords() {
    String wordFile = "smalllist.txt";
    String[] dictWords = readWordList(wordFile);
    String mytiles = getUserTiles();
    // make sure we have 7 tiles
    assert (mytiles.length() == 7);
    // make sure we have all lowercase tiles
    assert (mytiles.toLowerCase().equals(mytiles));
    int[] myhistogram = getHistogram(mytiles);
    int count = 0;
    for (int i = 0; i < dictWords.length; i++) {
      int[] wordH = getHistogram(dictWords[i]);
      System.out.println("Checking " + dictWords[i]);
      if (canMakeWord(myhistogram, wordH)) {
        count++;
        System.out.println(count + ": " + dictWords[i]);
      }
    }
    System.out.printf("Found %d words that can be made from %s.\n", count, mytiles);
  }
}