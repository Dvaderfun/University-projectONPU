package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Group;
import model.ModelFacade;
import model.Student;

import java.io.IOException;

public class Main extends Application {

    private ModelFacade facade;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        facade = new ModelFacade();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/groups_list.fxml"));
        Parent root = loader.load();

        MainController controller = loader.getController();
        controller.setMain(this);

        primaryStage.setTitle("Groups");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void addGroup(Group e) {
        facade.addGroup(e);
    }

    public void bindGroups(ListView o) {
        facade.bindGroups(o);
    }

    public void deleteGroup(Group selectedItem) {
        facade.deleteGroup(selectedItem);
    }

    public void addStudent(Student s, int groupId) {
        facade.addStudent(s, groupId);
    }

    public void deleteStudent(Student selectedItem, int groupId) {
        facade.deleteStudent(selectedItem, groupId);
    }

    public void bindStudents(ListView o) {
        facade.bindStudents(o);
    }

    public void openGroup(int groupId) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/students_list.fxml"));

        Parent root;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        GroupController groupController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Group");
        stage.show();

        groupController.setMain(this);
        groupController.setGroup(groupId);

        facade.updateStudentsList(groupId-1);
    }

    public void openStudentCard(int groupId) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/student_card.fxml"));

        Parent root;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        StudentCardController studentCardController = loader.getController();


        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Add student");
        stage.show();

        studentCardController.setMain(this);
        studentCardController.setGroup(groupId);
    }

}