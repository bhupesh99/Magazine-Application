package in.novopay.magapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import in.novopay.magapplication.provider.UserSQLiteOpenHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText userEmailEditText ;
    private EditText userPhoneEditText ;
    private Button loginButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmailEditText = (EditText) findViewById(R.id.emailid) ;
        userPhoneEditText = (EditText) findViewById(R.id.password) ;
        loginButton = (Button) findViewById(R.id.login) ;

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkUser(userEmailEditText.getText().toString(), userPhoneEditText.getText().toString()) == true) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class) ;
                    intent.putExtra(MainActivity.PHONE_NO, userPhoneEditText.getText().toString()) ;
                    startActivity(intent);
                }
                else {
                    Log.d("LoginActivity", "Security Breach: NOT GONNA HAPPEN") ;
                    Toast.makeText(LoginActivity.this, "Invalid username/password Combination", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkUser(String email, String password) {
        UserSQLiteOpenHelper userSQLiteOpenHelper = new UserSQLiteOpenHelper(LoginActivity.this) ;
        SQLiteDatabase db = userSQLiteOpenHelper.getReadableDatabase() ;
        final Cursor cursor = db.query(UserSQLiteOpenHelper.Tables.USER, null, null, null, null, null, null) ;
        cursor.moveToPosition(0) ;
        do {
            String emailDB = cursor.getString(cursor.getColumnIndex(UserSQLiteOpenHelper.TableUser.EMAIL_ID)) ;
            String passwordDB = cursor.getString(cursor.getColumnIndex(UserSQLiteOpenHelper.TableUser.PASSWORD)) ;

            if(emailDB.equals(email) && passwordDB.equals(password)) return true ;
        } while (cursor.moveToNext()) ;

        return false ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
