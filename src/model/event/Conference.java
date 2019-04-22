package model.event;

import exception.IncorrectDataException;
import model.Event;

import java.util.Calendar;
import java.util.Date;

public class Conference implements Event {
    private Date date;
    private String city;
    private String articleName;


    private static final Date DEFAULT_DATE = new Date(0, Calendar.JANUARY,0);
    private static final String DEFAULT_CITY = "не указано";
    private static final String DEFAULT_ARTICLE_NAME= "не указана";

    public Conference(){
        this.date = DEFAULT_DATE;
        this.city = DEFAULT_CITY;
        this.articleName = DEFAULT_ARTICLE_NAME;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) throws IncorrectDataException {

        if (articleName.trim().isEmpty()) {
            throw new IncorrectDataException("Empty name of article");
        } else{
            this.articleName = articleName;
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
    public void setCity(String city) throws IncorrectDataException {

        if (city.trim().isEmpty()){
            throw new IncorrectDataException("Empty name of city");
        } else{
            this.city = city;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String noInfo = "Нет информации";
        stringBuilder.append("Название доклада: ");

        if(articleName.equals(DEFAULT_ARTICLE_NAME)) {
            stringBuilder.append(noInfo);
        }else
            stringBuilder.append(articleName);
                stringBuilder.append("\n")
                .append("Город: ");
        if(city.equals(DEFAULT_CITY)){
            stringBuilder.append(noInfo);
        }else
            stringBuilder.append(city);

        stringBuilder.append("\n")
                .append("Дата: ");
        if(date == DEFAULT_DATE){
            stringBuilder.append(noInfo);
        }else {
            stringBuilder.append(date);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass() == this.getClass())
            if(city.equalsIgnoreCase(((Conference) o).city)
                    && date.equals(((Conference) o).date)
                    && articleName.equalsIgnoreCase(((Conference) o).articleName))
                return true;
        return false;
    }
}
