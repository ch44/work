package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainController extends Registry{
// Register and Login
    @FXML
    private PasswordField RPassword, LPassword, RVPassword;
    @FXML
    private Button RButton, LButton;
    @FXML
    private TextField RName, REmail,LUsername, RUsername,RGender,RAge;
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
	  	

    
    @FXML
    void Register(ActionEvent event) throws Exception{
    	try{
    	Registry nRegistry = new Registry();
    	User u = new User(REmail.getText(),RUsername.getText(),RName.getText(),
				Integer.parseInt(RAge.getText()), RGender.getText(), RPassword.getText());
		
		nRegistry.adding(u);
		nRegistry.write2DB();
    	}
		catch(Exception ie){
ie.printStackTrace();
    }
    
    	
}
    	
    	@FXML
    	public void Login(ActionEvent event2) throws Exception{
    		User n = new User(LUsername.getText(), LPassword.getText());
    		if(VerifyUser(n)== true){
    			try{
    				Stage stage;
    				Parent movies;
    				
    				stage=(Stage)LButton.getScene().getWindow();
    				movies = FXMLLoader.load(getClass().getResource("/application/MovieRating.fxml"));
    				Scene scene = new Scene(movies);
    				stage.setScene(scene);
    				stage.show();
    			}
    			catch (Exception b){
    				System.out.println("Caught IOException: " + b.getMessage());
    			}
    			
    		}
    		
    		
    	  	
    	  	
    	
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}

    	
    	
    	
    	
    	
    	
    	
}