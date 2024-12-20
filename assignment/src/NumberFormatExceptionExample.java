public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("invalidNumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
        }
    }
}

