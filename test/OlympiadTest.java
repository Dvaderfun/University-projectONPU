import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OlympiadTest {
    Olympiad olympiad = new Olympiad();

    @Test
    void setDate() {
    }

    @Test
    void setCity() {
        assertThrows(Olympiad.IncorrectNameCity.class, () -> olympiad.setCity(""));
    }

    @Test
    void setPodiumPlace() {
    }
}