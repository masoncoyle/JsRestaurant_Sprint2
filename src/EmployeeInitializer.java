import java.util.*;
import java.io.*;

public class EmployeeInitializer {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Employee currentUser = null;

    public static void addEmployees() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("EmployeeData.csv"));
        String line;
        while ((line = reader.readLine()) != null){
            String[] dataFields = line.split(",");
            if (dataFields[7].equals("WAITER")){
                Waiter newWaiter = new Waiter(
                        Integer.parseInt(dataFields[0]),
                        dataFields[1],
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        dataFields[5],
                        Integer.parseInt(dataFields[6]));
                employees.add(newWaiter);
            }
        }
        reader.close();
    }
}
