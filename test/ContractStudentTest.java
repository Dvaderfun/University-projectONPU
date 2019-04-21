import exceptions.IncorrectDataException;
import models.*;
import models.events.Conference;
import models.events.Olympiad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContractStudentTest {
    private ContractStudent cS = new ContractStudent();

    @Test
    @DisplayName("Set cost education negative")
    void costEducationNeg() {
        assertThrows(IncorrectDataException.class , () -> {
            cS.setCostEducationSemestr(-1);
        });
    }

    @Test
    void getPaymentsList() {
    }

    @Test
    void setPaymentsList() {
    }

    @Test
    void getCostEducationSemestr() {
    }

    @Test
    void setCostEducationSemestr() {
    }

    @Test
    void getAmountDebt() {
    }

    @Test
    void addPayment() {
    }

    @Test
    void deletePayment() {
    }

    @Test
    void toString() {
    }
}