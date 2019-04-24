package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import model.Group;

import java.net.URL;
import java.util.ResourceBundle;

public class GroupController implements Initializable {
    private int i = 1;

    @FXML
    private Button addGroup;

    @FXML
    private Button removeGroup;

    @FXML
    private Button openGroup;

    @FXML
    private Text groupQuantity;

    @FXML
    private ListView listView;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
        main.bindObserver(listView);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addGroup.setOnAction(event -> {
            Group group = new Group(i, 0);
            main.addGroup(group);
            i++;

            groupQuantity.setText(getGroupQuantity());
        });

        removeGroup.setOnAction(event -> {
            main.deleteGroup((Group) listView.getSelectionModel().getSelectedItem());
            groupQuantity.setText(getGroupQuantity());
                    });

        openGroup.setOnAction(event ->
                main.openGroup());


        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (listView.getSelectionModel().getSelectedItem() != null) {
                removeGroup.setDisable(false);
                openGroup.setDisable(false);
            } else {
                removeGroup.setDisable(true);
                openGroup.setDisable(true);
            }
            groupQuantity.setText(getGroupQuantity());
        });
    }

    private String getGroupQuantity() {
        return "Groups: " + listView.getItems().size();
    }
}