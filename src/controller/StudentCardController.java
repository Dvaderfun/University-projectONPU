package controller;

import exception.IncorrectDataException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.ContractStudent;
import model.Student;

import java.net.URL;
import java.time.chrono.Chronology;
import java.util.ResourceBundle;

public class StudentCardController implements Initializable {

    private Main main;
    private int groupId;
    private Student student;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField studentId;

    @FXML
    private DatePicker year;

    @FXML
    private CheckBox contractCheckBox;

    @FXML
    private TextField semesterCost;

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
        addTextLimiter(studentId, 6);
        student = new Student();

        contractCheckBox.setOnAction(event -> {
                    if (!contractCheckBox.isSelected()) {
                        student = new Student();
                        semesterCost.setDisable(true);
                    } else {
                        student = new ContractStudent();
                        semesterCost.setDisable(false);
                    }
                });

        saveStudent.setOnAction(event -> {
            if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || studentId.getText().isEmpty() || (student instanceof ContractStudent && semesterCost.getText().isEmpty())) {
                showMessage();
            } else {
                try {
                    student.setFirstName(firstName.getText());
                    student.setLastName(lastName.getText());
                    student.setStudentId(Integer.parseInt(studentId.getText()));
                    student.setYear(year.getValue().getYear());
                    if (contractCheckBox.isSelected()) {
                        ((ContractStudent) student).setCostEducationSemestr(Double.parseDouble(semesterCost.getText()));
                    }
                    main.addStudent(student, groupId - 1);
                    closeWindow();
                } catch (IncorrectDataException e) {
                    showMessage(e);
                } catch (NumberFormatException e){
                    showMessage(e);
                } catch (NullPointerException  e){
                    showMessage(e);
                }
            }
        });

    }

    public void showMessage(IncorrectDataException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ХУЙНЯ");
        alert.setHeaderText("Не сохранено");
        alert.setContentText(e.getMessage());

        alert.show();
    }

    public void showMessage(NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ХУЙНЯ");
        alert.setHeaderText("Не сохранено");
        alert.setContentText(e.getMessage());

        alert.show();
    }

    public void showMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ХУЙНЯ");
        alert.setHeaderText("Не сохранено");
        alert.setContentText("Заполните все поля!");
        alert.show();
    }

    public void showMessage(NullPointerException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ХУЙНЯ");
        alert.setHeaderText("Не сохранено");
        alert.setContentText("Choose year");
        alert.show();
    }
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener((ov, oldValue, newValue) -> {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        });
    }
    private void closeWindow(){
        Stage stage = (Stage) saveStudent.getScene().getWindow();
        stage.close();
    }
}