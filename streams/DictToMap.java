package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DictToMap {
    public static List<String> getMap(List dict){
        List<String> map = new ArrayList<>();
        // define some functions to convert dictionary to maps
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBrace = str -> "{" + str + "}";

        for (Object item: dict){
            map.add(
                    replaceColon
                    .andThen(addBrace)
                    .apply((String) item)
            );
        }
        return map;
    }
    public static void main(String[] args) {
        List<String> list = List.of("k:v", "2:mango", "3:kathmandu");

        System.out.println(getMap(list));
    }
}
