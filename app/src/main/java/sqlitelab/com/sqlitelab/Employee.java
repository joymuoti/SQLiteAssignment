package sqlitelab.com.sqlitelab;

/**
 * Created by Joy on 10/23/2017.
 */

public class Employee {

        int id;
        String _role;
        static String _department;
        static double _salary;

        //empty constructor
        public Employee() {

        }


        //constructor
        public Employee(String _role, String _department, int id){
            this._role = _role;
            this._department = _department;
            this. _salary = _salary;
            this.id = id;
        }

        //constructor
        public Employee( String _department,  String role){
            this._department = _department;
            this._role = role;
        }

        //getting ID


        public String getRole() {
            return _role;
        }
        //setting id


        public void setRole(String _role) {
            this._role = _role;
        }
        //getting name
    public  int getID(){

        return id;
    }
    public void setId(int id){
        this.id = id;
    }

        public  String getDepartment() {
            return _department;
        }
        //Setting name

        public void setDepartment(String _department) {
            this._department = _department;
        }

        //public static double getSalary() { return _salary; }
        //setting salary
       // public void setSalary(double _salary) { this._salary = _salary;}
    }



