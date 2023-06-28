package MultiThreadings;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public static void simulateRandom(){
        long time = 2 + (int) (Math.random() * 3);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    we cannot simply return the Quotes because that would be synchronized process
//    so return completable future instead

    public Stream<CompletableFuture<Quotes>> getQuotes(){
        List<String> sites = List.of("site1", "site2", "site3");
        return sites.stream().map(this::getQuote);
    }

    public CompletableFuture<Quotes> getQuote(String site){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);
            FlightService.simulateRandom();
            var price = 100 + new Random().nextInt(100);
            return new Quotes(site, price);
        });
    }
}
