public interface LibraryUser {

   void registerAccount();

   void requestBook();
}

/**
 * LibraryUser Interface
 *
 * This interface defines the contract for all types of library users.
 * Any class that implements this interface MUST provide concrete
 * implementations for both methods declared here.
 *
 * OOP Principle: Abstraction + Polymorphism
 * - We define WHAT to do (not HOW), enabling future extensibility.
 * - New user roles (e.g., TeenUser, SeniorUser) can be added
 * simply by implementing this interface.
 */