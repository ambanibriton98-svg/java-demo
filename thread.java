class Count{
    int count = 0;

    public synchronized void increament(){
        count++;

    }
}

public class thread {
    public static void main (String[] arg) throws InterruptedException {
        Count c = new Count();

        Runnable ob1 = () ->
        {
            for (int i=0; i<1000; i++){
                c.increament();
            }
        };
        
        Runnable ob2 = () ->{
            for (int i=0; i<1000; i++){
                c.increament();
            }
        };

        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}