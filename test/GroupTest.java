import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group g;

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

        assertDoesNotThrow( () -> {
            g = new Group(5, 5);
        });
    }

    @Test
    @DisplayName("констуктор с готовыми студентами")
    void testConstr3() {
        g = new Group(5);
        assertDoesNotThrow( () -> {
            g = new Group(g.getStudents());
        });

    }


    @Test
    void getGroupId() {
    }

    @Test
    void setGroupId() {
    }

    @Test
    void getNumOfStudents() {
    }

    @Test
    void getStudents() {
    }

    @Test
    void findStudent() {
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