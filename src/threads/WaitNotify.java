package Threads;
/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

wait ve notify monitor edilen(kilitlenen) obje için çağrılır.
*/
public class WaitNotify {

    public static int balance=0;// her iki threadde bakiyeyi değiştirmeye çalışıyor.

    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("ogrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }//sonucu görebilmek için
                obj.deposit(500);
            }
        });
        thread2.setName("veli");
        thread2.start();


    }


    //para çekme işlemi için metod oluşturalım
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Bakiyenin güncellenmesini bekliyor.");
            try {
                wait();//Object classının static metodu wait metodu hangi thread üzerinde ise thread geçici olarak beklemeye alınır.
                       //obj nesnesi geçici serbest bırakılıyor.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//bakiye yeterli ise
        if(balance>=amount){
            balance=balance-amount;
            System.out.println("Para çekme işlemi gerçekleşti... Mevcut bakiye : "+balance);
        }else{
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Umudunu kaybetme, yarın yine gel:)");
        }
    }
    //para yatırma metodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor...");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti...Mevcut bakiye:"+balance);
        //bakiye güncelleme yapıldığı için diğer threade haber gönderiyor.
        notify();//obj serbest bırakmaz.
        System.out.println();
        System.out.println("notify metodu çağırılınca hemen kilidi serbest bırakmıyor metodun tamamlanmasını bekler. ");
    }



}
