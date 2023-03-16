package advancedPractice.multithread.creation;

public class ThreadCreation03 {

    //Task 4 : anoymous class ile hread olusumu
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Fare");
                String name = Thread.currentThread().getName();
                for (int i = 1; i <= 100; i++) {
                    System.out.println(name + " : kaciyorum... ");
                }
            }
        });


        //Task 5 : Lambda expression ile thread olusturulim

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("Kedi");
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 100; i++) {
                System.out.println(name + " : yakalayacagim... ");
            }
        });

        thread1.start();
        thread2.start();

    }
}
