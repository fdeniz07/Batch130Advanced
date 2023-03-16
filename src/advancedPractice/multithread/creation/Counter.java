package advancedPractice.multithread.creation;

public class Counter implements Runnable{

    private String name;

    public Counter(String name) {
        this.name = name;
    }


    @Override
    public void run() {


        for (char i='a'; i<='z'; i++){
            System.out.println(this.name + " - " + i);
        }

    }
}
