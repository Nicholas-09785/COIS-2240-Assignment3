import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagementTest {

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/	

	// Task 3 1.
	@Test
	public void testBookId() throws Exception {
		try {
			Book book1 = new Book(100, "Math");
			Book book2 = new Book(999, "Science");
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
		try {
			Book book3 = new Book(1000, "History");
			fail("ID must be in between 100 and 999");
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
		try {
			Book book4 = new Book(4, "Engineering");
			fail("ID must be in between 100 and 999");
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
		try {
			Book book5 = new Book(1005, "Art");
			fail("ID must be in between 100 and 999");
		} catch (Exception e) {
			assertEquals("ID must be between 100 and 999", e.getMessage());
		}
	}
	
	// Task 3 2.
	@Test
	public void testBorrowReturn() throws Exception {
		Book testBorrowBook = new Book(101, "English");
		Member testBorrowMember = new Member(19, "David");
		Transaction instance = Transaction.getTransaction();
		
		assertTrue(testBorrowBook.isAvailable());
		
		instance.borrowBook(testBorrowBook, testBorrowMember);
		assertEquals("English", testBorrowMember.getBorrowedBooks().get(0).getTitle()); // Borrow successful
		assertFalse(testBorrowBook.isAvailable()); // Book being available is false
		
		instance.borrowBook(testBorrowBook, testBorrowMember);
		assertFalse(instance.borrowBook(testBorrowBook, testBorrowMember));
		
		
		assertTrue(instance.returnBook(testBorrowBook, testBorrowMember));
		assertFalse(instance.returnBook(testBorrowBook, testBorrowMember));
		
	}

}
