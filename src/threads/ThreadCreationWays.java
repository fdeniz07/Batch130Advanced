package threads;

public class ThreadCreationWays {


    public static void main(String[] args) {

        //ilk çalışan thread main threaddir, görelim:
        System.out.println("Current thread: " + Thread.currentThread().getName());

        //Thread classını extend ederek
        MyThread myThread1 = new MyThread();
        myThread1.start(); //Start metodu, thread olusturur, override edilen run metodunu cagirir ve icerisindeki islemleri gerceklestirir.
        myThread1.run(); //Dogrudan Run metodunu cagrildiginda icindeki islemler yapilir, ancak thread olusmaz. Yani run metodu main thread icinde calismis olur.

        // Runnable interfaceini implement ederek
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

//annonymous(isimsiz) class ile thread oluşturma
        //Runnable interfaceini implemente eden isimsiz bir class
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//5 sn threadi duraklattık
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current thread:" + Thread.currentThread().getName());
                System.out.println("Bu thread isimsiz class ile oluşturuldu.");
            }
        });
        thread3.setName("threadcik");
        thread3.start();

        //annonymous(isimsiz) class ile thread oluşturma:2
        //lambda exp kullanarak
        Thread thread4 = new Thread(() -> {
            Thread.currentThread().setName("harika");
            System.out.println("Current thread:" + Thread.currentThread().getName());
            System.out.println("Bu thread lambda ile oluşturuldu.");
            }
        );
        thread4.start();


        Thread thread5 = new Thread(() -> {
            System.out.println("Current thread:" + Thread.currentThread().getName());
            System.out.println("Bu thread lambda ile oluşturuldu.");
        });
        thread5.start();

        System.out.println("main metodun işlemi burada bitti");

    }
}

//Thread olusturma:
//1.Yol : Thread Class'ini extend ederek
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread thread'i calisiyor.");
    }
}

//2.Yol : Runnable interface'ini implement ederek
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable ile olusturdugumuz thread calisiyor.");
    }
}
