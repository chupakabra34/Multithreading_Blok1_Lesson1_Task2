import java.util.concurrent.Callable;

import static java.lang.System.out;

public class MyMultithreading implements Callable<Integer> {
    String name;

    public MyMultithreading(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Integer rezult = 0;
        Thread.currentThread().setName(name);

        Thread.sleep(1000);
        out.println("Я " + Thread.currentThread().getName() + " передаю привет преподавателю " + "\u263a");
        rezult++;

        return rezult;
    }
}

