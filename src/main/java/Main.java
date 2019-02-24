import java.util.Scanner;

public class Main {
    private Dealer dealer = new Dealer();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Deck deck = new Deck();
        Player player1 = new Player("Selga");
        int pot = 0;
        int cardsRevealed = 0;
        player1.setMoney(100);
        String gameState = "INITIAL";
        Card card1;
        Card card2;
        Card card3;
        Card card4;
        Card card5;
        while(true) {
            switch (gameState) {
                case "INITIAL":
                    player1.setCard1((Card) deck.pop());
                    player1.setCard2((Card) deck.pop());
                    card1 = (Card) deck.pop();
                    card2 = (Card) deck.pop();
                    card3 = (Card) deck.pop();
                    card4 = (Card) deck.pop();

                    System.out.println(player1.getNickname() + " has: " + player1.getCard1() + ", " + player1.getCard2());
                    gameState = "BETTING";
                    break;
                case "BETTING":
                    System.out.println("What would you like to do?\n" +
                            "c - check\n" +
                            "b {amount} - bet that much money\n" +
                            "a - go all in\n" +
                            "f - fold\n");

                    String[] input = reader.nextLine().split(" ");
                    switch (input[0]) {
                        case "c":
                            gameState = "REVEAL";
                            break;
                        case "b":
                            if (Integer.parseInt(input[1]) > player1.getMoney()) {
                                System.out.println("You don't have that much money.\n");
                            } else {
                                pot += Integer.parseInt(input[1]);
                                player1.setMoney(player1.getMoney() - Integer.parseInt(input[1]));
                                System.out.println("You've bet " + input[1] + "$");
                            }
                            break;
                        case "a":
                            pot += player1.getMoney();
                            System.out.println("You've bet " + player1.getMoney() + "$ and went all in.");
                            player1.setMoney(0);
                            gameState = "FINAL";

                            break;
                        case "f":
                            gameState = "END";
                            break;
                    }
                    break;
                case "REVEAL":
                    if(cardsRevealed == 0){
                        System.out.println("Revealed cards on the table: " + card1 + ", " + card2 + "\n");
                        cardsRevealed = 2;
                    }
                    if(cardsRevealed == 2) {
                        System.out.println("Revealed cards on the table: " + card1 + ", " + card2 + ", " + card3 + "\n");
                        cardsRevealed++;
                    }
                    if(cardsRevealed == 3){
                        System.out.println("Revealed cards on the table: " + card1 + ", " + card2 + ", " + card3 + ", " + card4 + "\n");
                        cardsRevealed++;
                    }
                    if(cardsRevealed == 4){
                        System.out.println("Revealed cards on the table: " + card1 + ", " + card2 + ", " + card3 + ", " + card4 + ", " + card5 + "\n");
                        cardsRevealed++;
                    }

                    break;
                case "FINAL":

                    break;
                case "END":
                    break;
            }
        }

    }
}
