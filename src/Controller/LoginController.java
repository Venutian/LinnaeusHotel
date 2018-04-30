package Controller;

import Model.Authentication;
import Model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
	
	
	    @FXML
	    private TextField UserName;

	    @FXML
	    private TextField Password;
	    
	    
	    
	
	public void login(ActionEvent event) throws IOException {
		
	
		
		try {
			Authentication aut = new Authentication(UserName.getText().toString(),Password.getText().toString());
			 Employee emp = aut.getEmployee();
			
			 /*to implement. Make a pop up window that says user name or passowrd wrong*/
			 //if(emp == null)
				 
			if(emp.isManager()==1)
				LogManager();
			else
				LogEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Node) (event.getSource())).getScene().getWindow().hide();
			
		
		
	} 
	
	
	private void LogEmployee() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	
	
	private void LogManager() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerWindow.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();

    }

	}


	

