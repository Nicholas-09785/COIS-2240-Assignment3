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
}
