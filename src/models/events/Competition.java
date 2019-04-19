package models.events;

import exceptions.IncorrectDataException;

import java.util.Date;

public class Competition implements Event {

    private Date date;
    private String city;
    private String projectName;
    private double winCash = 0;


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
    public void setCity(String city) {
        this.city = city;

        if (city.trim().isEmpty()){
            throw new IncorrectDataException("Empty name of city");
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;

        if (projectName.trim().isEmpty()){
            throw new IncorrectDataException("Empty name of project");
        }
    }

    public double getWinCash() {
        return winCash;
    }

    public void setWinCash(int winCash) {
        this.winCash = winCash;

        if (winCash < 0 ) {
            throw new IncorrectDataException("Negative prize");
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        String noInfo = "Нет информации";
        stringBuilder.append("Название проекта:");
        if(projectName == null) {
            stringBuilder.append(noInfo);
        }else
            stringBuilder.append(projectName);

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

        if (getWinCash() != 0) {
            stringBuilder
                    .append("Выигрыш = ")
                    .append(getWinCash());
        }

        return stringBuilder.toString();
    }
}
