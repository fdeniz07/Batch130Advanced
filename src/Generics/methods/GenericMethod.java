package Generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr = {1, 23, 4, 65, 9};
        Double[] doubleArr = {0.5, 2.3, 45.9, 11.75};
        String[] strArr = {"Java", "harika", "bir", "programlama", "dili:)"};

        System.out.println("-----------------generic olmayan method -------------------");
        printArr(intArr);
        printArr(strArr);
        printArr(doubleArr);

        System.out.println("-----------------generic method ile -------------------");
        printAllArr(intArr);
        printAllArr(doubleArr);
        printAllArr(strArr);

        System.out.println("-----------------generic tip döndüren method -------------------");

        int n = getFirst(intArr);
        System.out.println(n);

        System.out.println(getFirst(strArr));

        String str = getFirst(strArr);
        System.out.println(getFirst(strArr));

        System.out.println("-----------------birden fazla generic tip kullanan method -------------------");
        int num = 55;
        printArrAndObject(strArr,num);
        printArrAndObject(intArr,"Harika");

    }

    //Array leri yazdirmak icin metot
    public static void printArr(Integer[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    //overloading
    public static void printArr(Double[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    //overloading
    public static void printArr(String[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    //generic method
    public static <T> void printAllArr(T[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    //sonuc döndüren generic method
    public static <T> T getFirst(T[] arr) {
        T first = arr[0];
        return first;
    }

    //birden fazla generic tip parametresi alan method
    public static <S, U> void printArrAndObject(S[] arr, U object) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println(object);

    }
}
