package fr.km.lamdas;

public class SupplierService {

    public static void main(String[] args) {
        Supplier<String> sup = () -> "Hello";
        String s = sup.get();
        System.out.println(s);
    }
}

interface Supplier<T>{
    public T get();
}