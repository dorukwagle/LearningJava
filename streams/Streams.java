package streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Supplier<Double> ds = Math::random;
        Stream<Double> random = Stream.generate(ds);
//        random.map(m -> m/2).limit(5).forEach(System.out::println);
        random.filter(num -> ( num.byteValue()*100)/2==0 ).limit(5).forEach(System.out::println);

        var lsts = Stream.of(List.of(1,2,3,4,5), List.of(33,22,32,332,12));
        lsts.flatMap(Collection::stream).forEach(System.out::println);

        Stream.iterate(1, currentValue -> currentValue+1)
                .limit(10).filter(value -> value%2==0)
                .map(num -> num * num)
                        .forEach(System.out::println);

    }
}
