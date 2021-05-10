package nextrace.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Race {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("track")
    @Expose
    private Track track;
    @SerializedName("laps")
    @Expose
    private Integer laps;
    @SerializedName("raceName")
    @Expose
    private String raceName;
    @SerializedName("tookPlace")
    @Expose
    private Boolean tookPlace;
    @SerializedName("eventList")
    @Expose
    private EventList eventList;

    public Race(Category category, Track track, Integer laps, String raceName, Boolean tookPlace, EventList eventList) {
        this.category = category;
        this.track = track;
        this.laps = laps;
        this.raceName = raceName;
        this.tookPlace = tookPlace;
        this.eventList = eventList;
    }

    public Race() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Boolean getTookPlace() {
        return tookPlace;
    }

    public void setTookPlace(Boolean tookPlace) {
        this.tookPlace = tookPlace;
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

}