import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {

	// Singleton instance
	private static Transaction instance; // 1.
	
	// Constructor
	private Transaction() {} // 1.
	
	// 1.
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
            saveTransaction(transactionDetails); // 2.
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails); // 2.
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }
    
    // 2.
    // saveTransaction saves passed parameter to transaction.txt
    private void saveTransaction(String transaction) {
    	try {
    		BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true));
    		writer.write(transaction + "\n");
    		writer.flush();
    		writer.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}