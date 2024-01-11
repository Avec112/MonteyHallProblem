package io.avec.montyhallproblem;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.run(1000, true);  // do no change
        application.run(1000, false); // do change
    }

    private void run(int gameCount, boolean doNotSwitchDoor) {
        int korrektUtenBytte = 0;
        List<Game> games = GameGenerator.getGames(gameCount);
        for(Game game : games) {
            game.pickRandomDoor();
            if(!doNotSwitchDoor)
                game.pickOtherDoor();

//            System.out.print(game);
            if(game.getPickedDoor() == game.getPriceDoor()) {
                korrektUtenBytte++;
//                System.out.println(" <-- Korrekt");
            } else {
//                System.out.println();
            }

        }

        System.out.println("Correct total ("+((doNotSwitchDoor)?"no change":"always change")+"): " + korrektUtenBytte + " of " + gameCount);
    }
}
