import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class GuessingFilm
{
  public static void main( String [] args) throws FileNotFoundException
  {
    File file = new File("FilmsList.txt");
    Scanner fileScanner = new Scanner(file);

    // Count Number of movies in file
    int NumberOfFilms = 0;
    while (fileScanner.hasNextLine()){
      String Line = fileScanner.nextLine();
      NumberOfFilms++;
    }

    // MAke a list of movies
    fileScanner = new Scanner(file);
    int index = 0;
    String [] FilmsList = new String[NumberOfFilms];
    while (fileScanner.hasNextLine()){
      String Line = fileScanner.nextLine();
      FilmsList[index] = Line;
      index++;
    }

    // Choose random film
    int min = 0;
    int max = NumberOfFilms-1;
    //Generate random int value
    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
    String random_film = FilmsList[random_int];
    int FilmLen = random_film.length();

    StringBuilder GuessingFilm = new StringBuilder("-".repeat(FilmLen));

    int maxLossPoint = 10;
    int NumOfWrongCh = 0;
    char [] WrongChs = new char[10];
    Scanner input = new Scanner(System.in);
    for( ; NumOfWrongCh < maxLossPoint; ){
      System.out.println("You are guessing " + GuessingFilm);
      System.out.print("You have guessed (" + NumOfWrongCh + ") wrong letter: ");

      // print wrong character
      for(int j = 0; j < NumOfWrongCh; j++){
        System.out.print(WrongChs[j]);
        System.out.print(" ");
      }

      System.out.println();
      System.out.print("Guess a letter: ");
      char letter = input.nextLine().charAt(0);

      // replace correct letter
      if(random_film.indexOf(letter) != -1){
        for(int i = 0; i < FilmLen; i++)
        {
          int comp = Character.compare(random_film.charAt(i), letter);
          if(comp == 0){
            GuessingFilm.setCharAt(i, letter);
          }
        }
      }
      else
      {
        WrongChs[NumOfWrongCh] = letter;
        NumOfWrongCh++;
      }

      // Check if user finds the name of movie of not
      if (GuessingFilm.indexOf("-") == -1){
        System.out.println("You win!");
        System.out.println("You have guessed '"+ GuessingFilm +"' correctly");
        break;
      }
    }
    
    // Check if user dosen't the name of movie of not
    if (GuessingFilm.indexOf("-") != -1){
      System.out.println("You Loss");
      System.out.println("The movie is "+ random_film);
    }
  }
}
