package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Observable;


public class ModelFacade extends Observable {

    // Фасад (Facade)

    private ObservableList<Group> list;

    public ModelFacade() {
        list = FXCollections.observableArrayList();
    }

    public void addGroup(Group e) {
        list.add(e);
    }

    public void deleteGroup(Group e) {
        list.remove(e);
    }

    public void bindObserver(ListView listView) {
        listView.setItems(list);
    }
}
