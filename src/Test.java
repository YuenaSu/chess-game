

public class Test {
    public static void main(String[] args) {
        mockGame game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);

        System.out.println("goes up to h8");
        game.addTestNumber(new int[]{0, 3, 4});
        game.move();
        System.out.println(game.pos());
        System.out.println("Game state is false");
        System.out.println(game.getState());

        System.out.println("goes up to h1");
        game.addTestNumber(new int[]{0, 0, 1});
        game.move();
        System.out.println(game.pos());

        System.out.println("goes right to a1");
        game.addTestNumber(new int[]{1, 0, 1});
        game.move();
        System.out.println(game.pos());

        System.out.println("goes right to h1");
        game.addTestNumber(new int[]{1, 3, 4});
        game.move();
        System.out.println(game.pos());

        game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);
        for (int i = 0; i < 15; i++) {
            game.addTestNumber(new int[]{1, 1, 1});
            game.move();
        }

        System.out.println(game.toString());

        game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);
        for (int i = 0; i < 15; i++) {
            game.addTestNumber(new int[]{0, 1, 1});
            game.move();
        }

        System.out.println(game.toString());

        game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);
        game.addTestNumber(new int[]{1, 0, 1});
        game.move();
        System.out.println(game.toString());

        game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);
        game.addTestNumber(new int[]{1, 2, 3});
        game.move();
        System.out.println(game.toString());

        game = new mockGame(8, 8, new int[]{2, 2}, new int[]{7, 0}, 15);
        game.addTestNumber(new int[]{0, 1, 2});
        game.move();
        System.out.println(game.toString());
        game.addTestNumber(new int[]{1, 1, 1});
        game.move();
        System.out.println(game.toString());
    }
}
