package MultiThreadings;

public class Threads {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
