package fr.km.lamdas.maps;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

// using computeIfAbsent map method

public class ComputeIfAbsentService {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> lst = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
        Function<Integer, List<String>> f = i -> new ArrayList<>();
        for (String s : lst){
            // create new arrayList if key not exist and chain to add the value
            map.computeIfAbsent(s.length(), f).add(s);
        }
        BiConsumer bc = (k, v) -> System.out.println(k + " : " + v);
        map.forEach(bc);

    }
}
