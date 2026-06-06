public class AdultUser implements LibraryUser {

   private int age;
   private String bookType;

   // Constructor
   public AdultUser() {
   }

   public AdultUser(int age, String bookType) {
      this.age = age;
      this.bookType = bookType;
   }

   // Getters & Setters
   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getBookType() {
      return bookType;
   }

   public void setBookType(String bookType) {
      this.bookType = bookType;
   }

   // Interface Method Implementations
   /*
    * Registers the adult user.
    * Rule: Age must be greater than 12 to qualify as an AdultUser.
    */
   @Override
   public void registerAccount() {
      if (age > 12) {
         System.out.println("You have successfully registered under an Adult Account");
      } else {
         System.out.println("Sorry, Age must be greater than 12 to register as an adult");
      }
   }

   // Rule: AdultUser can only borrow "Fiction" category books (7-day return
   // window).
   @Override
   public void requestBook() {

      if (bookType.equals("Fiction")) {
         System.out.println("Book Issued successfully, please return the book within 7 days");
      } else {
         System.out.println("Oops, you are allowed to take only adult Fiction books");
      }
   }
}
/**
 * AdultUser Class
 *
 * Represents an adult library user (age > 12).
 * Implements the LibraryUser interface with adult-specific rules:
 * - Can only register if age > 12
 * - Can only borrow books of type "Fiction"
 * - Books must be returned within 7 days
 *
 * OOP Concepts Demonstrated:
 * - Interface implementation (implements LibraryUser)
 * - Encapsulation (instance variables with access via setters/getters)
 * - Polymorphism (AdultUser IS-A LibraryUser)
 */