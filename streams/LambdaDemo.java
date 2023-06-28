package streams;

public class LambdaDemo{

    public static void greet(Printer printer){
        printer.print("Hello world printer");
    }

    public static void doubleGreet(String  message){
        System.out.println("hello double printer");
        System.out.println("hello double printer 2");
    }

    public void display(String message){
        System.out.println("this is displaying the message");
    }

    public static void main(String[] args){
        // Using Anonymous class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // Using lambda function
        greet(message -> System.out.println("hello lambda message"));

        // Using method reference
        greet(System.out::println);
        greet(LambdaDemo::doubleGreet);
        greet(new LambdaDemo()::display);
    }
}
