import java.util.logging.Logger;

// https://www.geeksforgeeks.org/java-lang-thread-class-java/
public class ThreadDemo extends Thread {

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void run() {
        logger.info("Inside run method");
    }

    public static void main(String arg[]) throws InterruptedException {
        ThreadDemo threadDemo1 = new ThreadDemo();
        threadDemo1.start();
        System.out.println(threadDemo1.getId());
        System.out.println(threadDemo1.getName());
        System.out.println(threadDemo1.getClass());
        System.out.println(threadDemo1.getPriority());
        System.out.println(threadDemo1.getState());
        Thread.sleep(1000);
        System.out.println(threadDemo1.getContextClassLoader());
        System.out.println(threadDemo1.getStackTrace());
        System.out.println(threadDemo1.getThreadGroup());
        System.out.println(threadDemo1.isAlive());
        System.out.println(threadDemo1.isDaemon());
        System.out.println(threadDemo1.isInterrupted());
        threadDemo1.setName("Thread-100");
        threadDemo1.setPriority(10);
        System.out.println(threadDemo1.getName());
        System.out.println(threadDemo1.getPriority());

        ThreadDemo threadDemo2 = new ThreadDemo();
        System.out.println(threadDemo2.getId());
        System.out.println(threadDemo2.getName());
        System.out.println(threadDemo2.getPriority());
        System.out.println(threadDemo2.getState());
        System.out.println(Thread.activeCount());
        threadDemo2.interrupt();
        System.out.println(threadDemo2.isInterrupted());
        System.out.println(threadDemo2.isAlive());
        System.out.println(Thread.currentThread());
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }

}