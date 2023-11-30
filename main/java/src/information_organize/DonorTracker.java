package information_organize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonorTracker {
    private final HashMap<Integer, Donor > donorObjects;

    public DonorTracker() {

        donorObjects =  new HashMap<>();
    }

    public void addDonorDetails(int donorID, Donor donor){
        donorObjects.put(donorID, donor);
    }

    public void deleteDonorDetails(int donorID){
        donorObjects.remove(donorID);
    }

    //implement the method of hasDonorID to check if the donor ID exist or there is no donor ID that the users entered.
    public boolean hasDonorID(int donorID){

        return donorObjects.containsKey(donorID);
    }

    public Donor getDonorByID(int donorID){
        return donorObjects.getOrDefault(donorID, null);
    }

    public void displayAllTheDonors(){
        for(Donor donor : donorObjects.values()){
            System.out.println(donor.toString());
        }
    }

    public int numberOfTotalDonors(){
        return donorObjects.size();
    }

    public List<Donor> sortDonorsByName() {
        List<Donor> sortedDonors = new ArrayList<>(donorObjects.values());

        // Sort donors by name
        sortedDonors.sort(Comparator.comparing(Donor::getDonorName));

        return sortedDonors;
    }

    public void exportDonorDetailsToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("DonorID,Name,ContactNumber,Email"); // CSV header

            for (Map.Entry<Integer, Donor> entry : donorObjects.entrySet()) {
                Donor donor = entry.getValue();
                writer.newLine();
                writer.write(donor.getDonorID() + "," +
                                 donor.getDonorName() + "," +
                                 donor.getDonorContactNumber() + "," +
                                 donor.getDonorEmail());
            }

            System.out.println("Details exported successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting details to CSV: " + e.getMessage());
        }
    }

    public void importDonorDetailsFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Parse the data and create Donor objects
                int donorID = Integer.parseInt(data[0]);
                String donorName = data[1];
                int donorContactNumber = Integer.parseInt(data[2]);
                String donorEmail = data[3];

                Donor donor = new Donor(donorName, donorContactNumber, donorEmail);
                donor.setDonorID(donorID);
                donorObjects.put(donorID, donor);
            }
            System.out.println("Details imported successfully from " + fileName);

            // Display imported information
            System.out.println("Imported Donor Information:");
            System.out.println("--------------");
            for (Map.Entry<Integer, Donor> entry : donorObjects.entrySet()) {
                Donor donor = entry.getValue();
                System.out.println("Donor ID: " + donor.getDonorID());
                System.out.println("Name: " + donor.getDonorName());
                System.out.println("Contact Number: " + donor.getDonorContactNumber());
                System.out.println("Email: " + donor.getDonorEmail());
                System.out.println("--------------");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing details from " + e.getMessage());
        }
    }

}
