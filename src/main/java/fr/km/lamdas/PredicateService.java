package fr.km.lamdas;

import java.util.Objects;

public class PredicateService {

    public static void main(String[] args) {
        Predicate<String> pred = s -> s != null;
        System.out.println(pred.test("Good")); //return true;

        //BiPredicate
        BiPredicate<String, Integer> bp = (s, i) -> s.length() == i;
        System.out.println(bp.test("hello", 5)); //return true;

        // combine a chain between two Predicates
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();
        Predicate<String> p3 = p1.and(p2);

        // add negate Operation
        Predicate<String> p4 = p1.and(p2.negate());

        System.out.println(p3.test(null));
        System.out.println(p3.test(""));
        System.out.println(p3.test("Hello"));
        System.out.println(" ---- negate Predicates -------");
        System.out.println(p4.test(null));
        System.out.println(p4.test(""));
        System.out.println(p4.test("Hello"));


    }
}

interface Predicate<T> {
    public boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }

    default Predicate<T> negate(){
        return (T t) -> !this.test(t);
    }
}

interface BiPredicate<T, U> {
    public boolean test(T t, U u);
}