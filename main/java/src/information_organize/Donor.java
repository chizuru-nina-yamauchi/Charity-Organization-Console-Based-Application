package information_organize;

public class Donor {
    private int donorID;
    private String donorName;
    private int donorContactNumber;
    private String donorEmail;

    //constructor

    public Donor(String donorName, int donorContactNumber, String donorEmail) { // donorID is generated after the user enter the input of these three elements.
        this.donorName = donorName;
        this.donorContactNumber = donorContactNumber;
        this.donorEmail = donorEmail;
    }

    //getter and setter
    public int getDonorID() {
        return donorID;
    }

    public void setDonorID(int donorID) {
        this.donorID = donorID;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public int getDonorContactNumber() {
        return donorContactNumber;
    }

    public void setDonorContactNumber(int donorContactNumber) {
        this.donorContactNumber = donorContactNumber;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "donorID=" + donorID +
                ", donorName='" + donorName + '\'' +
                ", donorContactNumber=" + donorContactNumber +
                ", donorEmail='" + donorEmail + '\'' +
                '}';
    }
}
