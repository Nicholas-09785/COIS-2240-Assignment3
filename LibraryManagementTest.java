import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagementTest {

	// Task 3 1.
	@Test
	public void testBookId() {
		// Used multiple try catch exceptions to account for every book object created for testing
		
		// For boundary cases 100 and 999
		try {
			Book book1 = new Book(100, "Math");
			Book book2 = new Book(999, "Science");
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage()); // Assert confirms what exception message is
																			// thrown by e
		}
		
		// For boundary case 1000
		try {
			Book book3 = new Book(1000, "History");
			fail("ID must be in between 100 and 999");	// Fail thrown due to book id 1000 being passed to Book constructor
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
		
		// For boundary case 4
		try {
			Book book4 = new Book(4, "Engineering");
			fail("ID must be in between 100 and 999");  // Fail thrown due to book id 4 being passed to Book constructor
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
		
		// For boundary case 1005
		try {
			Book book5 = new Book(1005, "Art");
			fail("ID must be in between 100 and 999");  // Fail thrown due to book id 1005 being passed to Book constructor
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
	}
	
	// Task 3 2.
	@Test
	public void testBorrowReturn() throws Exception {
		
		// Book and Member objects declared and initialized with the following passed to their constructors
		Book testBook = new Book(108, "Data");
		Member testMember = new Member(19, "Jack");
		Transaction instance = Transaction.getTransaction();	// Singleton declaration of Transaction declared
		
		// Shows that Book testBook is available
		assertTrue(testBook.isAvailable());
		
		
		// Call borrowBook so that testMember may borrow the Book object testBook
		instance.borrowBook(testBook, testMember);
		assertEquals("Data", testMember.getBorrowedBooks().get(0).getTitle()); // Borrow successful
		
		assertFalse(testBook.isAvailable());	// testBook returns false, due to testBook already being passed
												// to borrowBook function with testMember
		
		
		// Calls borrowBook again, and stores the result of false into boolean variable called res
		boolean res = instance.borrowBook(testBook, testMember);
		assertFalse(res);	// res being false shows that borrowBook was unsuccessful, or returned false
		
		
		// Call returnBook on same objects used as before, called testBook and testMember, and store return value
		// inside the variable res
		res = instance.returnBook(testBook, testMember);
		assertTrue(res);	// res being true shows that returnBook was successful, or returned true
		
		
		// Call returnBook on same objects used as before, called testBook and testMember, and store return value
		// inside the variable res
		res = instance.returnBook(testBook, testMember); 
		assertFalse(res);	// res being false shows that returnBook was unsuccessful on the two passed objects,
							// due to returnBook already being called on those objects
	}
}
