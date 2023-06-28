package MultiThreadings;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BestPriceFinder {
    private static LocalTime start = LocalTime.now();

    public static void main(String[] args) {
        var service = new FlightService();
        List<CompletableFuture<Quotes>> futures = service.getQuotes().peek(quote -> {
            quote.thenAccept(System.out::println);
        }).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    LocalTime end = LocalTime.now();
                    Duration total = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + total.toSeconds() + " seconds");
                });

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
