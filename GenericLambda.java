import java.util.function.Function;

// Generic class to hold an item of any type T
class Box<T> {
    private T item; 

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    // Method to process the item using a lambda expression
    public <R> R processItem(Function<T, R> processor) {
        return processor.apply(item); 
    }
}

public class GenericLambda {
    // Generic method to process an array of any type T
    public static <T, R> void processArray(T[] array, Function<T, R> processor) {
        for (T element : array) {
            System.out.println("Processed result: " + processor.apply(element));
        }
    }

    public static void main(String[] args) {
        // Create a Box for Integer and process it
        Box<Integer> integerBox = new Box<>(10);
        System.out.println("Integer Box contains: " + integerBox.getItem());
        System.out.println("Doubled value: " + integerBox.processItem(value -> value * 2));

        // Create a Box for String and process it
        Box<String> stringBox = new Box<>("Hello");
        System.out.println("String Box contains: " + stringBox.getItem());
        System.out.println("Uppercase value: " + stringBox.processItem(str -> str.toUpperCase()));

        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "cherry"};

        System.out.println("\nProcessing Integer array:");
        processArray(intArray, value -> value * 3); 

        System.out.println("\nProcessing String array:");
        processArray(strArray, str -> str + " fruit"); 
    }
}
