package fr.km.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsService {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("PARIS", "TOULOUSE", "MARSEILLE", "BORDEAUX", "LILLE");

        List<String> list = stream.collect(Collectors.toList());
        Set<String> set = stream.collect(Collectors.toSet());
        String chain = stream.collect(Collectors.joining());
        String chain2 = stream.collect(Collectors.joining(",", "(", ")"));

        final Map<Integer, List<String>> map = stream.collect(Collectors.groupingBy(String::length));
        map.forEach((s, t)-> System.out.println(s + ":"+t));

    }
}
