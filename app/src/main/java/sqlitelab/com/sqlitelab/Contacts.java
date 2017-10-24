package sqlitelab.com.sqlitelab;

/**
 * Created by Joy on 10/19/2017.
 */

public class Contacts {
    int _id;
    String _name;
    String _phone_number;

    //empty constructor
    public Contacts() {


    }

    //constructor
    public Contacts(int id, String name, String _phone_number){
        this._id = id;
        this._name = name;
        this. _phone_number = _phone_number;
    }
    //constructor
    public Contacts(String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }
    //getting ID


    public int getId() {
        return _id;
    }
    //setting id


    public void setId(int _id) {
        this._id = _id;
    }
    //getting name

    public String getName() {
        return _name;
    }
    //Setting name

    public void setName(String _name) {
        this._name = _name;
    }
    //GET phone number

    public String getPhoneNumber() {
        return _phone_number;
    }

    //setting phone number

    public void setPhoneNumber(String _phone_number) {
        this._phone_number = _phone_number;
    }
}

