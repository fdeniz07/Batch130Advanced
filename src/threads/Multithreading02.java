package threads;


import javax.swing.plaf.IconUIResource;

//threadler aynı anda aynı kaynağa erişip değişiklik yapmak isterlerse ne olacak?
//multithreading programlamada birden fazla thread aynı kaynağa(critical section) aynı anda erişip değişiklik yapmaya çalışırsa
//istenmeyen sonuçlar olur. Bu durumda threadlere sırayla erişim verilir. Yani ortak kaynağı bir thread kullanırken diğer
//thread beklemelidir. Bu işlem syncronized keywordü ile gerçekleştirlir.
public class Multithreading02 {

    public static int counter = 0;

    public static void main(String[] args) {

        //Iki tane thread olusturup, bu thread'lerin ayni kaynaga(counter) erismesini saglayalim
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " calisti.");
                Counter.count();
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " calisti.");
                Counter.count();
            }
        });
        thread2.setName("Jerry");
        thread2.start();
//        try{
//            thread1.join();
//        }
//        catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }

        //tom un bütün işlemleri bitirmesi için jerrrynin beklemesine gerek yok, sadece count metodunu sırayla kullanmaları yeterli
    }
}

class Counter {
    //counter degiskeninin degerini 1000 kez arttirsin
    public synchronized static void count() {
    //synchronized ile metoda erisen Thread'leri siraya koymus olur.
    // yani methodu ayna anda sadece bir thread kullanabilsin. Bu methoda bir thread ulasirsa bu method'u kilitle,
    //o thread'in islemi tamamlandiginda baska bir thread ulasabilsin, islemi tamamlanmadan baska bir thread ulasamasin!
    // ancak synchronized sirali islem yapacagi icin thread performansi ortadan kalkacaktir. Genellikle kullanimi nadirdir.


        for (int i = 1; i <= 1000; i++) {
            Multithreading02.counter++; //1000+1000= beklenen 2000
            System.out.println(Thread.currentThread().getName()+"-->Counter : "+Multithreading02.counter);
        }
        System.out.println("Counter : "+Multithreading02.counter);
    }
}
