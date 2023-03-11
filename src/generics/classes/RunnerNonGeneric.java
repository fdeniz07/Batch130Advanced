package generics.classes;

public class RunnerNonGeneric {

    public static void main(String[] args) {
        NonGenericClass nonGenericClass1 = new NonGenericClass();
        NonGenericClass nonGenericClass2 = new NonGenericClass();
        
        nonGenericClass1.setObject("Advanced Java");
        nonGenericClass2.setObject(65);
        
        //-----------------------------------------------------------
        
        String str =(String) nonGenericClass1.getObject();
        System.out.println("str = " + str);
        
        //String str2 =(String) nonGenericClass2.getObject();
        //System.out.println("str2 = " + str2); //RTE (Runtime Error)
        
        Integer num=(Integer) nonGenericClass2.getObject();
        System.out.println("num = " + num);
    }
}
