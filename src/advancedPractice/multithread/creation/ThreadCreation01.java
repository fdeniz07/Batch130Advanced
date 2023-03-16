package advancedPractice.multithread.creation;

public class ThreadCreation01 {

 /*
    1) Multithreading Programlama nedir?
    Aynı processde iki veya daha fazla iş parçacığının(thread) aynı anda çalışma süreci
    2) Threadler 2 şekilde oluşturulur:
         --Thread sınıfından extend eden alt sınıf oluşturup, onun run metodu override edilir.
        --Runnable interface'ini implement eden bir alt sınıf oluşturup run metodu override edilir,
         ardından Thread sınıfının constructorına nesne olarak gönderilir.
    */

    public static void main(String[] args) {

        //Task1: Thread sınıfını extend eden Sayac isminde sınıf oluşturup
        // bu sınıftan sayıları 1 den 100 e kadar yazdıran iki tane thread oluşturunuz.


        Sayac thread1 = new Sayac("Ronaldo");
        Sayac thread2 = new Sayac("Messi");

        //thread1.run(); //thread olusmaz run calisir
        thread1.start();
        thread2.start();

    }



}
