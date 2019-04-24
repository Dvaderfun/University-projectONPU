package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {

    private Main main;
    private int groupId;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField studentId;

    @FXML
    private DatePicker year;

    @FXML
    private Button saveStudent;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setGroup(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveStudent.setOnAction(event -> {
            Student student = new Student();
            student.setFirstName(firstName.getText());
            student.setLastName(lastName.getText());
            student.setStudentId(Integer.parseInt(studentId.getText()));
            student.setYear(year.getValue().getYear());

            main.addStudent(student, groupId-1);
            closeWindow();
        });
    }

    private void closeWindow(){
        Stage stage = (Stage) saveStudent.getScene().getWindow();
        stage.close();
    }
}