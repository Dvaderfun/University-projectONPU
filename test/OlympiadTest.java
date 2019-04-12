import exceptions.IncorrectDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OlympiadTest {
    Olympiad olympiad = new Olympiad();

    @Test
    void setDate() {
    }

    @Test
    @DisplayName("Указать город!")
    void setCity() {
        assertThrows(IncorrectDataException.class, () -> olympiad.setCity("  "));
    }

    @Test
    @DisplayName("Несуществующее место на олимпиаде!")
    void setPodiumPlace() {
        assertThrows(IncorrectDataException.class, () -> olympiad.setPodiumPlace(0));
    }
}
