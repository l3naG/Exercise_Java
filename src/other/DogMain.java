package other;

public class DogMain {
    public static void main(String[] args) {


        Labrador rover = new Labrador("Rover");
        Dog rover_2 = new Dog("Rover");

        System.out.println(rover.equals(rover_2));
        System.out.println(rover_2.equals(rover));

    }
}
