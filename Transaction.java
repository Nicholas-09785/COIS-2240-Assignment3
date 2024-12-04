import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {

	// Singleton instance
	private static Transaction instance; // Task 2 1.
	
	// Constructor
	private Transaction() {} // Task 2 1.
	
	// Task 2 1.
	// Singleton method ensures that only one instance of method
	// may be created
	public static Transaction getTransaction() {
		if (instance == null)
			instance = new Transaction();
		return instance;
	}
	
    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            
            // Following line writes to file called transactions.txt
            saveTransaction(transactionDetails); // Task 2 2.
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public boolean returnBook(Book book, Member member) { // Task 3 2., function return type changed from void to boolean
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            
            // Following line writes to file called transactions.txt
            saveTransaction(transactionDetails); // Task 2 2.
            
            return true; // Task 3 2.
        } else {
            System.out.println("This book was not borrowed by the member.");
            return false; // Task 3 2.
        }
    }
    
    // Task 2 2.
    // saveTransaction saves passed parameter to transaction.txt
    private void saveTransaction(String transaction) {
    	try {
    		// Declare variable writer that will write the parameter transaction to transactions.txt
    		BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true));
    		
    		writer.write(transaction + "\n"); // Write transaction and \n character to indent line when finished
    		
    		writer.flush(); // Flush the writer to ensure buffer is empty
    		writer.close(); // Close the writer when finished
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    // Task 2 3.
    // displayTransactionHistory() displays everything in transactions.txt
    public void displayTransactionHistory() {
    	File file = new File("transactions.txt"); // Get transactions.txt
    	if (file.exists()) { // If transactions.txt exist, execute following code
	    	try {
	    		BufferedReader reader = new BufferedReader(new FileReader("transactions.txt")); // Read transactions.txt
	    		String text; // Declare variable text for following while loop
	    		
	    		while ((text = reader.readLine()) != null)
	    			System.out.println(text); // Print each line in transactions.txt, while text isn't null
	    		reader.close(); // Close reader created for reading transactions.txt
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
    	} else { // If transactions.txt doesn't exist, print following line
    		System.out.println("No transactions have been made.");
    	}
    }
    
    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}