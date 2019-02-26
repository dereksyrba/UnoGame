/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * This class contains the main method to start the program and allow
 * the user to choose which game type to play.
 * 
 * @author Derek Syrba, John Frocillo, and Adrian Harrell
 */
public class UnoGUI extends Application {
    
    @Override
    public void start(final Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUno.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    /**
     * The main method of the program that gives the user to option
     * between two game types, then launches the game.
     * 
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        
        String[] a = {"Local Game", "AI Game"};
        String input = (String) JOptionPane.showInputDialog(null,
            "Select Game Mode:", "New Game", JOptionPane.QUESTION_MESSAGE,
            null, a, a[0]);
		 	
        if (input == null || input.length() == 0) {
			System.exit(0);
		}

        if (input.equals("Local Game"))	{
            launch(args);
        }

        if (input.equals("AI Game"))	{
            JOptionPane.showMessageDialog(null, 
            		"AI not supported in release 1.0");
            System.exit(0);
        }
       
    }
}
