import exception.IncorrectDataException;
import models.events.Competition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CompetitionTest {
    Competition competition = new Competition();


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

    @Test
    @DisplayName("toString, Нет информации в comp)")
    void getToStringNoInfo(){
        System.out.println(competition);
    }

    @Test
    @DisplayName("toString")
    void getToString(){
        competition.setProjectName("ONPU PROJ");
        competition.setCity("Одесса");
        competition.setWinCash(3000);
        competition.setDate(new Date());
        System.out.println(competition);
    }

}
