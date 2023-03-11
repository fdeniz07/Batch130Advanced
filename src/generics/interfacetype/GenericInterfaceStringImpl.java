package generics.interfacetype;

//ÖNEMLI!!!!: Generics primitive data tipi ile calismaz. Sadece NonPrimitive kullanilir
public class GenericInterfaceStringImpl implements GenericInterface<String> {

    @Override
    public void printValue(String type) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
