import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group g;
    private int groupId;

    @Test
    @DisplayName("констуктор только с id, nega")
    void testConstrNegId() {
        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(-2);
        });
    }

    @Test
    @DisplayName("констуктор только с id, 0")
    void testConstrZeroId() {
        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(0);
        });
    }

    @Test
    @DisplayName("констуктор с 2 параметрами")
    void testConstr2() {
        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(0, -5);
        });

        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(-5, -5);
        });

        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(-3, 0);
        });

        assertDoesNotThrow(() -> {
            g = new Group(5, 5);
        });
    }

    @Test
    @DisplayName("констуктор с готовыми студентами")
    void testConstr3() {
        g = new Group(5);
        assertDoesNotThrow(() -> {
            g = new Group(g.getStudents());
        });

    }


    @Test
    @DisplayName("Перезаписать id группы")
    void setGroupId() {
        assertThrows(Group.IncorrectDataException.class, () -> {
            g = new Group(4);
            g.setGroupId(-5);
            g.setGroupId(0);
        });

    }

    @Test
    void getNumOfStudents() {
        g = new Group(6,5);
        assertEquals(5, g.getNumOfStudents());
    }


    @Test
    @DisplayName("findStud неправ передача студ id")
    void findStudentIncorrStudId() {
        g = new Group(5);
        assertThrows(Group.IncorrectDataException.class, () -> {
            g.findStudent(45);
        });
        assertThrows(Group.IncorrectDataException.class, () -> {
            g.findStudent(-445555);
        });
        assertThrows(Group.IncorrectDataException.class, () -> {
            g.findStudent(000000);
        });

    }
    //Student s = new Student("s", "t", 444444)
    @Test
    void removeStudent() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void sortStudent() {
    }
}