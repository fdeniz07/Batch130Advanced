package threads;
/*
Birden fazla thread aynı değişkende değişiklik yaparken
CPU üzerinde farklı çekirdeklerde çalışabilir.
Değişkenin bilgisi hız kazanmak için main memory yerine çekirdeğin cacheinde
tutulursa bir threadin yaptığı güncellemeden diğer threadlerin haberi olmayabilir.
Değişken bilgisinin cache yerine main memorye yazılıp oradan çağrılmasını sağlamak için
Volatile keywordü kullanılır. Dolayısıyla her threadin güncellemeleri görmesi garanti altına alınır.
 */
public class Volatile {

    public volatile static int flag=0;//değişken bilgisinin main memoryde tutulmasını garanti ediyoruz.

    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag==0){//flag değeri 1.çekirdeğin cachede tutulursa
                    System.out.println("Thread1 çalışıyor...");
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;//flag değeri 2.çekirdeğin cachede tutulursa
                System.out.println("Flag değeri 1 olarak değiştirildi.");
            }
        });
        thread2.start();

        //iki ayrı çekirdeğin cacheinde flag değeri tutulursa threadler güncel değeri göremeyebilirler.RİSK!!!!
    }

}
