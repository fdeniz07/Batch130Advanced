package Generics.interfacetype;

//Eger bir class generic interface'i implement ederse, bu class'in da generic yapida olmasi gerekir.
public class GenericInterfaceImpl<T> implements GenericInterface<T> {

    @Override
    public void printValue(Object type) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
