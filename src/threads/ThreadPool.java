package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Threadler gerçekten maliyetli yapılardır.
CPU, memoryde kaynak ayrılır.
Bu sebeple aktif olan thread sayısını sınırlandırmak isteyebiliriz.
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService service =Executors.newFixedThreadPool(3);
        //threadleri hazırlama
        ThreadCreator thread1=new ThreadCreator("A");
        ThreadCreator thread2=new ThreadCreator("B");
        ThreadCreator thread3=new ThreadCreator("C");
        ThreadCreator thread4=new ThreadCreator("D");
        ThreadCreator thread5=new ThreadCreator("E");
        ThreadCreator thread6=new ThreadCreator("F");
        //threadleri başlatma
//       thread1.start();
//       thread2.start();
//       thread3.start();
//       thread4.start();
//       thread5.start();
//       thread6.start();

        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);

        service.shutdown();//havuzdaki threadler iş için beklemeye devam eder


    }

}
class ThreadCreator extends Thread{

    private String name;

    public ThreadCreator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+" başladı");
        System.out.println(threadName+" "+name+ " işini yapıyor.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+ " işini bitirdi." );
    }
}
