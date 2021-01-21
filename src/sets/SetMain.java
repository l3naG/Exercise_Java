package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {

//        Set<Integer> squares = new HashSet<>();
//        Set<Integer> cubes = new HashSet<>();
//
//        for (int i = 1; i <= 100; i++) {
//            squares.add(i * i);
//            cubes.add(i * i * i);
//        }
//
//        System.out.println(String.format("There are %d squares and %d cubes", squares.size(), cubes.size()));
//
//        Set<Integer> union = new HashSet<>(squares);
//        union.addAll(cubes);
//        System.out.println(String.format("Inion contains %d elements", union.size()));
//
//        Set<Integer> intersection = new HashSet<>(squares);
//        intersection.retainAll(cubes);
//        System.out.println(String.format("Intersection contains %d elements", intersection.size()));
//        for (int i : intersection) {
//            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
//        }

//
//        Set<Integer> my_cubes = new HashSet<>();
//        Set<Integer> my_squares = new HashSet<>();
//        for (int i = 1; i <= 100; i++) {
//            my_cubes.add(i * i * i);
//            my_squares.add(i * i);
//        }
//
//        Set<Integer> my_union = new HashSet<>(my_cubes);
//        my_union.addAll(my_squares);
//        System.out.println(String.format("Union has %d elements", my_union.size()));
//
//        Set<Integer> my_intersection = new HashSet<>(my_squares);
//        my_intersection.retainAll(my_cubes);
//        for (Integer i : my_intersection) {
//            System.out.println(i + " Math.sqrt() of i is " + Math.sqrt(i) + " and Math.cbrt() of i is " + Math.cbrt(i));
//        }
//
//        Set<String> words = new HashSet<>();
//        String sentence = "One day in the day of the fox";
//        String[] arrayWords = sentence.split(" ");
//        words.addAll(Arrays.asList(arrayWords));
//        for (String s : words) {
//            System.out.println(s);
//        }
//
//        Set<String> newWords = new HashSet<>();
//        String newSentence = "This is the best day of my life";
//        String[] splitSentence = newSentence.split(" ");
//        newWords.addAll(Arrays.asList(splitSentence));
//        for (String s : newWords) {
//            System.out.print(s + ", ");
//        }
//        System.out.println();
//
//
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};

        nature.addAll(Arrays.asList(natureWords));
        divine.addAll(Arrays.asList(divineWords));
//
//        System.out.println("nature - divine");
//        Set<String> diff = new HashSet<>(nature);
//        diff.removeAll(divine);
//        printSet(diff);
//
//        System.out.println("divine - nature");
//        Set<String> diff_2 = new HashSet<>(divine);
//        divine.removeAll(nature);
//        printSet(diff_2);

        System.out.println("Symmetric difference, union - interseciton");
        Set<String> union_set = new HashSet<>(nature);
        union_set.addAll(divine);
        Set<String> intersection_set = new HashSet<>(nature);
        intersection_set.retainAll(divine);
        printSet(intersection_set);
        union_set.removeAll(intersection_set);
        printSet(union_set);

        System.out.println("Symmetric diff");
        Set<String> union = new HashSet<>(divine);
        union.addAll(nature);
        Set<String> inter = new HashSet<>(divine);
        inter.retainAll(nature);
        System.out.println("+++++++++++++++++++++++");
        union.removeAll(inter);
        printSet(union);

        if (nature.containsAll(divine)) {
            System.out.println("Divine is a subset of nature");
        }
        if (nature.containsAll(inter)) {
            System.out.println("Inter is a subset of nature");
        }
        if (divine.containsAll(inter)) {
            System.out.println("Inter is a subset of divine");
        }
    }

    private static void printSet(Set<String> set) {
        for (String as : set) {
            System.out.print(as + ", ");
        }
        System.out.println();
    }
}
