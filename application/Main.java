/*
 * Christian Santos

 * date: 5/19/2023
 * purpose:  application should allow library staff to
- Add: Library staff to add book information
o Book data -> Title, Author first name, Author last name, ISBN code (5 digit code)
- Report : Allow library staff to report the list of books. (in a list view)
- Save: The software should save the updated BOOK data to book.csv. If file does not exist, please
save to a new ‘book.csv’ file from the application. If file exists, then please append.
- Load: Every time the software starts, the BOOK information should be loaded from book.csv
Comma-separated-value (csv) is a popular format for storing data. It can be opened and edited
in notepad/ excel. CSV file can be opened in notepad and edited. Each line contains data for a
book, with the field values separated by comma (delimiter). this application includes an fxml for further user-interface and java for
Functionalities. the program will display the csv file in the table. accept user input and event action button of add to add the data. 
the data itself is already saved to the csv file. then theres a report button for csv file report saved in the same folder. 
 */
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/BookApp.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
/*In conclusion: I really enjoyed doing this project. I have to say thank you for always being a generous professor and very understanding of my situation.
I'm really sad that i had to miss a couple of your in class lectures. They were were one thing throughout my week I have always look forward to and to have the opportunity to be taught from one of the best.
throughout the past weeks, I have been having to push myself mentally because I really want to do my best. I've read chapters after chapters. I've watches videos after videos, and lectures after lectures.
I really questioned myself if I was fit to do this project after so much adversity but I'm really happy that I didn't give up because i had to keep redoing this  project multiple times and kept my confidence.
Thank you for the semester, and I hope to visit you soon in the next semester. 

*/