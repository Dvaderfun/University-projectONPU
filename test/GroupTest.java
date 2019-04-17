import exceptions.IncorrectDataException;
import models.*;
import models.events.Conference;
import models.events.Olympiad;
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
    @DisplayName("получение студента по id, если массив студентов пуст")
    void getStudentByIdIfNone() {

        g = new Group(2);
        System.out.print(g.getStudentById(234567));
    }

    @Test
    @DisplayName("получение студента по id")
    void getStudentById() {

        g = new Group(2);
        Student s = new  Student("sd", "sfg", 213456);
        g.addStudent(new Student("1", "2", 111111));
        g.addStudent(s);
        g.addStudent(new Student("1", "2", 111112));
        assertSame(g.getStudentById(213456), s);
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
        assertEquals(0, g.getStudentsNumber());
    }

    @Test
    @DisplayName("нахождение студента по id")
    void findStudent() {
        Student[] students = new Student[4];
        students[0] = new Student("leha", "lesha", 123457);
        students[1] = new Student("a", "a", 123456);
        students[3] = new Student("a", "a", 888888);
        g = new Group(students);
        Student founded = g.getStudentById(123456);
        assertSame(students[1], founded);

        assertDoesNotThrow(() -> {
            Student s = g.getStudentById(888888);
            assertSame(students[3], s);
        });
    }

    @Test
    void removeStudent() {
        Group gr = new Group(5, 3);
        gr.addStudent(new Student("asd", "sdf", 332455));
        assertEquals(4, gr.getStudentsNumber());
        gr.removeStudent(332455);
        assertEquals(3, gr.getStudentsNumber());
    }

    @Test
    void addStudent() {
        Group gr = new Group(5, 3);
        gr.addStudent(new Student("asd", "asdg", 332455));
        assertEquals(4, gr.getStudentsNumber());
    }

    @Test
    @DisplayName("Сортировка с разными людьми")
    void sortStudent() {
        Student students[] = new Student[3];
        students[0] = new Student("Artyom", "Kazlanzhi");
        students[1] = new Student("Daniil", "Dermenzhy");
        students[2] = new Student("Alex", "Dermenzhy");
        Group group = new Group(students);
        System.out.println(group);
        Group sortedGroup = new Group(group.getSortedStudents(group.getStudents()));
        System.out.println(sortedGroup);
        assertFalse(!group.toString().equals(sortedGroup.toString()));
    }

    @Test
    @DisplayName("Сортировка одного человека в группе")
    void sortStudentOnlyOnePerson(){
        Group group = new Group(1);
        group.addStudent(new Student("Artyom","Kazlanzhi"));
        System.out.println(group);
        Group sortedGroup = new Group(group.getSortedStudents(group.getStudents()));
        System.out.println(sortedGroup);
        assertTrue(group.toString().equals(sortedGroup.toString()));
    }

    @Test
    @DisplayName("Сортировка пустой группы")
    void sortStudentOnlyZeroPersons(){
        Group group = new Group(1,0);
        System.out.println(group);
        Group sortedGroup = new Group(group.getSortedStudents(group.getStudents()));
        System.out.println(sortedGroup);
        assertTrue(group.toString().equals(sortedGroup.toString()));
    }

    @Test
    @DisplayName("Получение активных студентов группы")
    void getActiveStudents() {
        Student s1 = new Student("Petya1", "Petrov1");
        Student s2 = new Student("Petya2", "Petrov2");
        Student s3 = new Student("Petya3", "Petrov3");
        Student s4 = new Student("Petya4", "Petrov4");
        s1.addEvent(new Olympiad());
        s3.addEvent(new Conference());
        g = new Group(1);
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        g.addStudent(s4);
        Student[] active = new Student[2];
        active[0] = s1;
        active[1] = s3;
        assertArrayEquals(active, g.getActiveStudents());
    }

    @Test
    @DisplayName("Получение активных студентов группы(их отсутсвие)")
    void getActiveStudentsNoone() {
        Student s1 = new Student("Petya1", "Petrov1");
        Student s2 = new Student("Petya2", "Petrov2");
        Student s3 = new Student("Petya3", "Petrov3");
        Student s4 = new Student("Petya4", "Petrov4");
        g = new Group(1);
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        g.addStudent(s4);
        Student[] active = new Student[0];
        assertArrayEquals(active, g.getActiveStudents());
    }

    @Test
    @DisplayName("Получение кол-ва активных студентов группы(2)")
    void getActivStdNumber() {
        Student s1 = new Student("Petya1", "Petrov1");
        Student s2 = new Student("Petya2", "Petrov2");
        Student s3 = new Student("Petya3", "Petrov3");
        Student s4 = new Student("Petya4", "Petrov4");
        s1.addEvent(new Olympiad());
        s3.addEvent(new Conference());
        g = new Group(1);
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        g.addStudent(s4);
        assertEquals(2, g.getActivStudentsNumber());
    }

    @Test
    @DisplayName("Получение кол-ва активных студентов группы(0)")
    void getActivStdNumberIsEmty() {
        Student s1 = new Student("Petya1", "Petrov1");
        Student s2 = new Student("Petya2", "Petrov2");
        Student s3 = new Student("Petya3", "Petrov3");
        Student s4 = new Student("Petya4", "Petrov4");
        g = new Group(1);
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        g.addStudent(s4);
        assertEquals(0, g.getActivStudentsNumber());
    }

    @Test
    void getWinnerStudents() {
        Student s1 = new Student("Petya1", "Petrov1");
        Student s2 = new Student("Petya2", "Petrov2");
        Student s3 = new Student("Petya3", "Petrov3");

        Olympiad o1 = new Olympiad();
        Olympiad o2 = new Olympiad();
        Olympiad o3 = new Olympiad();
        o1.setPodiumPlace(1);
        s1.addEvent(o1);
        o2.setPodiumPlace(3);
        s2.addEvent(o2);
        o3.setPodiumPlace(4);
        s3.addEvent(o3);
        g = new Group(1);
        g.addStudent(s1);
        g.addStudent(s2);
        g.addStudent(s3);
        Student[] expectedWinners = new Student[2];
        expectedWinners[0] = s1;
        expectedWinners[1] = s2;
        assertArrayEquals(expectedWinners, g.getWinnerStudents());

    }

    @Test
    void getContractStdNumber() {
        g = new Group(3);
        g.addStudent(new Student());
        g.addStudent(new ContractStudent());
        g.addStudent(new ContractStudent());
        g.addStudent(new Student());
        g.addStudent(new Student());
        assertSame(2,g.getContractStdNumber());
    }

    @Test
    void getContractStdNumber0() {
        g = new Group(3);
        g.addStudent(new Student());
        assertSame(0,g.getContractStdNumber());
    }

    @Test
    void getScholarshipStdNumber() {
        g = new Group(3);
        g.addStudent(new Student());
        g.addStudent(new ContractStudent());
        g.addStudent(new ContractStudent());
        g.addStudent(new Student());
        g.addStudent(new Student());
        assertSame(3, g.getScholarshipStdNumber());
    }

    @Test
    void getScholarshipStdNumber0() {
        g = new Group(3);
        g.addStudent(new ContractStudent());
        assertSame(0,g.getScholarshipStdNumber());
    }

    @Test
    @DisplayName("Кол-во должников 1")
    void getDebtorsNumber() {
        g = new Group(2);
        ContractStudent std1 = new ContractStudent();
        std1.setCostEducationSemestr(12000);
        g.addStudent(std1);
        assertSame(1, g.getDebtorsNumber());
    }

    @Test
    @DisplayName("Кол-во должников 1")
    void getDebtorsNumberFew() {
        g = new Group(2);
        ContractStudent std1 = new ContractStudent();
        std1.setCostEducationSemestr(12000);
        g.addStudent(std1);

        ContractStudent std2 = new ContractStudent();
        std2.setCostEducationSemestr(12000);
        g.addStudent(std2);

        ContractStudent std3 = new ContractStudent();
        g.addStudent(std3);
        assertSame(2, g.getDebtorsNumber());
    }

    @Test
    @DisplayName("Кол-во должников для пустой группы")
    void getDebtorsNumberEmtyGr() {
        g = new Group(2);
        assertSame(0, g.getDebtorsNumber());
    }

    @Test
    void getToString(){
        g = new Group(3);
        g.addStudent(new Student("Вася", "Пупкин", 232323));
        g.addStudent(new Student("Артём", "Казланжи", 234234));
        g.addStudent(new Student("Владимир", "Борисов", 123435));
        System.out.println(g);
    }

    @Test
    void getToStringNoStundents(){
        g = new Group(55);
        System.out.println(g);
    }
}

