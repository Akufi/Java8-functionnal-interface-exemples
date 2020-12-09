package fr.km.streams;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupByService {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("PARIS", "TOULOUSE", "MARSEILLE", "BORDEAUX", "LILLE");
        Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        map.forEach((s, t) -> System.out.println(s + ":" + t));
        // print
        //      5:[PARIS, LILLE]
        //      8:[TOULOUSE, BORDEAUX]
        //      9:[MARSEILLE]
        System.out.println("---------Collectors.counting() ---------------------");
        Stream<String> stream2 = Stream.of("PARIS", "TOULOUSE", "MARSEILLE", "BORDEAUX", "LILLE");
        stream2.collect(Collectors.groupingBy(String::length, Collectors.counting() ))
            .forEach((s, t) -> System.out.println(s + ":" + t));

        Stream<String> stream3 = Stream.of("PARIS", "TOULOUSE", "MARSEILLE", "BORDEAUX", "LILLE", "ANGER");
        final Map<Integer, Long> map1 = stream3.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        final Map.Entry<Integer, Long> entry = map1.entrySet().stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(entry);


        System.out.println("-----------Function.identity() -------------------");
        String str = "1 5 2 2 6 4 8 8 4 1 2 1 23 5 4 12 2";
        Pattern pattern = Pattern.compile(" ");
        Stream<String> strm = pattern.splitAsStream(str);
        final Map<String, Long> longMap = strm.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final Map.Entry<String, Long> entryInt = longMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(entryInt); // print 2=4


    }
}
