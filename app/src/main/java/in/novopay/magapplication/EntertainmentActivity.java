package in.novopay.magapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import in.novopay.magapplication.model.SportsMag;
import in.novopay.magapplication.network.EntertainmentAPI;
import in.novopay.magapplication.network.SportsAPI;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by bupeshkumar on 8/7/15.
 */
public class EntertainmentActivity extends AppCompatActivity {

    private ListView listView;
    private TextView entertainmentTitle;
    private ProgressBar progressBar ;
    private static final String TAG = "EntertainmentActivity";
    MagazineAdapter magazineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment_view);

        listView = (ListView) findViewById(R.id.corporate_listview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar) ;
        if (entertainmentTitle != null)
            entertainmentTitle.setText("Entertainment Activity");
        else
            Log.d(TAG, "no id assigned");

        Log.d(TAG, "Calling API");
        new EntertainmentAsyncTask().execute() ;
        /*EntertainmentAPI.getApi().getEntertainmentList(new Callback<SportsMag>() {
            @Override
            public void success(SportsMag sportsMag, Response response) {
                magazineAdapter = new MagazineAdapter(EntertainmentActivity.this, sportsMag.getResults().getCollection1());
                listView.setAdapter(magazineAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(EntertainmentActivity.this, "Something didn;t the way we expected", Toast.LENGTH_SHORT);
            }
        });
*/

    }

    class EntertainmentAsyncTask extends AsyncTask<Void, Integer, SportsMag> {

        @Override
        protected SportsMag doInBackground(Void... params) {
            Log.d(TAG, "OnPost Execute");
            return EntertainmentAPI.getApi().getEntertainmentList();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(SportsMag sportsMag) {
            Log.d(TAG, "OnPost Execute");
            magazineAdapter = new MagazineAdapter(EntertainmentActivity.this, sportsMag.getResults().getCollection1());
            listView.setAdapter(magazineAdapter);
            progressBar.setVisibility(View.GONE);
            super.onPostExecute(sportsMag);
        }
    }


}
