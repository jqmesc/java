public class Battleship {
    public static void main(String[] args) {
        System.out.println("\nWelcome to battleship\n");


        // Vars
        Board game = new Board();
        Boolean running = true;
        int turn = 1;
        int score = 0;


        // Place Ships
        for (int i = 1; i<=2; i++){
            System.out.println("\nPlayer " + i + " place your ships.");
            game.Display(game.getBoard(i, "Ships"));
            // Carrier
            System.out.println("Where would you like your cruiser? (5)\n");
            game.addShip(i, "C", 5);
            game.Display(game.getBoard(i, "Ships"));
            // Battleship
            System.out.println("Where would you like your battleship? (4)\n");
            game.addShip(i, "B", 4);
            game.Display(game.getBoard(i, "Ships"));
            // Destroyer
            System.out.println("Where would you like your destroyer? (3)\n");
            game.addShip(i, "D", 3);
            game.Display(game.getBoard(i, "Ships"));
            // Submarine
            System.out.println("Where would you like your submarine? (3)\n");
            game.addShip(i, "S", 3);
            game.Display(game.getBoard(i, "Ships"));
            // Patrol boat
            System.out.println("Where would you like your patrol boat? (2)\n");
            game.addShip(i, "P", 2);
            game.Display(game.getBoard(i, "Ships"));
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }


        // Main
        while (running){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
           
            //System.out.println("SHIPS SUNK: " + game.sunkShips(turn));
            System.out.println("Score: " + score);


            // Display
            System.out.println("\nShips: ");
            game.Display(game.getBoard(turn, "Ships"));


            System.out.println("\nAttack: ");
            game.Display(game.getBoard(turn, "Attack"));


            // Fire
            System.out.println("\nPlayer " + turn + " fire: (A-J)(0-9)");
            game.fire(turn);


            // Check Win
            if (game.gameOver()){
                running = false;
                if (turn == 1)
                    score++;
            }


            // Swap turns
            if (running){
                if (turn == 1){
                    turn = 2;
                }
                else{
                    score++;
                    turn = 1;
                }
            }
        }
        // End Game
        System.out.println("\nPLAYER " + turn + " WIN!");
        System.out.println("Score: " + score + "\n");
    }
}
