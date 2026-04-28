/**
 * Class that represents an employee of J's Restaurant.
 * Includes information about the employee's ID, name, and shift.
 * Includes methods to log in and out of the system and to set the shift that an employee works.
 */
public class Employee {

    /** Employee's ID*/
    int employeeID;

    /** Employee's name*/
    String employeeName;

    /** Employee's work shift*/
    String shift;

    /**
     * Initializes a new employee object with the given ID, name, and shift.
     * @param employeeID Employee's ID
     * @param employeeName Employee's name
     * @param shift Employee's work shift
     */
    Employee(int employeeID, String employeeName, String shift){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.shift = shift;
    }

    /**
     *
     */
    public boolean login(){
    return true;
    }

    /**
     *
     */
    public void logout(){

    }

    /**
     *
     */
    public void setShift(){

    }

}
