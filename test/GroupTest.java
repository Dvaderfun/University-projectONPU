import exceptions.IncorrectDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group g;
    private int groupId;

    @Test
    @DisplayName("констуктор только с id, nega")
    void testConstrNegId() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(-2);
        });
    }

    @Test
    @DisplayName("констуктор только с id, 0")
    void testConstrZeroId() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(0);
        });
    }

    @Test
    @DisplayName("констуктор с 2 параметрами")
    void testConstr2() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(0, -5);
        });

        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(-5, -5);
        });

        assertThrows(IncorrectDataException.class, () -> {
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
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(4);
            g.setGroupId(-5);
            g.setGroupId(0);
        });

    }

    @Test
    void getNumOfStudents() {
        g = new Group(6, 0);
        assertEquals(0, g.getNumOfStudents());
    }

    @Test
    @DisplayName("нахождение студента по id")
    void findStudent() {
        Student[] students = new Student[4];
        students[0] = new Student("leha", "lesha", 123457);
        students[1] = new Student("a", "a", 123456);
        students[3] = new Student("a", "a", 888888);
        g = new Group(students);
        Student founded = g.findStudent(123456);
        assertSame(students[1], founded);

        assertDoesNotThrow(()->{
            Student s = g.findStudent(888888);
            assertSame(students[3], s);
        });

    }

    @Test
    void removeStudent() {
        Group gr = new Group(5, 3);
        gr.addStudent(new Student("asd", "sdf", 332455));
        assertEquals(4, gr.getNumOfStudents());
        gr.removeStudent(332455);
        assertEquals(3, gr.getNumOfStudents());
    }

    @Test
    void addStudent() {
        Group gr = new Group(5, 3);
        gr.addStudent(new Student("asd", "asdg", 332455));
        assertEquals(4, gr.getNumOfStudents());
    }

    @Test
    void sortStudent() {
        Student students[] = new Student[3];
        students[0] = new Student("Artyom", "Kazlanzhi");
        students[1] = new Student("Daniil","Dermenzhy");
        students[2] = new Student("Alex", "Dermenzhy");
        Group gr = new Group(students);
        System.out.println(gr);
        Group other = new Group(gr.sortStudent(gr.getStudents()));
        System.out.println(other);
        assertNotEquals(gr.toString(), other.toString());

    }
}