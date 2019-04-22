import exception.IncorrectDataException;
import model.event.Conference;
import model.event.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static java.util.Calendar.NOVEMBER;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConferenceTest {

    private Conference conference = new Conference();
    private Conference conference1 = new Conference();

    @Test
    @DisplayName("Пустое название доклада")
    void setEmptyArticleName() {
        assertThrows(IncorrectDataException.class, () -> conference.setArticleName("     "));
    }

    @Test
    @DisplayName("Название доклада на конференции")
    void setArticleName() {
        assertDoesNotThrow(() -> conference.setArticleName("Влияние Папича на мозг"));
    }


    @Test
    @DisplayName("Указать город")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> conference.setCity("     "));
    }

    @Test
    @DisplayName("toString, Нет информации в conf")
    void getToStringNoInfo() {
        System.out.println(conference);
    }

    @Test
    @DisplayName("toString")
    void getToString() {
        conference.setCity("Одесса");
        conference.setArticleName("Article Name");
        conference.setDate(new Date());
        System.out.println(conference);
    }

    @Test
    @DisplayName("Equals для объектов разных классов")
    void getEquals() {
        assertTrue(!conference.equals(new Olympiad()));
    }

    @Test
    @DisplayName("Equals для пустых объектов")
    void getEqualsEmpt() {
        assertTrue(conference.equals(conference1));
    }

    @Test
    @DisplayName("Equals для одинаковых городов и назвний докладов, но с разным регистром")
    void getEqualsIgnoreCase() {
        conference.setCity("Одесса");
        conference1.setCity("одЕсса");
        conference.setArticleName("Test name");
        conference1.setArticleName("test namE");
        assertTrue(conference.equals(conference1));
    }

    @Test
    @DisplayName("Equals для разных объектов")
    void getEqualsNotTrue() {
        conference.setCity("Одесса");
        conference1.setCity("Moscow");
        conference.setArticleName("Test");
        conference1.setArticleName("namE");
        assertTrue(!conference.equals(conference1));
    }

    @Test
    @DisplayName("Чекнули hashCode вообще что получим в консольке")
    void getHashCodeInTerm() {
        conference.setCity("Odessa");
        System.out.println(conference.hashCode());
        conference1.setArticleName("Just simple test");
        System.out.println(conference1.hashCode());
    }

    @Test
    @DisplayName("Тест hashCode(Сравниваем notEquals объекты")
    void getHashCode() {
        conference.setCity("Test");
        conference1.setArticleName("fdgfd");
        assertNotEquals(conference1.hashCode(), conference.hashCode());
    }

    @Test
    @DisplayName("Тест hashCode(Сравниваем Equals объекты")
        //хоть регистры и разные, hashCode одинаков
    void getHashCodeSame() {
        conference1.setCity("test");
        conference.setCity("Test");
        conference1.setArticleName("what to say");
        conference.setArticleName("WHAT TO say");
        conference.setDate(new Date(2019,NOVEMBER,20));
        conference1.setDate(new Date(2019,NOVEMBER,20));
        assertEquals(conference.hashCode(), conference1.hashCode());
    }

}