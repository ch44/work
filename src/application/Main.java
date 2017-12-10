package application;

import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.application.*;

public class Main extends Application{
@Override
public void start(Stage primaryStage) throws Exception{
	try{
		Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		Scene scene = new Scene(root,650,410);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.show();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

public static void main (String[] args){
	launch(args);
}
}


//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Sorting and Filtering");
//
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("PersonTable.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//            Scene scene = new Scene(page);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}