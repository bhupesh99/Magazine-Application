package in.novopay.magapplication.network;

import in.novopay.magapplication.model.SportsMag;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by rohitshukla on 8/7/15.
 */
public class EntertainmentAPI {
    public static final String URL = "https://www.kimonolabs.com/api";
    private static EntertainmentInterface entertainmentInterface = null;

    public static EntertainmentInterface getApi() {
        if (entertainmentInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(URL).build();

            entertainmentInterface = restAdapter.create(EntertainmentInterface.class);
        }
        return entertainmentInterface;
    }

    public interface EntertainmentInterface {
        @GET("api/2ngljkcw?apikey=RsDgM8LIyKLUqdTelVtajUahTAB7SoOf")
        SportsMag getEntertainmentList();


        @GET("/api/2ngljkcw?apikey=RsDgM8LIyKLUqdTelVtajUahTAB7SoOf")
        void getEntertainmentList(retrofit.Callback<SportsMag> musicAPIModelCallback);
    }
}