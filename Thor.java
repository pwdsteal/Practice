package Thor;

import java.util.Scanner;


enum Directions {
    UP("N"), RIGHT_UP("NE"), RIGHT("E"), RIGHT_DOWN("SE"), DOWN("S"),
    LEFT_DOWN("SW"), LEFT("W"), LEFT_UP("NW");
    public final String string;

    Directions(String string) {
        this.string = string;
    }
}

class Player {
   static int ThorX;
   static int ThorY;

    static private Directions choice(Directions x, Directions y) {
        if (x == null) return y;
        if (y == null) return x;

        if (x == Directions.LEFT && y == Directions.UP) return Directions.LEFT_UP;
        if (x == Directions.LEFT && y == Directions.DOWN) return Directions.LEFT_DOWN;
        if (x == Directions.RIGHT && y == Directions.UP) return Directions.RIGHT_UP;
        if (x == Directions.RIGHT && y == Directions.DOWN) return Directions.RIGHT_DOWN;

        return null;
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        ThorX = in.nextInt(); // Thor.Thor's starting X position
        ThorY = in.nextInt(); // Thor.Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor.Thor can move. Do not remove this line.

            int difX = ThorX - lightX;
            int difY = ThorY - lightY;
            Directions xMove = null;
            Directions yMove = null;
            
            if (Math.abs(difX) > 0) {
                xMove = difX < 0 ? Directions.RIGHT : Directions.LEFT;
            }

            if (Math.abs(difY) > 0) {
                yMove = difY < 0 ? Directions.DOWN : Directions.UP;
            }

            Directions move = choice(xMove, yMove);
            switch (move) {
                case LEFT:
                    ThorX--; break;
                case RIGHT:
                    ThorX++; break;
                case UP:
                    ThorY--; break;
                case DOWN:
                    ThorY--; break;
                case LEFT_UP:
                    ThorX--; ThorY--; break;
                case LEFT_DOWN:
                    ThorX--; ThorY++; break;
                case RIGHT_UP:
                    ThorX++; ThorY--; break;
                case RIGHT_DOWN:
                    ThorX++; ThorY++; break;
            }
            
            System.out.println(move.string);
        }
    }
}
