package in.novopay.magapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import in.novopay.magapplication.model.SportsMag;
import in.novopay.magapplication.network.SportsAPI;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bupeshkumar on 8/7/15.
 */
public class SportsActivity extends AppCompatActivity {

    private ListView listView;
    private TextView sportsTitle;
    private static final String TAG = "SportsActivity";
    MagazineAdapter magazineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_view);

        listView = (ListView) findViewById(R.id.corporate_listview);
        sportsTitle = (TextView) findViewById(R.id.magazine_id);
        if (sportsTitle != null)
            sportsTitle.setText("Sports Activity");
        else
            Log.d(TAG, "no id assigned");

        Log.d(TAG, "Calling API");
        SportsAPI.getApi().getSportList(new Callback<SportsMag>() {
            @Override
            public void success(SportsMag sportsMag, Response response) {
                magazineAdapter = new MagazineAdapter(SportsActivity.this, sportsMag.getResults().getCollection1());
                listView.setAdapter(magazineAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(SportsActivity.this, "Something didn;t the way we expected", Toast.LENGTH_SHORT);
            }
        });


    }

}
