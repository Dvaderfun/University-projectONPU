import exceptions.IncorrectDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @Test
    @DisplayName("конструктор с слишком болшим или слишком маленьеим значением studentid")
    void testStudentIdShortLong(){
        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("Daniil", "Dermenzhy", 1);
        });

        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("Daniil", "Dermenzhy", 123456789);
        });
    }

    @Test
    @DisplayName("id < 0")
    void testStudentIdNegative(){
        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("sfsf", "", -123456);
        });
    }

    @Test
    @DisplayName("id = 0")
    void testStudentIdZero(){
        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("sfsf", "", 000000);
        });
    }

    @Test
    @DisplayName("играемся с именем и фамилией")
    void testStudentName(){
        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("Daniil", "", 123456);
        });

        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("", "Dermenzhy", 123456);
        });

        assertThrows(IncorrectDataException.class, () -> {
            student = new Student("", "", 123456);
        });
    }

    @Test
    @DisplayName("проверка конструктора")
    void testStudent(){
        student = new Student("Daniil", "Dermenzhy", 123456);


        System.out.println(student.getFirstName() + " " +
                student.getLastName() + " " +
                student.getStudentId());

    }

    @Test
    @DisplayName("проверка сеттеров")
    void testStudentSetters(){
        student = new Student("Daniil", "Dermenzhy", 123456);

        student.setFirstName("Mykola");
        student.setLastName("Hodovychenko");
        student.setStudentId(654321);
        System.out.println(student.getFirstName() + " " +
                student.getLastName() + " " +
                student.getStudentId());

    }
}