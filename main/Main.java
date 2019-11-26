package main;

public class Main {
    public static void main (String[] args) {
        ReadInput readInput = new ReadInput(args[0], args[1]);
        Input gameInput = readInput.load();

        System.out.print(gameInput.getN() + " " + gameInput.getM() + "\n");
        for (int i = 0; i < gameInput.getN(); ++i) {
            System.out.println(gameInput.getGround().get(i));
        }

        System.out.println(gameInput.getP());
        for (int i = 0; i < gameInput.getP(); ++i) {
            System.out.println(gameInput.getPlayers().get(i));
        }

        System.out.println(gameInput.getR());
        for (int i = 0; i < gameInput.getR(); ++i) {
            System.out.println(gameInput.getRoundMoves().get(i));
        }

    }
}
