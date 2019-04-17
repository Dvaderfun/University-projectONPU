package models.events;

import exceptions.IncorrectDataException;

import java.util.Date;

public class Conference implements Event {
    private Date date;
    private String city;
    private String articleName;


    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;

        if (articleName.trim().isEmpty()) {
            throw new IncorrectDataException("Empty name of article");
        }
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;

        // TODO
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;

        if (city.trim().isEmpty()){
            throw new IncorrectDataException("Empty name of city");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Название статьи: ")
                .append("\"")
                .append(getArticleName())
                .append("\"")
                .append("\n")
                .append("Город ")
                .append(getCity())
                .append("\n")
                .append("Дата: ")
                .append(getDate());

        return stringBuilder.toString();
    }
}
