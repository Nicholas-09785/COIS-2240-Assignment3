package application;
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

public class Main extends Application {
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
        Label scene2Label2 = new Label("Add Name");
        
        Label scene3Label1 = new Label("Add ID");
        Label scene3Label2 = new Label("Add Book");
        
        Label scene4Label1 = new Label("Members");
        Label scene4Label2 = new Label("Available Books");
        
        Label scene5Label1 = new Label("Members and their IDs");
        Label scene5Label2 = new Label("Member ID");
        Label scene5Label3 = new Label("Book ID");
        
        Label scene6Label1 = new Label("Names");
        Label scene6Label2 = new Label("IDs");
        Label scene6Label3 = new Label("Choose ID");
        Label scene6Label4 = new Label("Books");
        
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
        		layout7.getChildren().add(new Label(tr));
        	primaryStage.setScene(scene7);
        });
        
        scene2Button.setOnAction(e -> {
        	try {
	        	// If either text boxes arean't put with anything, tell user to enter value
	        	if (scene2Text1.getText().trim().equals("") || scene2Text2.getText().trim().equals("")) {
	        		System.out.println("Enter value");
	        	} else {
	        		Member member = new Member(Integer.parseInt(scene2Text1.getText()), scene2Text2.getText());
	        		if (library.addMember(member) == true) {
	        			names.add(member.getName());
	                   	namesId.add(member.getId());
	        		}
	        		scene2Text1.clear();
	        		scene2Text2.clear();
	                
	        		primaryStage.setScene(scene);
	        	}
        	} catch (IllegalArgumentException fail) {
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
            		if (library.addBook(book) == true) {
            			books.add(book.getTitle());
                       	booksId.add(Integer.toString(book.getId()));
            		}
            		scene3Text1.clear();
            		scene3Text2.clear();
            		
        			primaryStage.setScene(scene);
                } catch (Exception e) {
                	// Output message if exception occurs, telling user that ID must be between 100 and 999
                	System.out.println("ID must be between 100 and 999, and make sure to enter a number, and then a name");
                }
        	}
        });
        
        scene4Button1.setOnAction(e -> {
        	try {
	        	if (scene4Text1.getText().trim().equals(""))
	        		System.out.println("Enter values");
	        	else
	        		primaryStage.setScene(scene4_2);
        	} catch (IllegalArgumentException fail) {
        		System.out.println("Please input a number");
        	}
        });
        
        scene4Button2.setOnAction(e -> {
        	try {
	        	if (scene4Text2.getText().trim().equals(""))
	        		System.out.println("Enter values");
	        	else {
	        		Member member = library.findMemberById(Integer.parseInt(scene4Text1.getText()));
	        		Book book = library.findBookById(Integer.parseInt(scene4Text2.getText()));
	        		
	        		if (member != null && book != null) {
	                	instance.borrowBook(book, member); // Task 2 1., call returnBook using singleton instance
	                	// Remove book, don't care about member                	
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
	        		
	        		primaryStage.setScene(scene6_2);
	        		
	        		if (member != null) {
	        			for (Book bk : member.getBorrowedBooks())
	                        layout6_2.getChildren().add(new Label(bk.getTitle()));
	        		}
	        	}
        	} catch (IllegalArgumentException fail) {
        		System.out.println("Please input a number");
        	}
        		
        });
        
        scene6Button2.setOnAction(e -> {
        	for (int i = 2; i < layout6_2.getChildren().size(); i++)
        		layout6_2.getChildren().remove(i);
        	primaryStage.setScene(scene);
        });
        
        scene7Button1.setOnAction(e -> primaryStage.setScene(scene));
        
        layout.getChildren().addAll(label1, button, button2, button3, button4, button5, button6, button7);
        layout2.getChildren().addAll(scene2Label1, scene2Text1, scene2Label2, scene2Text2, scene2Button);
        layout3.getChildren().addAll(scene3Label1, scene3Text1, scene3Label2, scene3Text2, scene3Button);
        layout4_1.getChildren().addAll(scene4Label1, listViewNames, listViewNamesId, scene4Text1, scene4Button1);
        layout4_2.getChildren().addAll(scene4Label2, listViewBooks, listViewBooksId, scene4Text2, scene4Button2);
        layout5.getChildren().addAll(scene5Label1, namesCopy1, namesIdCopy1, scene5Label2, scene5Text1, scene5Label3, scene5Text2, scene5Button);
        layout6_1.getChildren().addAll(scene6Label1, namesCopy2, scene6Label2, namesIdCopy2, scene6Label3, scene6Text1, scene6Button1);
        layout6_2.getChildren().addAll(scene6Label4, scene6Button2);
        layout7.getChildren().addAll(scene7Label1, scene7Button1, new Label(""));
        
        
        layout.setSpacing(10);
        layout2.setSpacing(10);
        layout3.setSpacing(10);
        layout4_1.setSpacing(10);
        layout4_2.setSpacing(10);
        layout5.setSpacing(10);
        layout6_1.setSpacing(10);
        layout6_2.setSpacing(10);
        layout7.setSpacing(10);
        
        primaryStage.setTitle("CodersLegacy");
        primaryStage.setScene(scene);   
        primaryStage.show();

	}
	
	
	public static void main(String[] args) {
	    launch(args);
	}
}