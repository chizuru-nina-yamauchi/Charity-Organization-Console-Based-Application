package information_organize;

import java.util.*;

public class DonationTracker {

    private final List<Donation> donationObjects;

    public DonationTracker() {
        donationObjects = new LinkedList<>();
    }

    public void addDonationDetails(Donation donation) {

        donationObjects.add(donation);
    }

    public void deleteDonation(int donationID) {
        for (Donation donation : donationObjects) {
            if (donation.getDonationID() == donationID) {
                donationObjects.remove(donation);
                break; // Exit the loop after deletion
            }
        }
    }

    public boolean hasDonationID(int donationID) {
        for (Donation donation : donationObjects) {
            if (donation.getDonationID() == donationID) {
                return true;
            }
        }
        return false;
    }

    public Donation getDonationByID(int donationID) {
        for (Donation donation : donationObjects) {
            if (donation.getDonationID() == donationID) {
                return donation;
            }
        }
        return null;
    }


    public void displayAllTheDonations() {
        for (Donation donation : donationObjects) {
            System.out.println(donation.toString());
        }
    }

    public void calculateTotalFund() {
        double totalFunds = 0.0;

        for (Donation donation : donationObjects) {
            totalFunds += donation.getDonatedAmount();
        }

        System.out.println("Total Funds Raised: " + totalFunds);
    }

    public double calculateProjectFunds(String projectName) {
        double projectFunds = 0.0;

        for (Donation donation : donationObjects) {
            if (donation.getProjectNameForDonation().equals(projectName)) {
                projectFunds += donation.getDonatedAmount();
            }
        }

        return projectFunds;
    }

    public void topDonor() {
        // Map to store the total donations per donor
        Map<Integer, Double> donorDonations = new HashMap<>();

        for (Donation donation : donationObjects) {
            int donorID = donation.getDonationDonorID();
            double donationAmount = donation.getDonatedAmount();

            donorDonations.merge(donorID, donationAmount, Double::sum);
        }


        int topDonorID = -1;
        double maxDonation = 0.0;

        // Find the top donor with the highest donation amount
        for (Map.Entry<Integer, Double> entry : donorDonations.entrySet()) {
            if (entry.getValue() > maxDonation) {
                maxDonation = entry.getValue();
                topDonorID = entry.getKey();
            }
        }

        if (topDonorID != -1) {

            System.out.println("Top Donor:");
            System.out.println("Donor ID: " + topDonorID);
            System.out.println("Total Donations: " + maxDonation);
        } else {
            System.out.println("Top donor information not found.");
        }

    }

    public void mostFundedProject() {
        Map<String, Double> projectDonations = new HashMap<>();

        // Calculate total donations per project
        for (Donation donation : donationObjects) {
            String projectName = donation.getProjectNameForDonation();
            double donationAmount = donation.getDonatedAmount();

            // Update the total donation for the project using merge
            projectDonations.merge(projectName, donationAmount, Double::sum);
        }

        String topProject = null;
        double maxDonation = 0.0;

        // Find the project with the highest total donation amount
        for (Map.Entry<String, Double> entry : projectDonations.entrySet()) {
            if (entry.getValue() > maxDonation) {
                maxDonation = entry.getValue();
                topProject = entry.getKey();
            }
        }

        if (topProject != null) {
            System.out.println("Most Funded Project:");
            System.out.println("Project Name: " + topProject);
            System.out.println("Total Donations: " + maxDonation);
        } else {
            System.out.println("No donations found for any project.");
        }
    }

    public void calculateAverageOfDonation() {
        double totalFunds = 0.0;
        int donationCount = donationObjects.size(); // Count the number of donations

        for (Donation donation : donationObjects) {
            totalFunds += donation.getDonatedAmount();
        }

        if (donationCount > 0) {
            double averageOfDonation = totalFunds / donationCount;
            System.out.println("Average Of Donation: " + averageOfDonation);
        } else {
            System.out.println("No donations found to calculate the average.");
        }
    }



}