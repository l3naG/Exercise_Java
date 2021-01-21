package maps;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();

        languages.put("Python", "an interpreted, object-oriented, high-level language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "all-purpose, symbolic, instruction code");
        languages.put("Lisp", "therein lies madness");

//        if (languages.containsKey("Java")) {
//            System.out.println("Java is already in the map");
//        } else {
//            languages.put("Java", "a compiled, high-level, object oriented, platform independent");
//            System.out.println("Java entered successfully");
//        }
//        if (languages.containsKey("Java")) {
//            System.out.println("Java is already in the map");
//        } else {
//            System.out.println(languages.put("Java", "a compiled, high-level, object oriented, platform independent"));
//        }

//        for (String key : languages.keySet()) {
//            System.out.println(String.format("%s : %s", key, languages.get(key)));
//        }

//        if (languages.remove("Algol", "an algorithmic language")) {
//            System.out.println("Algol removed");
//        } else {
//            System.out.println("Key/value pair not found");
//        }

//        for (String key : languages.keySet()) {
//            System.out.println(String.format("%s : %s", key, languages.get(key)));
//        }

//        if (languages.replace("Lisp", "therein lies madness", "something else")) {
//            System.out.println("Lisp value successfully replaced");
//        }
//
//            languages.replace("Lisp", "functional programming language with imperative features");
//
//        for (String key : languages.keySet()) {
//            System.out.println(String.format("%s : %s", key, languages.get(key)));
//        }

        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        for (String i : road) {
            System.out.print(i + ", ");
        }
        System.out.println();




    }
}
