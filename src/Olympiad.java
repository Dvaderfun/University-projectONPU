import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Olympiad implements Event{
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

        if (StringUtils.isEmpty(city))
            throw new Olympiad.IncorrectNameCity("Empty name of city");
    }

    public int getPodiumPlace() {
        return podiumPlace;
    }

    public void setPodiumPlace(int podiumPlace) {
        this.podiumPlace = podiumPlace;
    }

    static class IncorrectNameCity extends RuntimeException {
        IncorrectNameCity(String message) {
            super(message);
        }
    }
}
