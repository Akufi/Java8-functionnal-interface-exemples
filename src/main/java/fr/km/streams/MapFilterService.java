package fr.km.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFilterService {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("PARIS", "TOULOUSE", "MARSEILLE", "BORDEAUX", "LILLE");
        stream.skip(2).limit(2).forEach(System.out::println);// return MARSEILLE BORDEAUX

        // select all strings width length is < 7
        final List<String> list = stream.filter(s -> s.length() < 7)
                .collect(Collectors.toList());

    }
}
