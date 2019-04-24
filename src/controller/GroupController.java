package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupController implements Initializable {
    private Main main;
    private int groupId;

    @FXML
    private Button addStudent;

    @FXML
    private Button removeStudent;

    @FXML
    private ListView listView;

    public void setMain(Main main) {
        this.main = main;
        main.bindStudents(listView);
    }

    public void setGroup(int groupId){
        this.groupId = groupId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addStudent.setOnAction(event -> main.openStudentCard(groupId));
        removeStudent.setOnAction(event -> main.deleteStudent((Student) listView.getSelectionModel().getSelectedItem(), groupId-1));

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (listView.getSelectionModel().getSelectedItem() != null) {
                removeStudent.setDisable(false);
            } else {
                removeStudent.setDisable(true);
            }
        });
    }

    private String getGroupQuantity() {
        return "Students: " + listView.getItems().size();
    }
}