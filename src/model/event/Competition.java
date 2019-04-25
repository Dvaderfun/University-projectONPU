package model.event;

import exception.IncorrectDataException;
import model.Event;

import java.util.Calendar;
import java.util.Date;

public class Competition implements Event {

    private Date date;
    private String city;
    private String projectName;
    private double winCash = 0;

    private static final Date DEFAULT_DATE = new Date(0, Calendar.JANUARY, 0);
    private static final String DEFAULT_CITY = "не указано";
    private static final String DEFAULT_PROJ_NAME = "не указано";

    public Competition() {
        this.date = DEFAULT_DATE;
        this.city = DEFAULT_CITY;
        this.projectName = DEFAULT_PROJ_NAME;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        //Date уже подразумевает проверку на некорректные данные, тест не нужен
        this.date = date;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) throws IncorrectDataException {

        if (city.trim().isEmpty()) {
            throw new IncorrectDataException("Empty name of city");
        } else {
            this.city = city;
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) throws IncorrectDataException {

        if (projectName.trim().isEmpty()) {
            throw new IncorrectDataException("Empty name of project");
        } else {
            this.projectName = projectName;
        }
    }

    public double getWinCash() {
        return winCash;
    }

    public void setWinCash(int winCash) throws IncorrectDataException {
        if (winCash < 0) {
            throw new IncorrectDataException("Negative prize");
        } else {
            this.winCash = winCash;
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        String noInfo = "Нет информации";
        stringBuilder.append("Название проекта:");
        if (projectName.equals(DEFAULT_PROJ_NAME)) {
            stringBuilder.append(noInfo);
        } else
            stringBuilder.append(projectName);
        stringBuilder.append("\n")
                .append("Город: ");
        if (city.equals(DEFAULT_CITY)) {
            stringBuilder.append(noInfo);
        } else
            stringBuilder.append(city);
        stringBuilder.append("\n")
                .append("Дата: ");
        if (date == DEFAULT_DATE) {
            stringBuilder.append(noInfo);
        } else {
            stringBuilder.append(date);
        }

        if (getWinCash() != 0) {
            stringBuilder
                    .append("\nВыигрыш = ")
                    .append(winCash);
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof Competition)) {
            return false;
        } else
            return (city.equalsIgnoreCase(((Competition) o).city)
                    && date.equals(((Competition) o).date)
                    && projectName.equalsIgnoreCase(((Competition) o).projectName)
                    && winCash == ((Competition) o).winCash);
    }

    //toLowerCase нужен для того, чтобы ивенты с по факту одинаковыми городами, но разным регистром написания
    //имели один и тот же hashCode, иначе hashCode для city вернет разные результаты
    @Override
    public int hashCode() {
        return 729843 ^ date.hashCode() ^ city.toLowerCase().hashCode() ^
                projectName.toLowerCase().hashCode() ^ Double.hashCode(winCash);
    }
}

