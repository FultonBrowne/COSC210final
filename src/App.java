import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Lets make two players");
        RPSPlayer player1 = new RPSPlayer("Tim", "Apple");
        RPSPlayer player2 = new RPSPlayer("Jeff", "Amazon");
        System.out.println("Here are the players:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("Lets do a small, controlled fight between the players");
        player1.equip(RPSPlayer.ROCK);
        player2.equip(RPSPlayer.SCISSORS);
        System.out.println("Here are the players with their implements:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("Lets have the players fight each other");
        if (player1.defeats(player2)) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
        
        System.out.println("Lets equip the players with 200 random implements");
        Random random = new Random();
        for (int i = 0; i < 200000; i++) {
            player1.equip(random.nextInt(3));
            player2.equip(random.nextInt(3));
        }
        System.out.println("Here are the players with their implements:");
        System.out.println(player1);
        System.out.println(player2);

        System.out.println("Lets have the players fight each other");
        int player1Wins = 0;
        int player2Wins = 0;
        while (player1.hasImplements() && player2.hasImplements()) {
            if (player1.defeats(player2)) {
                player1Wins++;
            } else {
                player2Wins++;
            }
        }
        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);
        System.out.println("Here are the players after the fight:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.print("Congratulations to the winner! ");
        if (player1Wins > player2Wins) {
            System.out.println(player1.getName());
        } else {
            System.out.println(player2.getName());
        }

        System.out.println("Now its your turn to play, dr L! Lets make a player for you.");
        RPSPlayer drL = new RPSPlayer("Dr L", "CS");
        System.out.println("Here is your player:");
        System.out.println(drL);
        System.out.println("You'll play against me:");
        RPSPlayer me = new RPSPlayer("Fulton", "CS");
        System.out.println(me);
        System.out.println("You can pick 3 implements");
        System.out.println("0: Rock 1: Paper 2: Scissors");
        for (int i = 0; i < 3; i++) {
            System.out.println("Pick an implement:");
            int implement = Integer.parseInt(System.console().readLine());
            try {
                drL.equip(implement);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid implement, try again");
                i--;
            }
        }
        System.out.println("And I'll pick 3 random implements");
        for (int i = 0; i < 3; i++) {
            me.equip(random.nextInt(3));
        }
        System.out.println("Here are the players with their implements:");
        System.out.println(drL);
        System.out.println(me);
        System.out.println("Lets fight!");
        int drLWins = 0;
        int meWins = 0;
        while (drL.hasImplements() && me.hasImplements()) {
            if (drL.defeats(me)) {
                drLWins++;
            } else {
                meWins++;
            }
        }
        System.out.println("Dr L wins: " + drLWins);
        System.out.println("Fulton wins: " + meWins);
        System.out.println("Here are the players after the fight:");
        System.out.println(drL);
        System.out.println(me);
        System.out.print("Congratulations to the winner! ");
        if (drLWins > meWins) {
            System.out.println(drL.getName());
        } else {
            System.out.println(me.getName());
        }
    }
}
