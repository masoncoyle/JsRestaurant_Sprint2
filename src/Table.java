public class Table {
    private String tableID;
    public String tableStatus;
    public int section;

    Table(String tableID, int section, String tableStatus){
        this.tableID = tableID;
        this.section = section;
        this.tableStatus = tableStatus;
    }

    public String getTableID(){
        return this.tableID;
    }
    public int getSection(){
        return this.section;
    }
    public String getTableStatus(){
        return this.tableStatus;
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
