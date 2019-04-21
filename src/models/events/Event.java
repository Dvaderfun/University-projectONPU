package models.events;

import java.util.Date;

public interface Event {

    Date getDate();
    void setDate(Date date);

    String getCity();
    void setCity(String city);

}
