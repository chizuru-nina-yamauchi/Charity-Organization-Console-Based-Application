package information_organize;

public class Volunteer {

    private int volunteerID;
    private String volunteerName;
    private int volunteerContactNumber;
    private String volunteerEmail;

    //constructor


    public Volunteer(String volunteerName, int volunteerContactNumber, String volunteerEmail) {

        this.volunteerName = volunteerName;
        this.volunteerContactNumber = volunteerContactNumber;
        this.volunteerEmail = volunteerEmail;
    }
    //getter and setter


    public int getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(int volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public int getVolunteerContactNumber() {
        return volunteerContactNumber;
    }

    public void setVolunteerContactNumber(int volunteerContactNumber) {
        this.volunteerContactNumber = volunteerContactNumber;
    }

    public String getVolunteerEmail() {
        return volunteerEmail;
    }

    public void setVolunteerEmail(String volunteerEmail) {
        this.volunteerEmail = volunteerEmail;
    }
    //toString


    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerID=" + volunteerID +
                ", volunteerName='" + volunteerName + '\'' +
                ", volunteerContactNumber=" + volunteerContactNumber +
                ", volunteerEmail='" + volunteerEmail + '\'' +
                '}';
    }
}
