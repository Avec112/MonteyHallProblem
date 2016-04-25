package no.avec112.montyhallproblem;

import java.util.Random;

public class Game {
    private Random random = new Random();
    private Door door1 = new Door("1");
    private Door door2 = new Door("2");
    private Door door3 = new Door("3");

    public Game() {
        long a = random.nextLong();
        long b = random.nextLong();
        long c = random.nextLong();

        if(a > b && a > c) {
            door1.setPrice(true);
        } else if (b > a && b > c){
            door2.setPrice(true);
        } else {
            door3.setPrice(true);
        }

    }


    public Door revealEmptyDoor() {
        if(isDoorPicked()) {
            if (door1.isPrice() && door1.isPicked()) {
                return (random.nextBoolean()) ? door2 : door3;
            } else if (door2.isPrice() && door2.isPicked()) {
                return (random.nextBoolean()) ? door1 : door3;
            } else if (door3.isPrice() && door3.isPicked()) {
                return (random.nextBoolean()) ? door1 : door2;
            } else if ((door1.isPicked() && door2.isPrice()) || (door2.isPicked() && door1.isPrice())) {
                return door3;
            } else if ((door2.isPicked() && door3.isPrice()) || (door3.isPicked() && door2.isPrice())) {
                return door1;
            } else if ((door1.isPicked() && door3.isPrice()) || (door3.isPicked() && door1.isPrice())) {
                return door2;
            }
        }
        throw new IllegalStateException("Er det noen pris bak noen dør og er det valgt noen dør");
    }

    public void pickRandomDoor() {
        try {
            Door alreadyPicked = getPickedDoor();
            alreadyPicked.setPicked(false);
        } catch (IllegalStateException e) {
            // do nothing
        }

        switch(random.nextInt(3)) {
            case 0:
                door1.setPicked(true);
                break;
            case 1:
                door2.setPicked(true);
                break;
            default:
                door3.setPicked(true);
        }
    }

    public void pickOtherDoor() {
        Door revealedDoor = revealEmptyDoor();
        Door picked = getPickedDoor();

        picked.setPicked(false);
        if(door1 != revealedDoor && door1 != picked) {
            door1.setPicked(true);
        } else if(door2 != revealedDoor && door2 != picked) {
            door2.setPicked(true);
        } else {
            door3.setPicked(true);
        }
    }

    public Door getPriceDoor() {
        if(door1.isPrice()) {
            return door1;
        } else if(door2.isPrice()) {
            return door2;
        } else return door3;
    }

    public Door getPickedDoor() {
        if(door1.isPicked()) {
            return door1;
        } else if(door2.isPicked()) {
            return door2;
        } else if(door3.isPicked()) {
            return door3;
        } else {
            throw new IllegalStateException("No door is yet to be picked.");
        }
    }

    public boolean isDoorPicked() {
        return door1.isPicked() || door2.isPicked() || door3.isPicked();
    }

    @Override
    public String toString() {
        return getPickedDoor() + " | " + revealEmptyDoor() + " | " + getPriceDoor();
    }
}
