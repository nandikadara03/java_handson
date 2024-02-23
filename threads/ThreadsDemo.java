package threads;

public class ThreadsDemo {
    public static void main(String[] args) {
        RThread rThread = new RThread();
        Thread t1  = new Thread(rThread);
        t1.start();


        MyThread dbT = new MyThread("dbThread",10);
        dbT.start();


        MyThread netT = new MyThread("netThread", 100);
        netT.start();

        for(int i=1;i<5;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"-"+i*1000);
        }
    }
}