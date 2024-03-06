package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable{
	//creating fields
	public TableView<Book> tableView;
	public TableColumn<Book, String> ColTitle;
	public TableColumn<Book, String> ColFirstname;
	public TableColumn<Book, String> ColLastname;
	public TableColumn<Book, String> Colisbn;

	public TextField textTitle;
	public TextField textfirstName;
	public TextField textLastName;
	public TextField textisbn;
    public ObservableList<Book> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 ColTitle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
		    ColFirstname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
		    ColLastname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getlastName()));
		    Colisbn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getisbn()));


		tableView.setItems(observableList);
	    // Load CSV file and populate the table
        loadCSV("C:\\Users\\16309\\eclipse-workspace\\FirstApplication\\src\\Books(1) (3).csv");
	}//load the csv file
	public void loadCSV(String filePath) {
		String line = "";
		String splitBy = ",";//read the csv file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(splitBy);
                if (fields.length == 4) {
                    String title = fields[0].trim();
                    String firstName = fields[1].trim();
                    String lastName = fields[2].trim();
                    String isbn = fields[3].trim();
                    Book product = new Book(title, firstName, lastName, isbn);
                    tableView.getItems().add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}//these were just testing to see if my array list will display in the table
	ObservableList<Book> observableList = FXCollections.observableArrayList(
			new Book("Introduction to Java", "Daniel", "Liang", "A1234"),
			new Book("Collections in Java", "Peter", "Saint", "5555555"));
	//this add method will accept user input then add it the table then to the csv file
	public void addButton(ActionEvent actionevent) {
		  String title = textTitle.getText();
		    String firstName = textfirstName.getText();
		    String lastName = textLastName.getText();
		    String isbn = textisbn.getText();
		Book Product = new Book(textTitle.getText(), textfirstName.getText(), textLastName.getText(),textisbn.getText());
	tableView.getItems().add(Product);
    writeDataToCSV(title, firstName, lastName, isbn);

	}//it then write to the csv file
	public void writeDataToCSV(String title, String firstName, String lastName, String isbn) {
	    String filePath = "C:\\Users\\16309\\eclipse-workspace\\FirstApplication\\src\\Books(1) (3).csv";

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
	        writer.write(title + "," + firstName + "," + lastName + "," + isbn);
	        writer.newLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}//generate the file report
	public void generateCSVReport(String filePath) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        // Write the header
	        writer.write("Title,First Name,Last Name,ISBN");
	        writer.newLine();

	        // Write the data
	        ObservableList<Book> items = tableView.getItems();
	        for (Book item : items) {
	            writer.write(item.getTitle() + "," + item.getFirstName() + "," + item.getlastName() + "," + item.getisbn());
	            writer.newLine();
	        }

	        System.out.println("CSV report generated successfully.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}//this button triggers the method then gives a path where to save the file.
	public void generateReportButton(ActionEvent actionEvent) {
	    String filePath = "C:\\Users\\16309\\eclipse-workspace\\FirstApplication\\src\\report.csv";
	    generateCSVReport(filePath);
	}
	}




