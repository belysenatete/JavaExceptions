/**
 * This file demonstrates various exception handling scenarios in Java
 * Including both checked and unchecked exceptions
 */

import java.io.*;
import java.sql.*;
import java.util.Scanner;

class ExceptionHandling {

    // 1. IOException Example
    public static void IOException() {
        try {
            // Attempting to write to a restricted location
            FileWriter file = new FileWriter("/root/restricted/test.txt");
            file.write("This will fail");
            file.close();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println("IOException demonstration completed");
        }
    }

    // 2. FileNotFoundException Example
    public static void fileNotFoundException() {
        try {
            // Attempting to read a non-existent file
            File file = new File("nonexistent.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException Example
    public static void EOFException() {
        DataInputStream dis = null;
        try {
            // Creating a file with limited content
            FileOutputStream fos = new FileOutputStream("test.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(123);
            dos.close();

            // Trying to read beyond the file's content
            dis = new DataInputStream(new FileInputStream("test.dat"));
            dis.readInt(); // First read succeeds
            dis.readInt(); // This will throw EOFException
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                System.out.println("Error closing stream: " + e.getMessage());
            }
        }
    }

    // 4. SQLException Example
    public static void SQLException() {
        try {
            // Attempting to connect to a non-existent database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nonexistentdb",
                    "username",
                    "password"
            );
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException Example
    public static void classNotFoundException() {
        try {
            // Attempting to load a non-existent class
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // 6. ArithmeticException Example
    public static void arithmeticException() {
        try {
            // Division by zero
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException Example
    public static void nullPointerException() {
        try {
            String str = null;
            // Attempting to call a method on null object
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException Example
    public static void arrayIndexOutOfBoundsException() {
        try {
            int[] arr = new int[5];
            // Attempting to access index 5 (outside array bounds)
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException Example
    public static void classCastException() {
        try {
            Object obj = new Integer(123);
            // Attempting invalid cast
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException Example
    public static void illegalArgumentException() {
        try {
            // Attempting to set negative array size
            int[] arr = new int[-1];
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException Example
    public static void numberFormatException() {
        try {
            // Attempting to parse invalid number
            int number = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Exception Handling Demonstration =====\n");

        IOException();
        fileNotFoundException();
        EOFException();
        SQLException();
        classNotFoundException();
        arithmeticException();
        nullPointerException();
        arrayIndexOutOfBoundsException();
        classCastException();
        illegalArgumentException();
        numberFormatException();
    }
}