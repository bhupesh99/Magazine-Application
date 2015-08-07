package in.novopay.magapplication.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by bupeshkumar on 8/7/15.
 */
public class UserSQLiteOpenHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DATABAE_NAME = "userdb";

    public interface Tables {
        String USER = "user";
    }

    public interface TableUser {
        String EMAIL_ID = "emailid";
        String MOBILE_NO = "mobileno";
        String PASSWORD = "password";
    }

    public UserSQLiteOpenHelper(Context context) {
        super(context, DATABAE_NAME, null, VERSION);
    }

    final String CREATE_TABLE_USER = "CREATE TABLE " + Tables.USER + "("
            + BaseColumns._ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TableUser.EMAIL_ID + " TEXT NOT NULL UNIQUE, "
            + TableUser.MOBILE_NO + " TEXT NOT NULL UNIQUE, "
            + TableUser.PASSWORD + " TEXT NOT NULL UNIQUE);" ;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        ContentValues contentValues = new ContentValues() ;
        contentValues.put(TableUser.EMAIL_ID, "bhupeshkumar99@gmail.com");
        contentValues.put(TableUser.MOBILE_NO, "9882681450");
        contentValues.put(TableUser.PASSWORD, "9882681450");
        db.insert(Tables.USER, null, contentValues) ;

        contentValues.put(TableUser.EMAIL_ID, "rohit@novopay.in");
        contentValues.put(TableUser.MOBILE_NO, "8894855313");
        contentValues.put(TableUser.PASSWORD, "8894855313");
        db.insert(Tables.USER, null, contentValues) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
