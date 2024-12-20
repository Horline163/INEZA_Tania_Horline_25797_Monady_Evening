import java.io.*;

public class EOFExceptionExample {
    public static void main(String[] args) {
        try (DataInputStream input = new DataInputStream(new FileInputStream("emptyfile.txt"))) {
            while (true) {
                input.readInt(); // Triggers EOFException if no more data.
            }
        } catch (EOFException e) {
            System.out.println("EOFException occurred: Reached end of file.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}

