package information_organize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class VolunteerTracker {
    private final Set<Volunteer> volunteerObjects;

    public VolunteerTracker() {

        volunteerObjects = new HashSet<>();
    }

    public void addVolunteerDetails(int volunteerID, Volunteer volunteer){
        volunteerObjects.add(volunteer);
    }
    public void deleteVolunteer(int volunteerID){
        Volunteer volunteerToRemove = null;
        for (Volunteer volunteer : volunteerObjects) {
            if (volunteer.getVolunteerID() == volunteerID) {
                volunteerToRemove = volunteer;
                break;
            }
        }
        if (volunteerToRemove != null) {
            volunteerObjects.remove(volunteerToRemove);
            System.out.println("Volunteer removed successfully.");
        } else {
            System.out.println("Volunteer ID not found. Unable to remove.");
        }
    }

    //implement the method of hasVolunteerID to check if the volunteer ID exist or there is no donor ID that the users entered.
    public boolean hasVolunteerID(int volunteerID){
        for(Volunteer volunteer : volunteerObjects){
            if(volunteer.getVolunteerID() == volunteerID){
                return true;
            }
        }return false;
    }

    public Volunteer getVolunteerByID(int volunteerID){
        for(Volunteer volunteer : volunteerObjects){
            if(volunteer.getVolunteerID() == volunteerID){
                return volunteer;
            }
        }return null;
    }

    public void displayAllTheVolunteers(){
        for(Volunteer volunteer : volunteerObjects){
            System.out.println(volunteer.toString());
        }
    }

    public int numberOfTotalVolunteers(){
        return volunteerObjects.size();
    }

    public List<Volunteer> sortVolunteersByName() {
        List<Volunteer> sortedVolunteers = new ArrayList<>(volunteerObjects);

        // Sort volunteers by name
        sortedVolunteers.sort(Comparator.comparing(Volunteer::getVolunteerName));

        return sortedVolunteers;
    }

    public void exportVolunteerDetailsToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("VolunteerID,Name,ContactNumber,Email"); // CSV header

            for (Volunteer volunteer : volunteerObjects) {
                writer.newLine();
                writer.write(volunteer.getVolunteerID() + "," +
                                 volunteer.getVolunteerName() + "," +
                                 volunteer.getVolunteerContactNumber() + "," +
                                 volunteer.getVolunteerEmail());
            }

            System.out.println("Details exported successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting details to CSV: " + e.getMessage());
        }
    }

    public void importVolunteerDetailsFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Parse the data and create Volunteer objects
                int volunteerID = Integer.parseInt(data[0]);
                String volunteerName = data[1];
                int volunteerContactNumber = Integer.parseInt(data[2]);
                String volunteerEmail = data[3];

                Volunteer volunteer = new Volunteer(volunteerName, volunteerContactNumber, volunteerEmail);
                volunteer.setVolunteerID(volunteerID);
                volunteerObjects.add(volunteer);
            }
            System.out.println("Details imported successfully from " + fileName);

            System.out.println("Imported Volunteer Information:");
            System.out.println("--------------");
            for (Volunteer volunteer : volunteerObjects) {
                System.out.println("Volunteer ID: " + volunteer.getVolunteerID());
                System.out.println("Name: " + volunteer.getVolunteerName());
                System.out.println("Contact Number: " + volunteer.getVolunteerContactNumber());
                System.out.println("Email: " + volunteer.getVolunteerEmail());
                System.out.println("--------------");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error importing details from CSV: " + e.getMessage());
        }
    }


}


