public class Waiter extends Employee{
    public int section;

    Waiter(int employeeID, String firstName, String lastName, String username, String password, String shift, int section){
        super(employeeID, firstName, lastName, username, password, shift);
        this.section = section;
    }
}
