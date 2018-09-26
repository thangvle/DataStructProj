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

        List<String> reverseList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            String word = list.get(i).toString();
            String reverse = "";
            for (int j = word.length()-1; j >= 0 ; j--){
                reverse = reverse + word.charAt(j);
            }

            reverseList.add(i, reverse);



        }
        return reverseList;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        List<String> w = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(5);

        w.add("hello");
        w.add("yo");

        System.out.println(minPlusMax(l));
        System.out.println(reverseWords(w));
    }
}
