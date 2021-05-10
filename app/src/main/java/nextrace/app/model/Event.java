package nextrace.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("cetTime")
    @Expose
    private String cetTime;
    @SerializedName("list_of_events")
    @Expose
    private Object listOfEvents;

    public Event(String type, String date, String localTime, String cetTime, Object listOfEvents) {
        this.type = type;
        this.date = date;
        this.localTime = localTime;
        this.cetTime = cetTime;
        this.listOfEvents = listOfEvents;
    }

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        String finalDate = date.substring(0,10);
        return finalDate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getCetTime() {
        return cetTime;
    }

    public void setCetTime(String cetTime) {
        this.cetTime = cetTime;
    }

    public Object getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(Object listOfEvents) {
        this.listOfEvents = listOfEvents;
    }

}