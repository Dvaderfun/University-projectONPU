import exception.IncorrectDataException;
import models.events.Competition;
import models.events.Conference;
import models.events.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OlympiadTest {
    Olympiad olympiad = new Olympiad();
    Olympiad olympiad2 = new Olympiad();


    @Test
    @DisplayName("Указать город")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> olympiad.setCity("  "));
    }

    @Test
    @DisplayName("Несуществующее место на олимпиаде")
    void setPodiumPlace() {
        assertThrows(IncorrectDataException.class, () -> olympiad.setPodiumPlace(0));
    }

    @Test
    @DisplayName("toString, Нет информации в olymp)")
    void getToStringNoInfo() {
        System.out.println(olympiad);
    }

    @Test
    @DisplayName("toString")
    void getToString() {
        olympiad.setCity("Одесса");
        olympiad.setPodiumPlace(3);
        olympiad.setDate(new Date());
        System.out.println(olympiad);
    }

    @Test
    @DisplayName("Тест на equals для пустых объектов")
    void getEquals() {
        assertTrue(olympiad.equals(olympiad2));
    }

    @Test
    @DisplayName("Тест на equals для разных")
    void getEqualsNotSame() {
        olympiad.setPodiumPlace(3);
        assertTrue(!olympiad.equals(olympiad2));
    }

    @Test
    @DisplayName("Тест на equals для раных типов объектов")
    void getEqualsNotSameObj() {
        Conference c = new Conference();
        Competition competition = new Competition();
        assertTrue(!olympiad.equals(c));
        assertTrue(!olympiad.equals(competition));
    }

    @Test
    @DisplayName("Тест на equals для одинаковых, но не дефолтных")
//с разными регистрами
    void getEqualsSameNotDef() {
        olympiad.setCity("Odessa");
        olympiad.setPodiumPlace(4);
        olympiad2.setCity("odessa");
        olympiad2.setPodiumPlace(4);
        assertTrue(olympiad.equals(olympiad2));
    }


}
