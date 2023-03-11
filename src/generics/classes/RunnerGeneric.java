package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ayni classi farkli data tipleri ile kullanabiliriz
public class RunnerGeneric {

    public static void main(String[] args) {
        //Genericler iel hangi data tipini kullanacagimizi karar verebiliriz.
        //Java 7 ile birlikte sag tarafta data tipini yazmaya gerek kalmadi.

        GenericClass<String> object1 = new GenericClass<>();
        object1.setType("Generic Class");

        //GenericClass<String> object2 = new GenericClass<>();
        //object2.setType(65);//CTE (Compile Time Error) verdi, String gerekli, int verdik.

        GenericClass<Integer> object3 = new GenericClass<>();
        object3.setType(65);
        int n = object3.getType(); //CASTING e gerek kalmadi

        List<String> list = new ArrayList<>();
        list.add("Mürsel");
        list.add("Ebubekir");
        // list.add(100); //String tipinde oldugunu belirttik
        // list.get(2);
        // list.get(3); //ClassCastException dan kurtulduk


        //NonGenericClass<String> obj = new NonGenericClass();

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        // map.put(2,99); //CTE verir

        //======================================COKLU DATA TIPI ILE GENERIC CLASS======================================

        GenericClassTwoParam<String, Integer> mymap = new GenericClassTwoParam<>();
        mymap.setS("Generic");
        mymap.setU(99);

        System.out.println(mymap.getS() + "," + mymap.getU());
    }
}
