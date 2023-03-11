package Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundWildcard {

    public static void main(String[] args) {

        System.out.println("-----------wildcard ile alt sınır-------------");
        List<Integer> integerList = new ArrayList<>();
        addElements(integerList);
        System.out.println(integerList);

        List<Number> numberList = new ArrayList<>();
        addElements(numberList);
        System.out.println(numberList);

        List<Double> doubleList = new ArrayList<>();
        // addElements(doubleList);---> CTE :Integerın parentlarını kabul eder.

        System.out.println("-----------wildcard ile üst sınır-------------");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        multiplyByTwo(numberList);

    }

    //Integer data tipinin super classları(parentları) ile oluşturlan liste eleman ekleme
    //Integer,Number,Object
    //wildcard:?:bilinmeyen data tipi
    public static void addElements(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    //upperboundda wildcard kullanımı
    public static void multiplyByTwo(List<? extends Number> list) {
        //list.add(1);-->listte değişikliğe izin vermez.

        list.stream().map(t -> 2 * t.doubleValue()).forEach(System.out::println);
    }

    //wildcard kısıtlaması
    public static void printElements(List<?> listOfUnknown) {

        for (Object object : listOfUnknown) {
            System.out.println(object);
        }

    }
}
