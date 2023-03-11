package Bounding;

//parametre olarak aldigimiz data tipini sinirlandirabiliriz.
//bu class da sadece Number'in alt siniflarini kullansin
public class GenericUpperBound<T extends Number> {

    //T upperbound olarak Number class'ini extend ettiginden Number Class'inin methodlarini kullanabiliyor.
    private T[] numberArray;//field,özellik

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //numberArray içindeki değerlerin ortalamsını bulan metod
    public double getAvarage() {
        double sum = 0;
        for (T t : this.numberArray) {
            sum += t.doubleValue();
        }

        double avg = sum / this.numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer[] intArr = {2, 3, 5, 99};
        Double[] doubleArr = {2.3, 5.5, 88.9};
        String[] strArr = {"Generic", "tipleri", "üstten", "sınırlandırabiliriz"};


        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAvarage());

        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAvarage());

        //   GenericUpperBound<String> obj3=new GenericUpperBound<>(strArr);-->CTE data tipini number ile sınırlandırdık.
    }
}


//public interface IEntityRepository<TEntity> where TEntity : class, IEntity, new()
// public class EfEntityRepositoryBase<TEntity> : IEntityRepository<TEntity> where TEntity : class, IEntity, new()