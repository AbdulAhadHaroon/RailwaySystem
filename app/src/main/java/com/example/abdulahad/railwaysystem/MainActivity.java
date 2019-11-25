package com.example.abdulahad.railwaysystem;

/*import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    TextView t;

    static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com/sql12230847";
    static final String USER = "sql12230847";
    static final String PASS = "RkU8Zk8pzi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrieve r =new Retrieve();
        r.execute();



    }


    class Retrieve extends AsyncTask<String, String, String> {


        String Data;
        ProgressDialog p = new ProgressDialog(MainActivity.this);

        @Override
        public void onPreExecute() {

            //   Data.setText("please wait for view data");

            // Errors.setText(""+Err);
            // Data.setText(""+Dat);


            ProgressDialog p = new ProgressDialog(MainActivity.this);
            p.setTitle("get");
            p.setMessage("Loading ....");
            p.show();



        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement ps = null;
                if (connection == null) {

                    Data = "connection not found";

                } else {

                    String query = "select * from User";
                    ps = connection.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Data = "" + rs.getString("U_Name");
                    }

                }
                connection.close();
            } catch (Exception e) {

                Data = "connection goes wrong ";
                e.printStackTrace();

            }

            return Data;
        }

        @Override
        public void onPostExecute(String Dat) {
//            Data.setText("" + Dat);
            //          Errors.setText("" + Err);
            p.cancel();
            Toast.makeText(MainActivity.this , ""+Data , Toast.LENGTH_SHORT).show();

        }
    }


}*/




        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    TextView Data , Errors;

    String Dat , Err;

    EditText editText;

    static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com/sql12231412";
    static final String USER = "sql12231412";
    static final String PASS = "jP1N7TF8QN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Errors = (TextView)findViewById(R.id.error);
        Data = (TextView)findViewById(R.id.data);

        Retrieve R= new Retrieve();
        R.execute("");
    }


    class Retrieve extends AsyncTask<String , String , String>{




        @Override
        public void onPreExecute() {

            Data.setText("please wait for view data");

            Errors.setText(""+Err);
            Data.setText(""+Dat);

        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection= DriverManager.getConnection(DB_URL ,USER , PASS);
                PreparedStatement ps=null;
                if(connection==null){

                    Dat="connection not found";

                }else{

                    String query="select * from User";
                    ps=connection.prepareStatement(query);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        Err=""+rs.getString("U_Name");
                    }

                }
                connection.close();
            } catch (Exception e) {

                Dat="connection to wrong " ;
                e.printStackTrace();

            }

            return Dat;
        }

        @Override
        public void onPostExecute(String Dat){
            Data.setText(""+Dat);
            Errors.setText(""+Err);

        }
    }
}



