package nextrace.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.net.URL;


public class Category {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("categoryLogo")
    @Expose
    private URL categoryLogo;
    @SerializedName("categoryOfficialCalendarURL")
    @Expose
    private String categoryOfficialCalendarURL;
    @SerializedName("categoryHexColor")
    @Expose
    private String categoryHexColor;

    public Category(String categoryName, URL categoryLogo, String categoryOfficialCalendarURL, String categoryHexColor) {
        this.categoryName = categoryName;
        this.categoryLogo = categoryLogo;
        this.categoryOfficialCalendarURL = categoryOfficialCalendarURL;
        this.categoryHexColor = categoryHexColor;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public URL getCategoryLogo() {
        return categoryLogo;
    }

    public void setCategoryLogo(URL categoryLogo) {
        this.categoryLogo = categoryLogo;
    }

    public String getCategoryOfficialCalendarURL() {
        return categoryOfficialCalendarURL;
    }

    public void setCategoryOfficialCalendarURL(String categoryOfficialCalendarURL) {
        this.categoryOfficialCalendarURL = categoryOfficialCalendarURL;
    }

    public String getCategoryHexColor() {
        return categoryHexColor;
    }

    public void setCategoryHexColor(String categoryHexColor) {
        this.categoryHexColor = categoryHexColor;
    }
}