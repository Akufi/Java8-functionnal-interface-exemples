package fr.km.lamdas;

public class FunctionService {

    public static void main(String[] args) {
        // Function
        Function<String, Integer> len = s -> s.length();
        int l = len.apply("Hello world");
        System.out.println(l);

        // BiFunction
        BiFunction<String, String, Integer> pos =
                (s1, s2) -> s1.indexOf(s2);
        final Integer index = pos.apply("Hello", "el");
        System.out.println(index); //return 1

        // UnaryOperator
        UnaryOperator<String> upper = s -> s.toUpperCase();
        System.out.println(upper.apply("Hello everybody"));

        // BinaryOperator
        BinaryOperator<String> concat = (s1 , s2) -> s1 + "-" + s2;
        System.out.println(concat.apply("Hello", "world"));
        // BinaryOperator -- int
        BinaryOperator<Integer> add = (i1 , i2) -> i1 + i2;
        System.out.println(add.apply(12, 8));

    }
}

interface Function<T, R>{
    public R apply(T t);
}

interface BiFunction<T, U, R>{
    public R apply(T t, U u);
}

interface UnaryOperator<T> extends Function<T, T>{
}

interface BinaryOperator<T> extends BiFunction<T,T,T>{
}