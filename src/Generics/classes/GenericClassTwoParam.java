package Generics.classes;

//(Bırden fazla)Iki tane data tipini parametre olarak kullanmak icin
public class GenericClassTwoParam<S,U> {

    private S s;
    private U u;

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }
}
