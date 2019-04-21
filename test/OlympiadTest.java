import exception.IncorrectDataException;
import models.events.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OlympiadTest {
    Olympiad olympiad = new Olympiad();


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
    void getToStringNoInfo(){
        System.out.println(olympiad);
    }

    @Test
    @DisplayName("toString")
    void getToString(){
        olympiad.setCity("Одесса");
        olympiad.setPodiumPlace(3);
        olympiad.setDate(new Date());
        System.out.println(olympiad);
    }

}
