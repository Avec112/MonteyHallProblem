package no.avec112.montyhallproblem;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.run(1000, true);  // aldri bytt
        application.run(1000, false); // alltid bytt
    }

    private void run(int spill, boolean aldriBytte) {
        int korrektUtenBytte = 0;
        List<Game> games = GameGenerator.getGames(spill);
        for(Game game : games) {
            game.pickRandomDoor();
            if(!aldriBytte)
                game.pickOtherDoor();

//            System.out.print(game);
            if(game.getPickedDoor() == game.getPriceDoor()) {
                korrektUtenBytte++;
//                System.out.println(" <-- Korrekt");
            } else {
//                System.out.println();
            }

        }

        System.out.println("totalt antall korrekte ("+((aldriBytte)?"aldri bytte":"alltid bytte")+"): " + korrektUtenBytte + " av totalt " + spill);
    }
}
