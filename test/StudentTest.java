import exception.DuplicateEventException;
import exception.IncorrectDataException;
import models.Student;
import models.events.Competition;
import models.events.Conference;
import models.events.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    Student student;
    Olympiad olympiad, olympiad2, olympiad3;
    Competition competition, competition2;
    Conference conference;

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

    @Test
    void testStudentArray(){
        student = new Student("Daniil", "Dermenzhy", 123456);
        olympiad = new Olympiad();

        Date date = new Date();
        date.setTime(1241246);

        olympiad.setCity("Odessa");
        olympiad.setDate(date);
        olympiad.setPodiumPlace(1);

        student.addEvent(olympiad);

        System.out.println(student.getEvent(0).getCity());
        System.out.println(student.getEvent(0).getDate());
    }

    @Test
    void testStudentEvents(){
        student = new Student("Daniil", "Dermenzhy", 123456);
        olympiad = new Olympiad();
        olympiad2 = new Olympiad();
        olympiad3 = new Olympiad();

        conference = new Conference();
        competition = new Competition();
        competition2 = new Competition();

        Date date = new Date(121, Calendar.MARCH, 5624);


        System.out.println(date.getMonth());

        /*
        olympiad.setCity("Odessa");
        olympiad.setDate(date);
        olympiad.setPodiumPlace(1);

        olympiad2.setCity("Kiev");
        olympiad2.setDate(date);
        olympiad2.setPodiumPlace(4);

        olympiad3.setCity("Artsyz");
        olympiad3.setDate(date);
        olympiad3.setPodiumPlace(3);

        conference.setArticleName("pp");
        conference.setCity("fg");
        conference.setDate(date);

        competition.setCity("Moscow");
        competition.setDate(date);
        competition.setProjectName("Sub2PewDiePie");
        competition.setWinCash(1000);

        competition2.setCity("Moscow");
        competition2.setDate(date);
        competition2.setProjectName("TGay");
        competition2.setWinCash(0);

        student.addEvent(olympiad);
        student.addEvent(olympiad2);
        student.addEvent(olympiad3);
        student.addEvent(conference);
        student.addEvent(competition);
        student.addEvent(competition2);

        System.out.println(competition.getDate());
        //System.out.println(student.getPrizePlaceNumber());*/
    }

    @Test
    @DisplayName("Test adding a Duplicate Event")
    void testDuplicateEvents(){
        student = new Student("Daniil", "Dermenzhy", 123456);

        olympiad = new Olympiad();
        olympiad2 = new Olympiad();
        olympiad3 = new Olympiad();

        olympiad.setCity("A");
        olympiad2.setCity("A");
        olympiad3.setCity("B");

        Date date = new Date(119, Calendar.MARCH, 12);
        Date date2 = new Date(129, Calendar.JANUARY, 13);
        olympiad.setDate(date);
        olympiad2.setDate(date);
        olympiad3.setDate(date2);

        olympiad.setPodiumPlace(2);
        olympiad2.setPodiumPlace(2);
        olympiad3.setPodiumPlace(3);

        student.addEvent(olympiad);
        student.addEvent(olympiad3);

        assertThrows(DuplicateEventException.class, () ->
                student.addEvent(olympiad));

        assertThrows(DuplicateEventException.class, () ->
            student.addEvent(olympiad2));

        assertThrows(DuplicateEventException.class, () ->
                student.addEvent(olympiad3));
    }


    @Test
    void getEventNumber() {

    }

    @Test
    void getPrizePlaceNumber() {
    }

    @Test
    void getReportsNumber() {
    }

    @Test
    void getNameProjects() {
    }


}