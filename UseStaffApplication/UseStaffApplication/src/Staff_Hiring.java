public class Staff_Hiring extends Staff{
    public Staff_Hiring(int staffNumber, String location) {
        super(staffNumber, location);
    }
    public void printStaffHiring(){
        System.out.println();
        System.out.println("STAFF HIRING REPORT");
        System.out.println("*******************");
        System.out.println("STAFF NUMBER: " + getStaffNumber() + "\n" +
                "LOCATION: " + getStaffLocation() + "\n" +
                "HIRE STAFF: " + getStaffHiringProcess());
    }
}
