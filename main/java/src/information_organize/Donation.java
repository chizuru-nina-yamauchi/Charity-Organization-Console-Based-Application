package information_organize;

import java.time.LocalDate;

public class Donation {
    //encapsulates data with private fields

    private int donationID;
    private int donationDonorID;
    private double donatedAmount;
    private LocalDate dateOfDonation;
    private String projectNameForDonation;

    //constructor


    public Donation(int donationDonorID, double donatedAmount, LocalDate dateOfDonation, String projectNameForDonation) {
        this.donationDonorID = donationDonorID;
        this.donatedAmount = donatedAmount;
        this.dateOfDonation = dateOfDonation;
        this.projectNameForDonation = projectNameForDonation;
    }

    //getter and setter
    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public int getDonationDonorID() {
        return donationDonorID;
    }

    public void setDonationDonorID(int donationDonorID) {
        this.donationDonorID = donationDonorID;
    }

    public double getDonatedAmount() {
        return donatedAmount;
    }

    public void setDonatedAmount(double donatedAmount) {
        this.donatedAmount = donatedAmount;
    }

    public LocalDate getDateOfDonation() {
        return dateOfDonation;
    }

    public void setDateOfDonation(LocalDate dateOfDonation) {
        this.dateOfDonation = dateOfDonation;
    }

    public String getProjectNameForDonation() {
        return projectNameForDonation;
    }

    public void setProjectNameForDonation(String projectNameForDonation) {
        this.projectNameForDonation = projectNameForDonation;
    }

    //toString


    @Override
    public String toString() {
        return "Donation{" +
                "donationID=" + donationID +
                ", donationDonorID=" + donationDonorID +
                ", amountDonated=" + donatedAmount +
                ", dateOfDonation=" + dateOfDonation +
                ", projectName='" + projectNameForDonation + '\'' +
                '}';
    }
}
