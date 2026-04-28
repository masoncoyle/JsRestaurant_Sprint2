public class Table {
    private String tableID;
    private String tableStatus;
    private int section;

    Table(String tableID, int section, String tableStatus){
        this.tableID = tableID;
        this.section = section;
        this.tableStatus = tableStatus;
    }

    public void assignCustomer(){

    }
    public void markClean(){
        tableStatus = "CLEAN";
    }
    public void markDirty(){
        tableStatus = "DIRTY";
    }
    public void markOccupied(){
        tableStatus = "OCCUPIED";
    }
}
