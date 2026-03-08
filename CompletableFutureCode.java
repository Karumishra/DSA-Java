// https://www.geeksforgeeks.org/completablefuture-in-java/

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCode {
    public static void main(String[] args) {

        // supplyAsync() runs the task in a separate thread and returns a CompletableFuture object immediately
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running task
            sleep(2000);
            return "Hello, CompletableFuture!";
        });

        // Get the result (blocks if not completed)
        String result = future.join();  // or future.get() (throws checked exception)
        System.out.println(result);

        // Chaining multiple transformations
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return 10;
                }).thenApply(fil -> fil * 2) // Transform result
                .thenApply(fil -> fil + 5); // Another transformation

        System.out.println("Final Result: " + future1.join());

        // Running Tasks in Parallel (thenCombine)

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return 20;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return 30;
        });

        CompletableFuture<Integer> combinedFuture = future2.thenCombine(future3, Integer::sum);

        System.out.println("Sum: " + combinedFuture.join());

        // Handling Errors (exceptionally)

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            if (true) throw new RuntimeException("Something went wrong!");
            return 10;
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return 0; // Default value in case of error
        });

        System.out.println("Result: " + future4.join());

        // Running Tasks Without Returning a Value (runAsync)

        CompletableFuture<Void> future5 = CompletableFuture.runAsync(() -> {
            sleep(2000);
            System.out.println("Task completed!");
        });

        future5.join(); // Wait for completion


        // Combining Multiple Futures anyOf

        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            return "Task 1";
        });

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Task 2";
        });

        CompletableFuture<String> firstCompleted = CompletableFuture.anyOf(future6, future7)
                .thenApply(Object::toString);

        System.out.println("First Completed: " + firstCompleted.join());

        // Combining Multiple Futures allOf
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                task("Task 1", 2),
                task("Task 2", 3),
                task("Task 3", 1)
        );

        allTasks.join(); // Wait for all tasks to complete
        System.out.println("All tasks completed!");


    }

    private static CompletableFuture<Void> task(String name, int seconds) {
        return CompletableFuture.runAsync(() -> {
            sleep(seconds * 1000);
            System.out.println(name + " completed");
        });
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
   }


    //Benefits of Completable Future-> Non-blocking execution, Method chaining (thenAccept(), thenApply(), etc.), Built-in exception handling

    //Issues with ExecutorService-> Allows manual thread management, get() is blocking, waiting for the task to complete, No built-in support for chaining or exception handling
}
