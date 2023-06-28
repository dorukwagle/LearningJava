package streams;

import java.util.function.Predicate;

public class Predicates {
    public static void display(){
        Predicate<String> hasCloseBrace = str -> str.endsWith("}");
        Predicate<String> hasOpenBrace = str -> str.startsWith("{");
        Predicate<String> hasBothBraces = hasOpenBrace.and(hasCloseBrace);

        // testing
        boolean result = hasCloseBrace.test("hello");
        System.out.println(result);

        result = hasOpenBrace.test("{hello");
        System.out.println(result);

        result = hasBothBraces.test("{this is good}");
        System.out.println(result);

        result = hasOpenBrace.and(hasCloseBrace).test("{hello}");
        System.out.println(result);

        result = hasBothBraces.negate().and(hasOpenBrace).test("{help help");
        System.out.println(result);
    }

    public static void main(String[] args) {
        display();
    }
}
