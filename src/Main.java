public class Main {

    public static void main(String[] args) {
        Game game = new Game(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);

        for (int i = 0; i < 15; i++) {
            if (!game.getState()) break;
            game.move();
            System.out.println(game);
        }

        System.out.println("over");
    }
}
