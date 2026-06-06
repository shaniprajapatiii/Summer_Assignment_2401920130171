public class KidUser implements LibraryUser {
   
   private int age;
   private String bookType;
   
   // Constructor
   public KidUser() {
   }
   
   public KidUser(int age, String bookType) {
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
   
   /**
    * Registers the kid user.
    * Rule: Age must be less than 12 to qualify as a KidUser.
   */
  @Override
  public void registerAccount() {
     if (age < 12) {
        System.out.println("You have successfully registered under a Kids Account");
      } 
      else {
         System.out.println("Sorry, Age must be less than 12 to register as a kid");
      }
   }

   /**
    * Handles book borrow request.
    * Rule: KidUser can only borrow "Kids" category books (10-day return window).
   */
  @Override
  public void requestBook() {
     if (bookType.equals("Kids")) {
        System.out.println("Book Issued successfully, please return the book within 10 days");
      } 
      else {
         System.out.println("Oops, you are allowed to take only kids books");
      }
   }
}
/**
 * KidUser Class
 *
 * Represents a child library user (age < 12).
 * Implements the LibraryUser interface with child-specific rules:
 * - Can only register if age < 12
 * - Can only borrow books of type "Kids"
 * - Books must be returned within 10 days
 *
 * OOP Concepts Demonstrated:
 * - Interface implementation (implements LibraryUser)
 * - Encapsulation (instance variables with access via setters/getters)
 * - Polymorphism (KidUser IS-A LibraryUser)
 */