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
    @DisplayName("нахождение студента по id")
    void findStudent() {
        Student[] students = new Student[4];
        Student leha = new Student("leha", "lesha", 123457);
        students[0] = leha;
        Student nobody = new Student("a", "a", 123456);
        students[0] = leha;
        students[1] = nobody;
        g = new Group(students);
        Student found = g.findStudent(123456);
        assertSame(nobody, found);


    }

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