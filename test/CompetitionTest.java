import exception.IncorrectDataException;
import model.event.Competition;
import model.event.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static java.util.Calendar.NOVEMBER;
import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {
    private Competition competition = new Competition();
    private Competition competition1 = new Competition();


    @Test
    @DisplayName("Указать город")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> competition.setCity("      "));
    }

    @Test
    @DisplayName("Имя проекта")
    void setProjectName() {
        assertDoesNotThrow(() ->
                competition.setProjectName("Test Name"));
    }

    @Test
    @DisplayName("Отрицательное значение выигрыша")
    void setWinCash() {
        assertThrows(IncorrectDataException.class, () -> competition.setWinCash(-465));
    }

    @Test
    @DisplayName("toString, Нет информации в comp)")
    void getToStringNoInfo() {
        System.out.println(competition);
    }

    @Test
    @DisplayName("toString")
    void getToString() {
        competition.setProjectName("ONPU PROJ");
        competition.setCity("Одесса");
        competition.setWinCash(3000);
        competition.setDate(new Date());
        System.out.println(competition);
    }

    @Test
    @DisplayName("Equals для объектов разных классов")
    void getEquals() {
        assertTrue(!competition.equals(new Olympiad()));
    }

    @Test
    @DisplayName("Equals для пустых объектов")
    void getEqualsEmpt() {
        assertTrue(competition.equals(competition1));
    }

    @Test
    @DisplayName("Equals для одинаковых городов и назвний проектов, но с разным регистром")
    void getEqualsIgnoreCase() {
        competition.setCity("Одесса");
        competition1.setCity("одЕсса");
        competition.setProjectName("Test name");
        competition1.setProjectName("test namE");
        assertTrue(competition.equals(competition1));
    }

    @Test
    @DisplayName("Equals для разных объектов")
    void getEqualsNotTrue() {
        competition.setCity("Одесса");
        competition1.setCity("Moscow");
        competition.setProjectName("Test");
        competition1.setProjectName("namE");
        competition1.setWinCash(234);
        assertTrue(!competition.equals(competition1));
    }

    @Test
    @DisplayName("Чекнули hashCode вообще что получим в консольке")
    void getHashCodeInTerm() {
        competition1.setCity("Odessa");
        System.out.println(competition1.hashCode());
        competition.setProjectName("Just simple test");
        System.out.println(competition.hashCode());
    }

    @Test
    @DisplayName("Тест hashCode(Сравниваем notEquals объекты")
    void getHashCode() {
        competition.setCity("Test");
        competition1.setWinCash(544821321);
        assertNotEquals(competition1.hashCode(), competition.hashCode());
    }

    @Test
    @DisplayName("Тест hashCode(Сравниваем Equals объекты")
        //хоть регистры и разные, hashCode одинаков
    void getHashCodeSame() {
        competition.setCity("test");
        competition1.setCity("Test");
        competition.setProjectName("what to say");
        competition1.setProjectName("WHAT TO say");
        competition.setDate(new Date(2019,NOVEMBER,20));
        competition1.setDate(new Date(2019,NOVEMBER,20));
        competition.setWinCash(35000);
        competition1.setWinCash(35000);
        assertEquals(competition.hashCode(), competition1.hashCode());
    }


}