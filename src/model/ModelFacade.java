package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Observable;


public class ModelFacade extends Observable {

    // Фасад (Facade)

    private ObservableList<Group> list;
    private ObservableList<Student> studentsList;

    Group group;

    public ModelFacade() {
        list = FXCollections.observableArrayList();
        studentsList = FXCollections.observableArrayList();
    }

    public void addGroup(Group e) {
        list.add(e);
    }

    public Group getGroup(int groupId) {
        return list.get(groupId);
    }

    public void deleteGroup(Group e) {
        list.remove(e);
    }

    public void bindGroups(ListView listView) {
        listView.setItems(list);
    }

    public void updateStudentsList(int groupId){
        group = getGroup(groupId);

        studentsList.clear();
        studentsList.addAll(group.getStudents());
    }

    public void addStudent(Student s, int groupId) {
        group = getGroup(groupId);
        group.addStudent(s);

        list.set(groupId, group);

        studentsList.add(s);
    }

    public void deleteStudent(Student s, int groupId) {
        group = getGroup(groupId);
        group.removeStudent(s.getStudentId());

        list.set(groupId, group);

        studentsList.remove(s);
    }

    public void bindStudents(ListView listView) {
        listView.setItems(studentsList);
    }
}
