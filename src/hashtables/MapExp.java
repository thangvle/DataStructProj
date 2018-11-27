package hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExp {
    public static Map<String, Integer> wordCount(List<String> words){
        Map<String, Integer> map = new HashMap<>();

        for (String word: words){
            if (!map.containsKey(word)){
                map.put(word, 1);
            }
            else{
                int occurences = map.get(word);
                map.put(word, occurences);
            }
        }
        return map;
    }



    public static Map<Integer, List<Integer>> splitNumberFactors(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> div2 = new ArrayList<>();
        List<Integer> div3 = new ArrayList<>();
        List<Integer> div5 = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        for (int i : arr) {
            if (i % 2 == 0){
                div2.add(i);
                map.put(2, div2);
            }
            else if (i % 3 == 0) {
                div3.add(i);
                map.put(3, div3);
            }
            else if (i % 5 == 0) {
                div5.add(i);
                map.put(5, div5);
            }
            else {
                other.add(i);
                map.put(0, other);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<Integer, List<Integer>> arrayNum = new HashMap<>();
        int[] testNum = {10, 2, 3, 5, 7, 11, 9};

        System.out.println(splitNumberFactors(testNum));

        map.put("Hello", "foo");
        map.put("World", "bar");
        map.put("lll", "baz");


        System.out.println(map);
        System.out.println(map.get("Hello"));
        System.out.println(map.remove("Hello"));
        System.out.println(map);

        for (String thing : map.keySet()) {
            System.out.println("Key: " + thing + "\tValue: " + map.get(thing));
        }
    }

}
