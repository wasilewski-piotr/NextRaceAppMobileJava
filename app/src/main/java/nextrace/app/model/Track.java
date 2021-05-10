package nextrace.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("turnCount")
    @Expose
    private String turnCount;
    @SerializedName("lapRecord")
    @Expose
    private String lapRecord;
    @SerializedName("personRecord")
    @Expose
    private String personRecord;

    public Track(String name, Country country, String layout, String length, String turnCount, String lapRecord, String personRecord) {
        this.name = name;
        this.country = country;
        this.layout = layout;
        this.length = length;
        this.turnCount = turnCount;
        this.lapRecord = lapRecord;
        this.personRecord = personRecord;
    }

    public Track() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(String turnCount) {
        this.turnCount = turnCount;
    }

    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
    }

    public String getPersonRecord() {
        return personRecord;
    }

    public void setPersonRecord(String personRecord) {
        this.personRecord = personRecord;
    }

}