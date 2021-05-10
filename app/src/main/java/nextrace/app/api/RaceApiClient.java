package nextrace.app.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RaceApiClient {
    public static String BASE_URL ="http://nextraceapp.com:8888/";
    private static Retrofit retrofit;
    public static Retrofit getRaces(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
