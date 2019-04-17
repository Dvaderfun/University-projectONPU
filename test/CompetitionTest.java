import exceptions.IncorrectDataException;
import models.events.Competition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {
    Competition competition = new Competition();

    @Test
    void setDate() {
        // TODO дописать тест
    }

    @Test
    @DisplayName("Указать город")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> competition.setCity("      "));
    }

    @Test
    @DisplayName("Имя проекта")
    void setProjectName() {
        assertThrows(IncorrectDataException.class, () -> competition.setProjectName("informat"));
    }

    @Test
    @DisplayName("Отрицательное значение выигрыша")
    void setWinCash() {
        assertThrows(IncorrectDataException.class, () -> competition.setWinCash(0));
    }
}