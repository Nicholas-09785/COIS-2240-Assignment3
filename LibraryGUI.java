
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

// How to use:
// Add member: Specify ID on the top text field, and name at bottom. When finished click the button.
// Add book: Specify ID on the top text field, and book title at bottom. When finished click the button.

// Borrow book:
// On first page, the top box shows names, while bottom box shows their respective IDs. For instance,
// if the second row in the top box shows the name 'Tyler', and the second row in the bottom box shows the number '203',
// then Tyler's ID is 203. In the text field, put in the desired ID.
// On the second page, the top box shows book titles, while bottom box shows their respective IDs, analogously to before.
// In the text field, input the desired book ID and click the following button to confirm and return to the starting page.

// Return book:
// The top box shows names, while the bottom box shows their respective IDs. Input the ID of the member and
// the ID of the book they have so that it may be returned.

// View borrowed book:
// The top box shows names, while the bottom box shows their respective IDs. Input one's ID before clicking on the
// following button to continue. A box should appear with the names of each book the member currently has borrowed.

// View transaction history:
// A page should appear showing the most recent transactions, based on the lines stored in the file that is local
// in the same file path called transactions.txt.

public class LibraryGUI extends Application {
	// Declare library and instance objects for Library and singleton support
	private Library library = new Library();
	Transaction instance = Transaction.getTransaction();
    
	// Modified version of displayTransactionHistory, for this GUI
    private List<String> displayTransactionHistory() {
    	File file = new File("transactions.txt"); // Get transactions.txt
    	List<String> transactions = new ArrayList<String>();
    	
    	if (file.exists()) { // If transactions.txt exist, execute following code
	    	try {
	    		BufferedReader reader = new BufferedReader(new FileReader("transactions.txt")); // Read transactions.txt
	    		String text; // Declare variable text for following while loop
	    		
	    		while ((text = reader.readLine()) != null)
	    			transactions.add(text); // Print each line in transactions.txt, while text isn't null
	    		reader.close(); // Close reader created for reading transactions.txt

	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
    	}
    	return transactions;
    }

	public void start(Stage primaryStage) {
		
		// Declare and initialize all VBox objects
		VBox layout = new VBox();
        VBox layout2 = new VBox();
        VBox layout3 = new VBox();
        VBox layout4_1 = new VBox();
        VBox layout4_2 = new VBox();
        VBox layout5 = new VBox();
        VBox layout6_1 = new VBox();
        VBox layout6_2 = new VBox();
        VBox layout7 = new VBox();
        
        // Ensure that, for each layout, everything appears mainly in center of window
        layout.setAlignment(Pos.CENTER);
        layout2.setAlignment(Pos.CENTER);
        layout3.setAlignment(Pos.CENTER);
        layout4_1.setAlignment(Pos.CENTER);
        layout4_2.setAlignment(Pos.CENTER);
        layout5.setAlignment(Pos.CENTER);
        layout6_1.setAlignment(Pos.CENTER);
        layout6_2.setAlignment(Pos.CENTER);
        layout7.setAlignment(Pos.CENTER);
     
        // Declare each scene to be used for GUI, using layouts from before
        Scene scene = new Scene(layout, 600, 600);
        Scene scene2 = new Scene(layout2, 600, 600);
        Scene scene3 = new Scene(layout3, 600, 600);
        Scene scene4_1 = new Scene(layout4_1, 600, 600);
        Scene scene4_2 = new Scene(layout4_2, 600, 600);
        Scene scene5 = new Scene(layout5, 600, 600);
        Scene scene6_1 = new Scene(layout6_1, 600, 600);
        Scene scene6_2 = new Scene(layout6_2, 600, 600);
        Scene scene7 = new Scene(layout7, 600, 600);
        
        // Declare all labels, with extra lines added to indicate different scenes
        Label label1 = new Label("Library Managment System");
        
        Label scene2Label1 = new Label("Add ID");
        Label scene2Label2 = new Label("Add name");
        
        Label scene3Label1 = new Label("Add ID");
        Label scene3Label2 = new Label("Add book");
        
        Label scene4Label1 = new Label("Members and their IDs");
        Label scene4Label2 = new Label("Input ID");
        Label scene4Label3 = new Label("Available books and their IDs");
        Label scene4Label4 = new Label("Input ID");
        
        Label scene5Label1 = new Label("Members and their IDs");
        Label scene5Label2 = new Label("Member ID");
        Label scene5Label3 = new Label("Book ID");
        
        Label scene6Label1 = new Label("Members and their IDs");
        Label scene6Label2 = new Label("Choose ID");
        Label scene6Label3 = new Label("Books");
        
        Label scene7Label1 = new Label("Transaction History:");
        
        // Button objects declared for main GUI scene
        Button button = new Button("Add member");
        Button button2 = new Button("Add book");
        Button button3 = new Button("Borrow book");
        Button button4 = new Button("Return book");
        Button button5 = new Button("View borrowed book");
        Button button6 = new Button("View transaction history");
        Button button7 = new Button("Exit");
        
        // Extra scene buttons created, with extra lines indicating different scenes
        Button scene2Button = new Button("Add ID and Name");
        
        Button scene3Button = new Button("Add ID and Book");
        
        Button scene4Button1 = new Button("View books");
        Button scene4Button2 = new Button("Borrow");
        
        Button scene5Button = new Button("Leave");
        
        Button scene6Button1 = new Button("Next");
        Button scene6Button2 = new Button("Leave");
        
        Button scene7Button1 = new Button("Leave");
        
        // TextField objects created, with extra lines indicating different scenes
        TextField scene2Text1 = new TextField();
        TextField scene2Text2 = new TextField();
        
        TextField scene3Text1 = new TextField();
        TextField scene3Text2 = new TextField();
        
        TextField scene4Text1 = new TextField();
        TextField scene4Text2 = new TextField();
        
        TextField scene5Text1 = new TextField();
        TextField scene5Text2 = new TextField();
        
        TextField scene6Text1 = new TextField();
        
        // ObservableList objects created to hold Member names and IDs
        ObservableList<String> names = FXCollections.observableArrayList();
        ObservableList<Integer> namesId = FXCollections.observableArrayList();
        
        // ObservableList objects created as List for preceding ObservableList objects
        ListView<String> listViewNames = new ListView<String>(names);
        ListView<Integer> listViewNamesId = new ListView<Integer>(namesId);
        listViewNames.setMaxSize(200, 160);	// Declares width and height for ListView as boxes
        listViewNamesId.setMaxSize(200, 160);
        
        // ObservableList objects created to hold Member names and IDs
        ObservableList<String> books = FXCollections.observableArrayList();
        ObservableList<String> booksId = FXCollections.observableArrayList();
        
        // ObservableList objects created as List for preceding ObservableList objects
        ListView<String> listViewBooks = new ListView<String>(books);
        ListView<String> listViewBooksId = new ListView<String>(booksId);
        listViewBooks.setMaxSize(200, 160);
        listViewBooksId.setMaxSize(200, 160);

        // Copies of preceding ListView objects created to be used for different scenes
        ListView<String> namesCopy1 = new ListView<String>(names);
        ListView<String> namesCopy2 = new ListView<String>(names);
        ListView<Integer> namesIdCopy1 = new ListView<Integer>(namesId);
        ListView<Integer> namesIdCopy2 = new ListView<Integer>(namesId);
        namesCopy1.setMaxSize(200, 160);
        namesCopy2.setMaxSize(200, 160);
        namesIdCopy1.setMaxSize(200, 160);
        namesIdCopy2.setMaxSize(200, 160);
        
        ObservableList<String> show = FXCollections.observableArrayList();
        ListView<String> showValues = new ListView<String>(show);
        showValues.setMaxSize(200, 160);
        
        ObservableList<String> trHist = FXCollections.observableArrayList();
        ListView<String> transactions = new ListView<String>(trHist);
        transactions.setMaxSize(500, 160);

        // Following shows what each button does when clicked, mainly switching scenes
        button.setOnAction(e -> primaryStage.setScene(scene2));
        button2.setOnAction(e -> primaryStage.setScene(scene3));
        button3.setOnAction(e -> primaryStage.setScene(scene4_1));
        button4.setOnAction(e -> primaryStage.setScene(scene5));
        button5.setOnAction(e -> primaryStage.setScene(scene6_1));
        button7.setOnAction(e -> Platform.exit());
        

        // The following buttons do more, and thus are used with bodies of code to
        // account for their complexity
        button6.setOnAction(e -> {
        	
        	// I couldn't use displayTransactionHistory from Transaction.java because it doesn't return 
        	// String, only prints to console. Modified version of the function is shown above.
        	for (String tr : displayTransactionHistory())
        		trHist.add(tr);
        	primaryStage.setScene(scene7);
        });
        
        scene2Button.setOnAction(e -> {
        	
        	// try-catch block used for each input in case user enters incorrect character types, such as when an ID is
        	// entered with a letter
        	try {
	        	// If either text boxes arean't put with anything, tell user to enter value
	        	if (scene2Text1.getText().trim().equals("") || scene2Text2.getText().trim().equals("")) {
	        		System.out.println("Enter value");
	        	} else {
	        		// Create Member object to pass input values
	        		Member member = new Member(Integer.parseInt(scene2Text1.getText()), scene2Text2.getText());
	        		
	        		// If member may be added from ID not being taken, do following
	        		if (library.addMember(member) == true) {
	        			names.add(member.getName());	// add to names list
	                   	namesId.add(member.getId());	// add to namedID list
	        		}
	        		
	        		// Clear output
	        		scene2Text1.clear();
	        		scene2Text2.clear();
	                
	        		primaryStage.setScene(scene);	// Go back to main page
	        	}
        	} catch (IllegalArgumentException fail) {	// Exception specifying that wrong data type was given as input
        		System.out.println("Please input a number, then a name");
        	}
        });
        
        scene3Button.setOnAction(f -> {
        	if (scene3Text1.getText().trim().equals("") || scene3Text2.getText().trim().equals("")) {
        		System.out.println("Enter values");
        	} else {
        		try {
                	// Book now added as created object without variable declaration
        			Book book = new Book(Integer.parseInt(scene3Text1.getText()), scene3Text2.getText());
        			
        			// If book may be added from ID not being taken, do following
            		if (library.addBook(book) == true) {
            			books.add(book.getTitle());		// Add book's title to books array
                       	booksId.add(Integer.toString(book.getId()));	// Add book's ID to booksID array
            		}
            		scene3Text1.clear();
            		scene3Text2.clear();
            		
        			primaryStage.setScene(scene);
        			
                } catch (Exception e) {	// This catch also handles when user inputs incorrect data types
                	
                	// Output message if exception occurs, telling user that ID must be between 100 and 999
                	System.out.println("ID must be between 100 and 999, and make sure to enter a number, and then a name");
                }
        	}
        });
        
        scene4Button1.setOnAction(e -> {
        	try {
	        	if (scene4Text1.getText().trim().equals("")) // Input box is empty on click event tells user to give input
	        		System.out.println("Enter values");
	        	else {
	        		Member member = library.findMemberById(Integer.parseInt(scene4Text1.getText())); // Ensures exception 
	        																						 // may be thrown
	        		primaryStage.setScene(scene4_2);
	        	}
        	} catch (IllegalArgumentException f) { 
        		System.out.println("Please input a number");
        	}
        });
        
        scene4Button2.setOnAction(e -> {
        	try {
	        	if (scene4Text2.getText().trim().equals(""))
	        		System.out.println("Enter values");
	        	else {
	        		// Declare member and book using their finding methods to find the correct books based on user's input
	        		Member member = library.findMemberById(Integer.parseInt(scene4Text1.getText()));
	        		Book book = library.findBookById(Integer.parseInt(scene4Text2.getText()));
	        		
	        		if (member != null && book != null) { // If books found
	                	instance.borrowBook(book, member); // Call returnBook using singleton instance
	                	// Remove book from books and booksID             	
	                	books.remove(book.getTitle());
	                	booksId.remove(Integer.toString(book.getId()));
	                } else {
	                    System.out.println("Invalid member or book ID.");
	                }
	        		
	        		scene4Text1.clear();
	        		scene4Text2.clear();
	        		
	        		primaryStage.setScene(scene);
	        	}
        	} catch (IllegalArgumentException fail) {
        		System.out.println("Please input a number");
        	}
        });
        
        scene5Button.setOnAction(e -> {
        	try {
	        	if (scene5Text1.getText().trim().equals("") || scene5Text2.getText().trim().equals(""))
	        		System.out.println("Enter values");
	        	else {
	        		Member member = library.findMemberById(Integer.parseInt(scene5Text1.getText()));
	        		Book book = library.findBookById(Integer.parseInt(scene5Text2.getText()));
	        		
	        		if (member != null && book != null) {
	                	instance.returnBook(book, member);
	                	books.add(book.getTitle());
	                	booksId.add(Integer.toString(book.getId()));
	                } else {
	                    System.out.println("Invalid member or book ID.");
	                }
	        		
	        		primaryStage.setScene(scene);	
	        	}
        	} catch (IllegalArgumentException fail) {
        		System.out.println("Please input a number, then another number");
        	}
        });
        
        scene6Button1.setOnAction(e -> {
        	try {
	        	if (scene6Text1.getText().trim().equals(""))
	        		System.out.println("Enter values");
	        	else {
	        		Member member = library.findMemberById(Integer.parseInt(scene6Text1.getText()));
	        		
	        		primaryStage.setScene(scene6_2); // Rather than going back to title screen, go to scene6_2
	        		
	        		if (member != null) {
	        			for (Book bk : member.getBorrowedBooks())
	                        show.add(bk.getTitle());
	        		}
	        	}
        	} catch (IllegalArgumentException fail) {
        		System.out.println("Please input a number");
        	}
        });
        
        scene6Button2.setOnAction(e -> {
        	show.removeAll(show); // Remove all elements from show right before leaving
        	primaryStage.setScene(scene);
        });
        
        scene7Button1.setOnAction(e -> {
        	trHist.removeAll(trHist);
        	primaryStage.setScene(scene);
        });
        
        layout.getChildren().addAll(label1, button, button2, button3, button4, button5, button6, button7);
        layout2.getChildren().addAll(scene2Label1, scene2Text1, scene2Label2, scene2Text2, scene2Button);
        layout3.getChildren().addAll(scene3Label1, scene3Text1, scene3Label2, scene3Text2, scene3Button);
        layout4_1.getChildren().addAll(scene4Label1, listViewNames, listViewNamesId, scene4Label2, scene4Text1, scene4Button1);
        layout4_2.getChildren().addAll(scene4Label3, listViewBooks, listViewBooksId, scene4Label4, scene4Text2, scene4Button2);
        layout5.getChildren().addAll(scene5Label1, namesCopy1, namesIdCopy1, scene5Label2, scene5Text1, scene5Label3, scene5Text2, scene5Button);
        layout6_1.getChildren().addAll(scene6Label1, namesCopy2, namesIdCopy2, scene6Label2, scene6Text1, scene6Button1);
        layout6_2.getChildren().addAll(scene6Label3, scene6Button2, showValues);
        layout7.getChildren().addAll(scene7Label1, transactions, scene7Button1);
        
        layout.setSpacing(10);
        layout2.setSpacing(10);
        layout3.setSpacing(10);
        layout4_1.setSpacing(10);
        layout4_2.setSpacing(10);
        layout5.setSpacing(10);
        layout6_1.setSpacing(10);
        layout6_2.setSpacing(10);
        layout7.setSpacing(10);

        primaryStage.setScene(scene);   
        primaryStage.show();
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	}
}