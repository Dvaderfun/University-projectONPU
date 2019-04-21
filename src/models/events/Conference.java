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
        String noInfo = "Нет информации";
        stringBuilder.append("Название доклада: ");

        if(articleName == null) {
            stringBuilder.append(noInfo);
        }else
            stringBuilder.append(articleName);
                stringBuilder.append("\n")
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
