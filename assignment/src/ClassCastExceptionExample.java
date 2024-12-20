public class ClassCastExceptionExample {
    public static void main(String[] args) {
        try {
            Object obj = new String("Hello");
            Integer num = (Integer) obj; // Invalid cast
        } catch (ClassCastException e) {
            System.out.println("ClassCastException occurred: " + e.getMessage());
        }
    }
}



