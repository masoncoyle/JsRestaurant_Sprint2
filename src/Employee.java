/**
 * Class that represents an employee of J's Restaurant.
 * Includes information about the employee's ID, name, and shift.
 * Includes methods to log in and out of the system and to set the shift that an employee works.
 */
public class Employee {

    /** Employee's ID*/
    int employeeID;

    /** Employee's first name*/
    String firstName;

    /** Employee's last name*/
    String lastName;

    /** Employee's username*/
    String username;

    /** Employee's password*/
    String password;

    /** Employee's work shift*/
    String shift;
    /**
     * Initializes a new employee object with the given ID, name, and shift.
     * @param employeeID Employee's ID
     * @param firstName Employee's first name
     * @param lastName Employee's first name
     * @param username Employee's username
     * @param password Employee's password
     * @param shift Employee's work shift
     */
    Employee(int employeeID, String firstName, String lastName, String shift, String username, String password){
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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
