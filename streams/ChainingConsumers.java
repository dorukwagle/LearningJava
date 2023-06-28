package streams;

import java.util.List;
import java.util.function.Consumer;

public class ChainingConsumers {
    public void show(){
        List<String> list = List.of("a", "iot", "wer");
        Consumer<String> print = System.out::println;
        Consumer<String> again = item -> System.out.println(item.toUpperCase());
        list.forEach(print.andThen(print).andThen(again));
    }
    public static void main(String[] a){
        new ChainingConsumers().show();
    }
}
