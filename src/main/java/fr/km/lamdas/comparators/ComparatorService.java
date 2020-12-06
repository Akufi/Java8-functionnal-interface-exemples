package fr.km.lamdas.comparators;

import fr.km.models.User;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class ComparatorService {
    public static void main(String[] args) {

        Comparator<String> c1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(c1.compare("Do", "It")); // return -1
        System.out.println(c1.compare("Do", "Do")); // return 0
        System.out.println(c1.compare("It", "Do")); // return +1

        //
        User bob = new User("Bob", 24);
        User jane = new User("Jane", 36);
        User patrick = new User("Patrick", 54);
        User patrickSon = new User("Patrick", 12);

        // without any function
        Comparator<User> cmp0 = (s1, s2) -> s1.getName().compareTo(s2.getName());

        Function<User, String> getNameFunc = user -> user.getName();
        Function<User, Integer> getAgeFunc = user -> user.getAge();

        // create comparator T with extractor function
        Comparator<User> cmpName = Comparator.comparing(getNameFunc);
        Comparator<User> cmpAge = Comparator.comparing(getAgeFunc);


        System.out.println("Bob < Jane : " + (cmpName.compare(bob, jane) < 0));
        System.out.println("Bob < Patrick : " + (cmpName.compare(bob, patrick) < 0));
        System.out.println("Jane < Patrick : " + (cmpName.compare(jane, patrick) < 0));

        // to chain two comparator
        Comparator<User> cmpCombination = Comparator.comparing(getNameFunc).thenComparing(getAgeFunc);

        System.out.println("-----------------------------------");
        System.out.println("Bob < Jane : " + (cmpCombination.compare(bob, jane) < 0));
        System.out.println("Bob < Patrick : " + (cmpCombination.compare(bob, patrick) < 0));
        System.out.println("Jane < Patrick : " + (cmpCombination.compare(jane, patrick) < 0));
        System.out.println("Patrick < Patrick son: " + (cmpCombination.compare(patrick, patrickSon) < 0));

    }

}

interface Comparator<T> {
    public int compare(T s1, T s2);

    public static <T, U extends Comparable<U>>Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (s1, s2) -> keyExtractor.apply(s1).compareTo(keyExtractor.apply(s2));
    }

    default Comparator<T> thenComparing(Comparator<T> other){
        Objects.requireNonNull(other);
        return (T s1, T s2) ->{
            int cmp = this.compare(s1, s2);
            if (cmp == 0 ){
                return other.compare(s1, s2);
            }
            return cmp;
        };
    };

    default Comparator<T> thenComparing(Function<T, Integer> keyExtractor){
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = Comparator.comparing(keyExtractor);
            return this.thenComparing(other);
    }


}
