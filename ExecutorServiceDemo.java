import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// https://medium.com/@vinciabhinav7/concurrency-in-java-executorservice-future-and-callable-f22a7fbeefe2

public class ExecutorServiceDemo {
    public static void main(String args[]) throws ExecutionException, InterruptedException {

    /* The ExecutorService, Future, and Callable are Java concurrency concepts that provide
    a high-level abstraction for executing tasks asynchronously and obtaining their results.
    Concurrency is the ability of a system to manage multiple tasks simultaneously.
    It is essential for improving the performance and responsiveness of the system.  */

    /* An ExecutorService is a utility in Java that provides a way to execute tasks concurrently.
    It manages a pool of worker threads, and allows you to submit tasks for execution.
    The ExecutorService handles creation, management, and reusability of threads,
    making it easier to handle concurrent tasks in multithreaded applications. */

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        ExecutorService executorService2 = Executors.newCachedThreadPool();

        ExecutorService executorService3 = Executors.newFixedThreadPool(2);

        // If you want to schedule a task to run with delay or periodically then you can use ScheduledThreadPoolExecutor class


        executorService1.execute(()-> System.out.println("Executor Service 1"));

        executorService1.shutdown();

        // execute method takes only runnable object and lambda expression as input

        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executor Service 2");
            }
        });

        executorService2.shutdown();

        // submit can take both runnable, callable and lambda expression as input
        // The Future interface represents the result of an asynchronous computation
        // It provides methods to check if the computation is complete, wait for the result, and retrieve the result

        executorService3.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running with thread of Executor Service 3");
            }
        });

        Future<Integer> res = executorService3.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10+1;
            }
        });

        if(res.isDone())
        {
            System.out.println(res.get());
        }

        System.out.println(res.get());

        // We can invoke shutdown() method to finish execution of all the submitted tasks and terminate the thread pool
        executorService3.shutdown();
    }
}