public abstract class Staff implements iStaff  {
    private final int staffNumber;
    private final String staffLocation;
    public Staff(int number, String location){
        staffLocation = location;
        staffNumber = number;
    }
    @Override
    public int getStaffNumber() {
        return staffNumber;
    }
    @Override
    public String getStaffLocation() {
        return staffLocation;
    }
    @Override
    public String getStaffHiringProcess() {
        String hireStaff = "NO";
        if(staffNumber < 20) {
            hireStaff = "YES";
        }
        return hireStaff;
    }
}