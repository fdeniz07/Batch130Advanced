package Generics.interfacetype;

//example: repository--->customer,user,account
public interface GenericInterface<T> {

    void printValue(T type);

    T getValue();
}
