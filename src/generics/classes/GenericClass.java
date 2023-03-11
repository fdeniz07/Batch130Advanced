package generics.classes;

//public class class_name<T>
public class GenericClass<T> {

    private  T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
