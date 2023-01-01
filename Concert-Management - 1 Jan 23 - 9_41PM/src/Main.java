import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Taking input from file
        try {
            DataFile.takeInputBandDetails();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            DataFile.takeInputConcertDetails();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Parent root = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("SearchBandPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Concert-Management");
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}