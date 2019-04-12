import exceptions.IncorrectDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group g;


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
    }

    @Test
    @DisplayName("Конструктор - negat groupId, negat - кол-во студентов")
    void testConstr2_1() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(-5, -5);
        });
    }

    @Test
    @DisplayName("Конструктор - negat groupId, кол-во студентов - 0")
    void testConstr2_2() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(-3, 0);
        });
    }

    @Test
    @DisplayName("Конструктор с корректными исходниками")
    void testConstr2_3() {
        assertDoesNotThrow(() -> {
            g = new Group(5, 5);
        });
    }


    @Test
    @DisplayName("констуктор с готовыми студентами")
    void testConstrGettingStud() {
        g = new Group(5);
        assertDoesNotThrow(() -> {
            g = new Group(g.getStudents());
        });

    }

    @Test
    @DisplayName("Перезаписать id на negat")
    void setNegGroupId() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(4);
            g.setGroupId(-5);
        });
    }

    @Test
    @DisplayName("Перезаписать id группы на 0")
    void setZeroGroupId() {
        assertThrows(IncorrectDataException.class, () -> {
            g = new Group(4);
            g.setGroupId(0);
        });
    }

    @Test
    @DisplayName("Получение кол-ва студентов")
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

        assertDoesNotThrow(() -> {
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
    @DisplayName("Сортировка с разными людьми")
    void sortStudent() {
        Student students[] = new Student[3];
        students[0] = new Student("Artyom", "Kazlanzhi");
        students[1] = new Student("Daniil", "Dermenzhy");
        students[2] = new Student("Alex", "Dermenzhy");
        Group group = new Group(students);
        Group sortedGroup = new Group(group.sortStudent(group.getStudents()));
        assertFalse(!group.toString().equals(sortedGroup.toString()));
    }

    @Test
    @DisplayName("Сортировка одного человека в группе")
    void sortStudentOnlyOne(){
        Group group = new Group(1);
        group.addStudent(new Student("Artyom","Kazlanzhi"));
        System.out.println(group);
        Group sortedGroup = new Group(group.sortStudent(group.getStudents()));
        System.out.println(sortedGroup);
        assertTrue(group.toString().equals(sortedGroup.toString()));
    }
}

