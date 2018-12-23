import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Thread #" + Thread.currentThread().getName();
            }
        };

        Task<String> task = new Task<>(callable);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                try {
                    String s = task.get();
                    System.out.println(s);
                } catch (MyException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}
