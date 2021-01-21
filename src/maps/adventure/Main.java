package maps.adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        tempExit.put("S", 4);
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("S", 1);
        locations.put(5, new Location(5, "You are in the forest", tempExit));


        Map<String, String> availableDirections = new HashMap<>();
        availableDirections.put("QUIT", "Q");
        availableDirections.put("NORTH", "N");
        availableDirections.put("SOUTH", "S");
        availableDirections.put("WEST", "W");
        availableDirections.put("EAST", "E");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("S");
            if (loc == 0) {
                break;
            }

            System.out.println("Available exits are: ");
            Map<String, Integer> exits = locations.get(loc).getExits();
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (availableDirections.containsKey(word)) {
                        direction = availableDirections.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
