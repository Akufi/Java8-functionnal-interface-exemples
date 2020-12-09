package fr.km.lamdas.maps;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * use merge of string of map's method
 */
public class MergeService {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> lst = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
        BiFunction<String, String, String> fc = (s1, s2)  -> s1 + ", "+ s2;
        for (String s : lst){
            // create new arrayList if key not exist and chain to add the value
            map.merge(s.length(), s,  fc );
        }

        // print
        BiConsumer bc = (k, v) -> System.out.println(k + " : " + v);
        map.forEach(bc);
    }

}
