package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Group;
import model.ModelFacade;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    private ModelFacade facade;

    public void addGroup(Group e) {
        facade.addGroup(e);
    }

    public void bindObserver(ListView o) {
        facade.bindObserver(o);

    }

    public void deleteGroup(Group selectedItem) {
        facade.deleteGroup(selectedItem);
    }

    public void openGroup() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/students_list.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        facade = new ModelFacade();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/groups_list.fxml"));
        Parent root = loader.load();

        GroupController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setTitle("Groups");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}