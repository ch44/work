package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MovieController {
    
//  @FXML 
//  void Login(ActionEvent event) throws Exception{
//  	try{
//  		Registry lRegistry = new Registry();
//  	
//  		boolean login = lRegistry.VerifyUser(LUsername.getText(), LPassword.getText());
//  		if(login){
//	Parent movies = FXMLLoader.load(getClass().getResource("/application/MovieRating.fxml"));
//	Stage primaryStage = new Stage();
//	primaryStage.setTitle("MovieRatings");
//	Scene movieView = new Scene(movies);
//	
//	primaryStage.setScene(movieView);
//	primaryStage.show();
//  		
//  		}
//  	}
//  	catch(Exception ie){
//  		ie.printStackTrace();
//  		    }
//
//}
  	
  	/*
  	
  	//Table
  	@FXML
  	TableView <Table>tableId;
  	@FXML
  	TableColumn<Table, Integer>iId;
  	@FXML
  	TableColumn<Table, String> iName;
  	@FXML
  	TableColumn<Table, String> iDate;
  	@FXML
  	TableColumn<Table, Integer> iPrice;
  	
  	
  	//Form
  	@FXML
  	@TextField nameInput;
  	@FXML
  	TextField dateInput;
  	@FXML
  	TextField priceInput;
  	@FXML
  	Button submit;
  	
  	//Variable
  	private int iNumber = 1;
  	
  	
  	//create table data
  	final ObservableList<Table> data = FXCollections.observableArrayList(
  			new Table(iNumber++, "Name 1", "01/01/2012", 50),
  			new Table(iNumber++, "Name 2", "12/05/2012", 60),
  			new Table(iNumber++, "Name 3", "20/12/2013", 150));
  	
  	
  	@Override 
  	public void initialize(URL location, ResourceBundle resources){
  		iId.setCellValueFactory(new PropertyValueFactory<Table, Integer>("rID"));
  		iName.setCellValueFactory(new PropertyValueFactory<Table, String>("rName"));
  		iDate.setCellValueFactory(new PropertyValueFactory<Table, String>("rDate"));
  		iId.setCellValueFactory(new PropertyValueFactory<Table, Integer>("rPrice"));
  		
  		tableID.setItems(data);
  	}
  	public void onAddItem(ActionEvent event){
  		//adding and updating data
  		Table entry = new Table(iNumber, nameInput.getText(), dateInput.getText(), Integer.parseInt(priceInput.getText());
  		iNumber++;
  		
  		//insert data into table
  		data.add(entry);
  		
  		//clears TextField
  		clearForm();
  	}
  	private void clearForm(){
  		nameInput.clear();
  		dateInput.clear();
  		priceInput.clear();
  	}
  	*/
  	@FXML
  	private TextField searchBar;
  	@FXML
  	private TableView<MovieInfo>personTable;
  	@FXML 
  	private TableColumn<MovieInfo, String> MTitle;
  	@FXML 
  	private TableColumn<MovieInfo, String> MGenre;
  	@FXML 
  	private TableColumn<MovieInfo, String> MYear;
  	@FXML 
  	private TableColumn<MovieInfo, String> MRating;
  	
  	private ObservableList<MovieInfo> tableData = FXCollections.observableArrayList();
  	
  	
  	// adding data in constructor
  	
  	
  	public MovieController() {
  		tableData.add(new MovieInfo("Toy Story", "Animation", "1995", "8.3"));
  		tableData.add(new MovieInfo("Jumanji", "Adventure", "1995", "6.9"));
  		tableData.add(new MovieInfo("X-Men", "Sci-Fi", "2000", "7.4"));
  		tableData.add(new MovieInfo("102 Dalmations", "Childrens", "2000", "4.9"));
  		tableData.add(new MovieInfo("Beverly Hills Cop", "Action", "1984","7.3"));
  		tableData.add(new MovieInfo("Memento", "Thriller", "2000", "8.5"));
  		tableData.add(new MovieInfo("Spy Kids", "Sci-Fi", "2001", "5.4"));
  		tableData.add(new MovieInfo("Fast and Furious", "Action", "2001", "6.7"));
  		tableData.add(new MovieInfo("A.I. Artificial Intelligence", "Sci-Fi", "2001", "7.1"));
  		tableData.add(new MovieInfo("Hush", "Thriller", "1998", "5.3"));
  	}
  	
  	/**
  	 * Initializes the controller class. This method is automatically called
  	 * after the fxml file has been loaded.
  	 * 
  	 * Initializes the table columns and sets up sorting and filtering.
  	 */
  	// 0. Initialize the columns.
  	@FXML
  	private void initialize() {
  		MTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
  		MGenre.setCellValueFactory(cellData -> cellData.getValue().genreProperty());
  		MYear.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
  		MRating.setCellValueFactory(cellData -> cellData.getValue().ratingProperty());
  		
  		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
  		FilteredList<MovieInfo> filteredData = new FilteredList<>(tableData, p -> true);
  		
  		// 2. Set the filter Predicate whenever the filter changes.
  		searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
  			filteredData.setPredicate(person -> {
  				// If filter text is empty, display all persons.
  				if (newValue == null || newValue.isEmpty()) {
  					return true;
  				}
  				
  				// Compare first name and last name of every person with filter text.
  				String lowerCaseFilter = newValue.toLowerCase();
  				
  				if (person.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
  					return true; // Filter matches first name.
  				} else if (person.getGenre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
  					return true; // Filter matches last name.
  				}
  				else if (person.getYear().toLowerCase().indexOf(lowerCaseFilter) != -1) {
  					return true; // Filter matches last name.
  				}
  				else if (person.getRating().toLowerCase().indexOf(lowerCaseFilter) != -1) {
  					return true; // Filter matches last name.
  				}
  				return false; // Does not match.
  			});
  		});
  		
  		// 3. Wrap the FilteredList in a SortedList. 
  		SortedList<MovieInfo> sortedData = new SortedList<>(filteredData);
  		
  		// 4. Bind the SortedList comparator to the TableView comparator.
  		// 	  Otherwise, sorting the TableView would have no effect.
  		sortedData.comparatorProperty().bind(personTable.comparatorProperty());
  		
  		// 5. Add sorted (and filtered) data to the table.
  		personTable.setItems(sortedData);
  	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
}
