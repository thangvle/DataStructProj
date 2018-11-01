package hashtables;

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

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
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
