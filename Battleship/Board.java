import java.util.Arrays;
import java.util.Scanner;


public class Board {
  private String[][] attackBoard_1 = new String[10][10];
  private String[][] shipBoard_1 = new String[10][10];
   
  private String[][] attackBoard_2 = new String[10][10];
  private String[][] shipBoard_2 = new String[10][10];


  public Board(){
    for (String[] x: shipBoard_1){
      Arrays.fill(x, "-");
    }
    for (String[] x: attackBoard_1){
      Arrays.fill(x, "-");
    }
    // Player 2
    for (String[] x: shipBoard_2){
      Arrays.fill(x, "-");
    }
    for (String[] x: attackBoard_2){
      Arrays.fill(x, "-");
    }
  }


  public void addShip(int turn, String letter, int size){
    Scanner obj = new Scanner(System.in);
    Boolean placed = false;
    while (!placed){
      String location = obj.nextLine().toUpperCase();
      System.out.print("Vertical (true) or Horizontal (false): ");
      String rotation = obj.nextLine().toUpperCase();
       
      String C = location.substring(0, 1);
      String R = location.substring(1);
      Boolean vert = rotation.equals("TRUE");


      String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


      int Col = Alphabet.indexOf(C);
      int Row = Integer.parseInt(R);
      String[][] board = getBoard(turn, "Ships");


      if (board[Col][Row].equals("-")){
        if (vert && Row + size <= 10 && board[Col][Row + size-1].equals("-")){
          System.out.println("VERTICAL");
          Boolean flag = false;
          for (int i = 0; i < size; i++){
            if(!board[Col][Row+i].equals("-")){
              flag = true;
            }
          }
          if (!flag){
            for (int i = 0; i < size; i++){
              board[Col][Row+i] = letter;
            }
            placed = true;
            return;
          }
        }
        else if(!vert && Col + size <= 10 && board[Col + size-1][Row].equals("-")){
          Boolean flag = false;
          System.out.println("HORIZONTAL");
          for (int i = 0; i < size; i++){
            if(!board[Col+i][Row].equals("-")){
              flag = true;
            }
          }
          if (!flag){
            for (int i = 0; i < size; i++){
              board[Col+i][Row] = letter;
            }
            placed = true;
            return;
          }
        }
      }
      System.out.println("Invalid placement");
    }
  }


  public void fire(int turn){
    Scanner obj = new Scanner(System.in);
    String location = obj.nextLine().toUpperCase();
    String key = "CBDSP";


    String C = location.substring(0, 1);
    String R = location.substring(1);


    String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    int Col = Alphabet.indexOf(C);
    int Row = Integer.parseInt(R);


     
    String[][] att = getBoard(turn, "Attack");


    if (turn == 1)
      turn = 2;
    else
      turn = 1;


    String[][] def = getBoard(turn, "Ships");
    String hit = def[Col][Row];


    //System.out.println("HIT " + hit);


    if (key.indexOf(hit) != -1){
      // Hit
      att[Col][Row] = "X";
      def[Col][Row] = def[Col][Row].toLowerCase();
    }
    else{
      // Miss
      att[Col][Row] = "M";
      def[Col][Row] = "m";
    }
  }


  public String[][] getBoard(int plr, String type){
    if (plr == 1){
      if (type == "Ships")
        return shipBoard_1;
      else
        return attackBoard_1;
    }
    else{
      if (type == "Ships")
        return shipBoard_2;
      else
        return attackBoard_2;
    }
  }


  public int sunkShips(int turn){
    if (turn == 1)
      turn = 2;
    else
      turn = 1;
     
    String[][] board = getBoard(turn, "Ships");


    String key = "CBDSP";
    String n = "";
     
    int count = 0;
    for (String[] x: board){
      for (String z: x){
        n += z;
      }
    }
    for (int i = 0; i < key.length(); i++){
      String letter = key.substring(i, i+1);
      if (n.indexOf(letter) == -1){
        count++;
      }
    }
    return count;
  }


  public Boolean gameOver(){
    if (sunkShips(1) == 5 || sunkShips(2) == 5){
      // ALL SHIPS SUNK
      return true;
    }
    return false;
  }
  // Display
  public void Display(String[][] Game){
    System.out.println("  A B C D E F G H I J");;
    for (int i = 0; i < Game[0].length; i++) {
      System.out.print(i);
      for (int x = 0; x < Game.length; x++){
        if (Game[x][i] == null)
          System.out.print("  ");
        else
          System.out.print(" " + Game[x][i]);
      }
      System.out.println();
      }
  }
}
