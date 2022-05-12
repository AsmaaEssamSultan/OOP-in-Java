import java.util.Scanner;

class GuessGame{
  public static void main(String [] args){

    int min = 1;
    int max = 100;

    //Generate random int value
    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

    System.out.println("I have randomly chosen a number between [1, 100]");
    System.out.println("Try to guess it");
    int trail = 10;

    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i < trail; i++){
      System.out.println();
      System.out.println("You have " + (trail-i) + " guess(es) left");

      int guess = scanner.nextInt();
      if(guess > random_int)
      {
        System.out.println("It's smaller than " + guess);
      }
      else if(guess < random_int)
      {
        System.out.println("It's bigger than " + guess);
      }
      else if(guess == random_int)
      {
        System.out.println("CORRECT ... YOU WIN");
        break;
      }

      if(guess != random_int && i == 9)
      {
        System.out.println("YOU LOSS, Correct answer is " + random_int);
      }
    }

  }
}
