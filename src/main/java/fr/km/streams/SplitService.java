package fr.km.streams;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SplitService {

    public static void main(String[] args) {
        String str = "Hello world";
        Pattern pattern = Pattern.compile(" ");
        Stream<String> stream = pattern.splitAsStream(str);
        stream.forEach(System.out::println);

        System.out.println("----------------------------");
        // char
        // In java 8 to 10
        IntStream chars = str.chars();  // return code ascii
        chars.mapToObj(x -> (char) x).map(c -> Character.toString(c)).forEach(System.out::println);




    }
}
