package threads;

import java.util.concurrent.CountDownLatch;

/*
bazı threadlerin önce çalışmasını bu arada main ve diğer threadlerin beklemesini
istediğimizde countdownlatch in metodları ile öncelik verdiğimiz threadler için bir
sayaç oluşturulur bu sayaç her thread işini tamaladığında bir azaltılır. 0 olduğunda
bu threadleri bekleyen diğer threadler ve main thread çalşabilir.
 */
public class CountDownLatch01 {
    public static void main(String[] args) {

        CountDownLatch latch=new CountDownLatch(4);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("burada Thread1 çalışıyor await çağırıldığında workerlara öncelik verilir.");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 çalışıyor.");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2 çalışıyor.");
            }
        });
        WorkerThreads worker1=new WorkerThreads("worker-1",5000,latch);
        WorkerThreads worker2=new WorkerThreads("worker-2",7000,latch);
        WorkerThreads worker3=new WorkerThreads("worker-3",9000,latch);
        WorkerThreads worker4=new WorkerThreads("worker-4",6000,latch);
        //start
        thread1.start();
        thread2.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        System.out.println("burada main çalışıyor await çağırıldığında workerlara öncelik verilir.");

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" çalışıyor...");


    }

}

class WorkerThreads extends Thread{

    private int duration;
    private CountDownLatch latch;

    public WorkerThreads(String name,int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" başladı");
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName()+" bitirdi");
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
