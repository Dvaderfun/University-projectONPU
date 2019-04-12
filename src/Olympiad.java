import exceptions.IncorrectDataException;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Olympiad implements Event{
    // TODO разобраться с Date и написать тест
    private Date date;
    private String city;
    private int podiumPlace;

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
    public void setCity(String city) {
        this.city = city;

        if (city.trim().isEmpty())
            throw new IncorrectDataException("Empty name of city");
    }

    public int getPodiumPlace() {
        return podiumPlace;
    }

    public void setPodiumPlace(int podiumPlace) {
        this.podiumPlace = podiumPlace;

        if (podiumPlace < 1)
            throw new IncorrectDataException("Negative position on event");
    }

}
