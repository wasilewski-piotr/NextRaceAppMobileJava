package nextrace.app.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("events")
    @Expose
    private List<Event> events;

    public EventList(List<Event> events) {
        this.events = events;
    }

    public EventList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
