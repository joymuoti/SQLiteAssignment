package sqlitelab.com.sqlitelab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listData;
    private List<Employee> grubData;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    */
        DatabaseHandler db = new DatabaseHandler(this);

        //inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContacts(new Contacts("Jojo", "1267808"));
        db.addContacts(new Contacts("Joy", "098654243"));
        db.addContacts(new Contacts("Lia", "9854325"));
        db.addContacts(new Contacts("noel", "97456323"));


        Log.d("Reading: ", "Reading all contacts..");
        List<Contacts> contacts = db.getAllContacts();

        for (Contacts cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " , Phone: " + cn.getPhoneNumber();

            Log.d("contacts " , log);
        }

        //inserting Employee details
        db.addEmployee(new Employee("CEO" , "Whole company"));
        db.addEmployee(new Employee("Manager" , "Finance"));
        db.addEmployee(new Employee("Cleaner" , "Housekeeping"));
        db.addEmployee(new Employee("Guard" , "Security"));


        //reading all contacts


        //reading all employee details
        Log.d("Reading: ", "Reading all employee details..");
        List<Employee> employee = db.getAllEmployee();



            for (Employee em : employee){
                String log = "Id: " + em.getID()+ "Role: " +em.getRole() + " , Department: " + em.getDepartment();

                Log.d("Employee ", log);
            }

        }

    }



