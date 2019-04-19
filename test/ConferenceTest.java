import exceptions.IncorrectDataException;
import models.events.Conference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}