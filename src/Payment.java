import exceptions.IncorrectDataException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
    private Date date;
    private double educationPayment;


    Payment() {
        this.date = null;
        this.educationPayment = 0;
    }

    Payment(Date date, double educationPayment) {
        this.date = date;
        this.educationPayment = educationPayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getEducationPayment() {
        return educationPayment;
    }

    public void setEducationPayment(double educationPayment) {
        this.educationPayment = educationPayment;

        if(educationPayment < 0) {
            throw new IncorrectDataException("Negative price of education");
        }
    }
}
