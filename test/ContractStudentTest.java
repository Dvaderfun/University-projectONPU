import exception.IncorrectDataException;
import model.ContractStudent;
import model.Group;
import model.Payment;
import model.Student;
import model.event.Conference;
import model.event.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ContractStudentTest {
    private ContractStudent cS = new ContractStudent();

    @Test
    @DisplayName("Негативное значение платы за обучение")
    void costEducationNeg() {
        assertThrows(IncorrectDataException.class, () -> {
            cS.setCostEducationSemestr(-1);
        });
    }

    @Test
    @DisplayName("Проверяю сам")
    void getToString() {
        ContractStudent cS = new ContractStudent("Vova", "Borya");
        cS.setCostEducationSemestr(12000);
        System.out.println(cS);
    }

    @Test
    @DisplayName("Геттер платы за обучение")
    void getCostEducationSemestr() {
        ContractStudent cS = new ContractStudent("Vova", "Borya");
        cS.setCostEducationSemestr(12000);
        assertEquals(12000, cS.getCostEducationSemestr());
    }

    @Test
    void setCostEducationSemestr() {
        ContractStudent cS = new ContractStudent("Vova", "Borya");
        cS.setCostEducationSemestr(15000);
        assertEquals(15000, cS.getCostEducationSemestr());
    }

    @Test
    @DisplayName("Размер долга")
    void CheckAmountDebt2018() {
        Calendar thisYear =  Calendar.getInstance();
        ContractStudent cS = new ContractStudent("Vova", "Borya");
        cS.setCostEducationSemestr(13000);
        cS.setYear(2018);
        assertEquals(2*cS.getCostEducationSemestr(), cS.getAmountDebt());
    }

}