package models.events;

import exception.IncorrectDataException;

import java.util.Date;

public class Olympiad implements Event {
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String noInfo = "Нет информации";
        stringBuilder
                .append("Место на олимпиаде: ")
                .append(podiumPlace)
                .append("\n")
                .append("Город: ");
        if(city == null) {
            stringBuilder.append(noInfo);
        }else
            stringBuilder.append(city);

        stringBuilder.append("\n")
                .append("Дата: ");
        if(date == null){
            stringBuilder.append(noInfo);
        }else {
            stringBuilder.append(date);
        }
        return stringBuilder.toString();
    }

}
