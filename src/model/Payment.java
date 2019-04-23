package model;

import exception.IncorrectDataException;

import java.util.Date;

public class Payment {
    private Date date;
    private double educationPayment;


    public Payment() {
        this.date = null;
        this.educationPayment = 0;
    }

    public Payment(Date date, double educationPayment) throws IncorrectDataException {
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

    public void setEducationPayment(double educationPayment) throws IncorrectDataException {
        this.educationPayment = educationPayment;

        if(educationPayment < 0) {
            throw new IncorrectDataException("Negative price of education");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(getEducationPayment())
                .append("UAH ")
                .append("(Оплачено )")
                .append(getDate());

        return stringBuilder.toString();
    }
}
