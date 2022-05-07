import java.util.Arrays;
import java.util.concurrent.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 05.05.2022
 * \* ----- group JAVA-27 -----
 * \*
 * \* Description: Домашнее задание к занятию 1.1 Многопоточное (параллельное) программирование. Работа с потоками
 * \* Задача: Задача 2. Межпоточный диалог со счетчиком
 * \
 */
public class MultithreadingdialogWithCounter {

    public static void main(String[] args) {
        System.out.println("Создаю потоки...");
        Callable<Integer> myCallable1 = new MyMultithreading("Поток 1");
        Callable<Integer> myCallable2 = new MyMultithreading("Поток 2");
        Callable<Integer> myCallable3 = new MyMultithreading("Поток 3");
        Callable<Integer> myCallable4 = new MyMultithreading("Поток 4");
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);
        try {
            System.out.println(myCallable1 + " выполнил задачу " + task1.get() + " раз.");
            System.out.println(myCallable2 + " выполнил задачу " + task2.get() + " раз.");
            System.out.println(myCallable3 + " выполнил задачу " + task3.get() + " раз.");
            System.out.println(myCallable4 + " выполнил задачу " + task4.get() + " раз.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Integer result = threadPool.invokeAny(Arrays.asList(myCallable1, myCallable2, myCallable3, myCallable4));
            System.out.println("Результат самой быстрой задачи " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Завершаю все потоки...");
        threadPool.shutdown();
    }
}