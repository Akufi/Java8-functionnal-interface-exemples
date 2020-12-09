package fr.km.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * show several way to create the Streams
 */
public class StreamFactoriesService {

    public static void main(String[] args) {

        // Stream empty
        Stream<Object> empty = Stream.empty();

        // Stream of
        Stream.of("PARIS", "TOULOUSE", "MARSEILLE");

        // Stream array
        int[] tab = new int[33];
        IntStream stream = Arrays.stream(tab);

        // Stream range
        final Stream<String> stm = IntStream.range(0, 20).mapToObj(index -> "Good");
        stm.forEach(System.out::println);
        final List<String> list = stm.collect(Collectors.toList());

        // Stream width files
        try {
            Path path = Paths.get("tmp/file.txt");
            final Stream<String> strStream = Files.lines(path, Charset.forName("UTF-8"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // Stream factory Generate
//        Stream.generate(() -> "Hello");
//        Stream.iterate("", s -> s + ", ");

    }
}
