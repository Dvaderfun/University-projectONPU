import java.util.Date;

public class Competition implements Event {

    private Date date;
    private String city;
    private String projectName;
    private Double winCash = 0.0;


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
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getWinCash() {
        return winCash;
    }

    public void setWinCash(Double winCash) {
        this.winCash = winCash;
    }
}
