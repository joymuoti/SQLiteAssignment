package sqlitelab.com.sqlitelab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by Joy on 10/19/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    //All Static variables
    //Database Version
    private static final int DATABASE_VERSION =1;

    //Database Name
    private static final String DATABASE_NAME = "contactsManager";

    //contacts table column names
    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_EMPLOYEE = "employee";


    //Contacts Table Column Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    //Employee Table Columns
    private static final String KEY_ROLE = "role";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_SALARY = "salary";

    private static final String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_PH_NO + " TEXT " + ")";

    private static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE + "(" + KEY_ROLE + " TEXT, " + KEY_DEPARTMENT +  " TEXT, " + KEY_SALARY + " TEXT" + ")";



    public DatabaseHandler(Context context)
    {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //CREATING TABLES
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_CONTACTS_TABLE);

        db.execSQL(CREATE_EMPLOYEE_TABLE);
    }

    //Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);

        //Create tables again
        onCreate(db);
    }

    //Adding new contacts
    public void addContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_NO, contacts.getPhoneNumber());

        //insertingRow
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); //closing database connection
    }

    //getting single contact
    public Contacts getContacts(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + " = ? ", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contacts contacts = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
        return contacts;
    }


    //getting all contact
    public List<Contacts> getAllContacts(){
        List<Contacts> contactList = new ArrayList<Contacts>();
        //select all array
        String selectQuery = " SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping thru all rows and adding to thelist
        if(cursor.moveToFirst()){
            do {
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhoneNumber(cursor.getString(2));
                //adding contact to list
                contactList.add(contacts);
            }while (cursor.moveToNext());
        }
        return contactList;
    }

    //updating contacts count
    public int getContactsCount(){
        String countQuery = " SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();
    }

    //updating single contact
    public int updateContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_NO, contacts.getPhoneNumber());

        //updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[]{ String.valueOf(contacts.getId())});
    }

    //deleting single contact
    public void deleteContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ? ", new String[] {String.valueOf(contacts.getId())});
        db.close();
    }

    //ADD NEW EMPLOYEE
    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROLE, employee.getRole());
        values.put(KEY_DEPARTMENT, employee.getDepartment());
        // values.put(KEY_SALARY, employee.getSalary());

        //insertingRow
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); //closing database connection
    }



    public Employee getEmployee(String role){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_EMPLOYEE, new String[] { KEY_ROLE, KEY_DEPARTMENT,KEY_SALARY},KEY_ID + " = ? ", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(cursor.getString(0)));
        employee.setRole(cursor.getString(1));
        employee.setDepartment(cursor.getString(2));
        return employee;
    }

    //getting all details
    public List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<Employee>();
        //select all array
        String selectQuery = " SELECT * FROM " + TABLE_EMPLOYEE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping thru all rows and adding to the list
        if(cursor.moveToFirst()){
            do {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(cursor.getString(0)));
                employee.setRole(cursor.getString(1));
                employee.setDepartment(cursor.getString(2));
               // employee.setSalary(cursor.getDouble(2));
                //adding employee details to list
                employeeList.add(employee);
            }while (cursor.moveToNext());
        }
        return employeeList;
    }

    //updating detail count
    public int getEmployeeCount(){
        String countQuery = " SELECT * FROM " + TABLE_EMPLOYEE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();
    }

    //updating single employee
    public int updateEmployee(Employee employee){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROLE, employee.getRole());
        values.put(KEY_DEPARTMENT, employee.getDepartment());
       // values.put(KEY_SALARY, employee.getSalary());

        //updating row
        return db.update(TABLE_EMPLOYEE, values, KEY_ID + " = ?", new String[]{ String.valueOf(employee.getRole())});
    }

    //deleting single detail
    public void deleteEmployee(Employee employee){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEE, KEY_ID + " = ? ", new String[] {String.valueOf(employee.getRole())});
        db.close();
    }



    }


