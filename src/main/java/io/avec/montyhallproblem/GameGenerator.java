package io.avec.montyhallproblem;

import java.util.ArrayList;
import java.util.List;

public class GameGenerator {


    public static List<Game> getGames(int gameCount) {
        List<Game> games = new ArrayList<>();
        int count = gameCount;
        while(count-- > 0) {
            games.add(new Game());
        }
        return games;
    }
}
