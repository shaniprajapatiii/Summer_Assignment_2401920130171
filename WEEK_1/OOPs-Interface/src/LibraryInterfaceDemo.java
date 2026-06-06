import java.util.Scanner;
public class LibraryInterfaceDemo {
   
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      
      KidUser kid = new KidUser();
      AdultUser adult = new AdultUser();

      System.out.println("Enter details for KidUser:");

      System.out.print("Age: ");
      int kidAge = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.print("Book Type: ");
      String kidBookType = sc.nextLine();

      System.out.println("Enter details for AdultUser:");

      System.out.print("Age: ");
      int adultAge = sc.nextInt();
      sc.nextLine(); // Consume newline
      System.out.print("Book Type: ");
      String adultBookType = sc.nextLine();


      // Set details for KidUser
      kid.setAge(kidAge);
      kid.setBookType(kidBookType);

      // Set details for AdultUser
      adult.setAge(adultAge);
      adult.setBookType(adultBookType);

      // Test KidUser
      System.out.println("\nTesting KidUser:");
      kid.registerAccount();
      kid.requestBook();
      
      // Test AdultUser
      System.out.println("\nTesting AdultUser:");
      adult.registerAccount();
      adult.requestBook();
      sc.close();

/*
      // TEST CASE 1: KidUser
      System.out.println("TEST CASE 1 : KidUser");

      KidUser kid = new KidUser();

      // --- Sub-case 1a: Age = 10 (valid) ---
      System.out.println("\n[KidUser] Age = 10");
      kid.setAge(10);
      kid.registerAccount(); // Expected: registered successfully

      System.out.println("\n[KidUser] BookType = \"Kids\"");
      kid.setBookType("Kids");
      kid.requestBook(); // Expected: issued, return in 10 days

      // --- Sub-case 1b: Age = 18 (invalid) ---
      System.out.println("\n[KidUser] Age = 18");
      kid.setAge(18);
      kid.registerAccount(); // Expected: age must be < 12 error

      System.out.println("\n[KidUser] BookType = \"Fiction\"");
      kid.setBookType("Fiction");
      kid.requestBook(); // Expected: only kids books allowed

      // TEST CASE 2: AdultUser
      System.out.println("TEST CASE 2 : AdultUser");

      AdultUser adult = new AdultUser();

      // --- Sub-case 2a: Age = 5 (invalid) ---
      System.out.println("\n[AdultUser] Age = 5");
      adult.setAge(5);
      adult.registerAccount(); // Expected: age must be > 12 error

      System.out.println("\n[AdultUser] BookType = \"Kids\"");
      adult.setBookType("Kids");
      adult.requestBook(); // Expected: only Fiction allowed

      // --- Sub-case 2b: Age = 23 (valid) ---
      System.out.println("\n[AdultUser] Age = 23");
      adult.setAge(23);
      adult.registerAccount(); // Expected: registered successfully

      System.out.println("\n[AdultUser] BookType = \"Fiction\"");
      adult.setBookType("Fiction");
      adult.requestBook(); // Expected: issued, return in 7 days

      System.out.println("ALL TEST CASES DONE");

*/
   }
}



/**
 * LibraryInterfaceDemo
 *
 * Driver class to test all four scenarios as specified in the problem:
 *
 * Test Case 1 — KidUser:
 * - Age 10 → valid kid | BookType "Kids" → valid
 * - Age 18 → invalid kid | BookType "Fiction" → invalid
 *
 * Test Case 2 — AdultUser:
 * - Age 5 → invalid adult | BookType "Kids" → invalid
 * - Age 23 → valid adult | BookType "Fiction" → valid
 *
 * Key OOP Principle demonstrated:
 * Polymorphism — both KidUser and AdultUser are referenced
 * via the LibraryUser interface type, yet each executes its own
 * overridden version of registerAccount() and requestBook().
 */