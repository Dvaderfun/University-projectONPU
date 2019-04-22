import exception.IncorrectDataException;
import model.event.Conference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ConferenceTest {

    Conference conference = new Conference();

    @Test
    @DisplayName("Название доклада на конференции")
    void setArticleName() {
        assertThrows(IncorrectDataException.class, () -> conference.setArticleName("Влияние Папича на мозг"));
    }


    @Test
    @DisplayName("Указать город")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> conference.setCity("     "));
    }

    @Test
    @DisplayName("toString, Нет информации в conf")
    void getToStringNoInfo(){
        System.out.println(conference);
    }

    @Test
    @DisplayName("toString")
    void getToString(){
        conference.setCity("Одесса");
        conference.setArticleName("Article Name");
        conference.setDate(new Date());
        System.out.println(conference);
    }
}