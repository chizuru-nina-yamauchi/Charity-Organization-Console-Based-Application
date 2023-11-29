package information_organize;

import java.util.HashSet;

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

    //implement the method of containsVolunteer to check if the volunteer ID exist or there is no donor ID that the users entered.
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

}


