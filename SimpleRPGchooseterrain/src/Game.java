import java.util.Random;
import java.util.Scanner;

// Tile interface
interface Tile {
    char getCharacter();
    String getType();
}

// Concrete Tile Classes
class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }
}

class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }
}

class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }
}

class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }
}

class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "building";
    }
}

// Map interface
interface Map {
    Tile createTile();
    void display();
}

// Concrete Map Classes
class CityMap implements Map {
    @Override
    public Tile createTile() {
        // Implement logic to create random city tiles (Road, Forest, Building)
        Random random = new Random();
        int randomNumber = random.nextInt(3); // 0, 1, or 2

        switch (randomNumber) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }

    @Override
    public void display() {
        // Implement logic to display the city map
        // You can use a matrix of characters to represent the map and print it.
        System.out.println("City Map:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

class WildernessMap implements Map {
    @Override
    public Tile createTile() {
        // Implement logic to create random wilderness tiles (Swamp, Water, Forest)
        Random random = new Random();
        int randomNumber = random.nextInt(3); // 0, 1, or 2

        switch (randomNumber) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }

    @Override
    public void display() {
        // Implement logic to display the wilderness map
        // You can use a matrix of characters to represent the map and print it.
        System.out.println("Wilderness Map:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

// Game class
public class Game {
    public static void main(String[] args) {
        Map map = createMap();
        map.display();
    }

    private static Map createMap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of map (1 for CityMap, 2 for WildernessMap):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new CityMap();
            case 2:
                return new WildernessMap();
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
}
