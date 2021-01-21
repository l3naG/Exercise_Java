package other;

import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        String word = "macaroni";
        boolean result = uniqueUsingSort(word);
        System.out.println(result);

    }

    public static boolean uniqueUsingSort(String word) {
        char[] chars = word.toCharArray();
        if (chars.length == 1) {
            return true;
        }
        Arrays.sort(chars);
        char temp = chars[0];
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == temp) {
                return false;
            } else {
                temp = chars[i];
            }
        }
        return true;
    }

    public static boolean findUniqueSort(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        char temp = characters[0];
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == temp) {
                return false;
            }
            temp = characters[i];
        }
        return true;
    }

}
