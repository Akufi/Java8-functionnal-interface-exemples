package fr.km.lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConsumerService {

    public static void main(String[] args) {

        Consumer<String> cons = s -> System.out.println(s);
        cons.accept("hello");

        List<String> lst = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
        lst.forEach(s -> System.out.println(s));

        //BiConsumer
        BiConsumer<String, Integer> bc = (s, i) -> System.out.println(s +" --> "+ i);
        bc.accept("Code", 50);

        // combine a chain between two Consumers
        Consumer<String> c1 = s -> System.out.println(" c1 -- "+ s);
        Consumer<String> c2 = s -> System.out.println(" c2 -- "+ s);
        Consumer<String> c3 = c1.andThen(c2);
        //c3 = c1.andThen(null);
        c3.accept("Hello");
    }
}

// take parameter and return void
interface Consumer<T>{
    public void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {
        Objects.requireNonNull(other);
        return  (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}

interface BiConsumer<T, U>{
    public void accept(T t, U u);
}
