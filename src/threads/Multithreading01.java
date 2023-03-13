package threads;

public class Multithreading01 {

    public static void main(String[] args) {

        long startTime =System.currentTimeMillis();
        CounterWithoutMultiThread counter1 = new CounterWithoutMultiThread("Ebubekir");
        CounterWithoutMultiThread counter2 = new CounterWithoutMultiThread("Akin");

        counter1.countMe();
        System.out.println("-------------------------------------");
        counter2.countMe();
        long finishTime = System.currentTimeMillis();

        System.out.println("WithoutMultiThread ile gecen süre: "+(finishTime-startTime));


        long start =System.currentTimeMillis();
        CounterWithMultiThread counter3 = new CounterWithMultiThread("Ilker");
        CounterWithMultiThread counter4 = new CounterWithMultiThread("Abdullah");

        counter3.start();
        counter3.setName("İlker");
        System.out.println("-----------------------------");
        counter4.start();
        counter4.setName("Abdullah");

        try {
            counter3.join();//main threade counter3 threadinin işlemi bitene kadar bekle
            counter4.join();//main threade counter4 threadinin işlemi bitene kadar bekle
            //sonra tekrar main thread devam etsin.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long finish = System.currentTimeMillis();

        System.out.println("WithoutMultiThread ile gecen süre: "+(finish-start));
    }
}

class CounterWithoutMultiThread {

    public String name;

    public CounterWithoutMultiThread(String name) {
        this.name = name;
    }

    public void countMe() {
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+ " - "+name);
        }
    }
}

class CounterWithMultiThread extends Thread{

    public  String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        countMe();
    }

    public void countMe() {
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+ " - "+name);
        }
    }
}
