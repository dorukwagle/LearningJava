package streams;

import javax.annotation.processing.SupportedSourceVersion;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrimeNumbers {
    public static void main(String[] args) {
        LongPredicate isPrime = num -> {
            if (num < 1)
                return false;
            for (int n=2; n*n<=num; n++){
                if (num%n == 0)
                    return false;
            }
            return true;
        };

//        var values = Stream.iterate(1, n-> ++n);
//        values
////                .limit(100) //check up to this number
//                .filter(isPrime)
//                .limit(40000) //numbers of prime numbers to print
//                .filter(n -> n < 50 || n > 40000)
//                .forEach(System.out::println);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the numbers of primes to print");
        var start = System.nanoTime();
        int maxSize = scan.nextInt();
        long[] all = new long[maxSize];
        long i;
        int count;
        for (i = 1, count = 0; count<maxSize; ++i){
            if(isPrime.test(i))
                all[count++] = i;
        }
        for(int k=0, j=maxSize-1; k<5; k++, j--)
            System.out.println(all[k] + ", " + all[j]);

        var end = System.nanoTime();

        System.out.println("ElapsedTime: " + (double)(end-start)/1e9);

//        System.out.println(x);
    }
}
