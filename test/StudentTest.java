import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @Test
    void testStudentIdShortLong(){
        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("Daniil", "Dermenzhy", 1);
        });

        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("Daniil", "Dermenzhy", 123456789);
        });
    }

    @Test
    void testStudentIdNegative(){
        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("sfsf", "", -123456);
        });
    }

    @Test
    void testStudentIdZero(){
        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("sfsf", "", 000000);
        });
    }

    @Test
    void testStudentName(){
        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("Daniil", "", 123456);
        });

        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("", "Dermenzhy", 123456);
        });

        assertThrows(Student.IncorrectDataException.class, () -> {
            student = new Student("", "", 123456);
        });
    }

    @Test
    void testStudent(){
        student = new Student("Daniil", "Dermenzhy", 123456);


        System.out.println( student.getFirstName() +
        student.getLastName() +
        student.getStudentId());

    }

    @Test
    void setFirstName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void setYear() {
    }

    @Test
    void setStudentId() {
    }
}