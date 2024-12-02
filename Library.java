import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public boolean addMember(Member member) {
    	// Following if statement checks if the size of the members list is greater than 0 and if another member with the
    	// same id exists, if so add member
    	if (members.size() > 0 && findMemberById(member.getId()) != null) { // Task 2 4., changed in 5.
    		System.out.println("Member id is already taken");
    		return false;
    	}
    	else {
    		System.out.println("Member added successfully.");
    		members.add(member);
    		return true;
    	}
    }
    
    // Add a new book to the library
    public boolean addBook(Book book) {
    	// Following if statement checks if the size of the members list is greater than 0 and if another member with the
    	// same id exists, if so add book
    	if (books.size() > 0 && findBookById(book.getId()) != null) { // Task 2 4., changed in 5.
    		System.out.println("Book id is already taken");
    		return false;
    	}
    	else {
    		System.out.println("Book added to library successfully.");
    		books.add(book);
    		return true;
    	}
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
