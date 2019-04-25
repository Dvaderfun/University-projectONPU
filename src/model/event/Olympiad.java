package model.event;

import exception.IncorrectDataException;
import model.Event;

import java.util.Calendar;
import java.util.Date;

public class Olympiad implements Event {

    private Date date;
    private String city;
    private int podiumPlace;

    private static final Date DEFAULT_DATE = new Date(0, Calendar.JANUARY, 0);
    private static final String DEFAULT_CITY = "не указано";
    private static final int DEFAULT_PLACE = 0;

    public Olympiad() {
        this.date = DEFAULT_DATE;
        this.city = DEFAULT_CITY;
        this.podiumPlace = DEFAULT_PLACE;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) throws IncorrectDataException {
        this.city = city;

        if (city.trim().isEmpty())
            throw new IncorrectDataException("Empty name of city");
    }

    public int getPodiumPlace() {
        return podiumPlace;
    }

    public void setPodiumPlace(int podiumPlace) throws IncorrectDataException {
        this.podiumPlace = podiumPlace;

        if (podiumPlace < 1)
            throw new IncorrectDataException("Negative position on event");
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String noInfo = "Не указано";
        stringBuilder
                .append("Место на олимпиаде: ")
                .append(podiumPlace)
                .append("\n")
                .append("Город: ");
        if (city == DEFAULT_CITY) {
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
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof Olympiad)) {
            return false;
        } else
            return
                    (city.equalsIgnoreCase(((Olympiad) o).city)
                            && date.equals(((Olympiad) o).date)
                            && podiumPlace == ((Olympiad) o).podiumPlace);
    }

    //toLowerCase нужен для того, чтобы ивенты с по факту одинаковыми городами, но разным регистром написания
    //имели один и тот же hashCode, иначе hashCode для city вернет разные результаты
    @Override
    public int hashCode() {
        return 3777777 ^ date.hashCode() ^ city.toLowerCase().hashCode() ^ podiumPlace;
    }
}