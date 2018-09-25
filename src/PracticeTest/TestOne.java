package PracticeTest;

import java.util.ArrayList;
import java.util.List;

public class TestOne {
    public static int minPlusMax(List<Integer> list){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min){
                min = list.get(i);
            }

            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        return min+max;
    }

    public static List<String> reverseWords (List<String> list) {

        for (int i = 0; i < list.size(); i++){
            String word = list.get(i).toString();
            for (int j = 0; j < word.length(); j++){
                char reverse = word.charAt(j);
                reverse = word.charAt(word.length() - j-1);
            }


        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<String> w = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(5);

        w.add("hello");

        System.out.println(minPlusMax(l));
        System.out.println(reverseWords(w));
    }
}
