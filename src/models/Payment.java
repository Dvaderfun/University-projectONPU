package models;

import exceptions.IncorrectDataException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {
    private Date date;
    private double educationPayment;


    public Payment() {
        this.date = null;
        this.educationPayment = 0;
    }

    public Payment(Date date, double educationPayment) {
        this.date = date;
        this.educationPayment = educationPayment;

        if(educationPayment < 0) {
            throw new IncorrectDataException("Negative price of education");
        }

        if (date.getYear() > 2019) {
            throw new IncorrectDataException("Incorrect year");
        }

        if (date.getMonth() > 12 || date.getMonth() < 1) {
            throw new IncorrectDataException("Incorrect month");
        }

        if (date.getDay() > 31 || date.getDay() < 1) {
            throw new IncorrectDataException("Incorrect day");
        }

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
