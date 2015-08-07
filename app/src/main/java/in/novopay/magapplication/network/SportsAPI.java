package in.novopay.magapplication.network;

import in.novopay.magapplication.model.SportsMag;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * Created by rohitshukla on 8/7/15.
 */
public class SportsAPI {

    public static final String URL = "https://www.kimonolabs.com/api";
    private static SportInterface sportInterface = null;

    public static SportInterface getApi() {
        if (sportInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(URL).build();

            sportInterface = restAdapter.create(SportInterface.class);
        }
        return sportInterface;
    }


    public interface SportInterface {
        @GET("/82ctzzs6?apikey=RsDgM8LIyKLUqdTelVtajUahTAB7SoOf")
        SportsMag getSportList();


        @GET("/82ctzzs6?apikey=RsDgM8LIyKLUqdTelVtajUahTAB7SoOf")
        void getSportList(Callback<SportsMag> musicAPIModelCallback);
    }

}