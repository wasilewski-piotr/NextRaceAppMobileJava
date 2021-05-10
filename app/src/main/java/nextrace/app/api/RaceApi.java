package nextrace.app.api;

import java.util.List;

import nextrace.app.model.Category;
import nextrace.app.model.Race;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RaceApi {
    @GET("/api/races")
    Call<List<Race>> getRaces();

    @GET("/api/races/category/Formula 1")
    Call<List<Race>> getRacesFormula1();

    @GET("/api/races/category/Formula 2")
    Call<List<Race>> getRacesFormula2();

    @GET("/api/races/category/Formula 3")
    Call<List<Race>> getRacesFormula3();

    @GET("/api/races/category/Formula E")
    Call<List<Race>> getRacesFormulaE();

    @GET("/api/races/category/Deutsche Tourenwagen Masters")
    Call<List<Race>> getRacesDTM();

    @GET("/api/races/category/{category}")
    Call<List<Race>> getRacesByCategoryName(@Path(value = "category", encoded = true)String value);

    @GET("/api/races/country/{country}")
    Call<List<Race>> getRacesByCountryName(@Path(value = "country", encoded = true)String value);

    @GET("/api/races/track/{name}")
    Call<List<Race>> getRacesByTrackName(@Path(value = "name", encoded = true)String value);

}
