package information_organize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProjectTracker {
    private final TreeMap<String, Project> projectObjects;

    public ProjectTracker() {

        projectObjects = new TreeMap<>();
    }

    public void addProjectDetails(String projectName, Project project){

        projectObjects.put(projectName, project);
    }
    public void deleteProject(String projectName) {
        projectObjects.remove(projectName);
    }



    //implement the method of containsDonor to check if the donor ID exist or there is no donor ID that the users entered.
    public boolean hasProjectName(String projectName){

        return projectObjects.containsKey(projectName);
    }

    public Project getProjectByName(String projectName){

        return projectObjects.getOrDefault(projectName, null);
    }

    public void displayAllTheProjects() {
        System.out.println("----------------------------");
        for (Project project : projectObjects.values()) {
            System.out.println("Project Name: " + project.getProjectName());
            System.out.println("Project Description: " + project.getProjectDescription());
            System.out.println("Project Target Amount: " + project.getProjectTargetAmount());
            System.out.println("Assigned Volunteers:");

            List<Volunteer> volunteers = project.getProjectAssignedVolunteers(); // not showing volunteers' contact number and email address for privacy reason and cleanness. There is another option to check all the volunteers' details if the users want to check.
            for (Volunteer volunteer : volunteers) {
                System.out.println("Volunteer ID: " + volunteer.getVolunteerID() + "  Volunteer Name: " + volunteer.getVolunteerName());
            }
            System.out.println("----------------------------");
        }
    }

    public void mostAssignedVolunteer(){
        Map<Integer, Integer> volunteerAssignmentCount = new HashMap<>(); // Map to track volunteer assigning count

        // Loop through all projects
        for(Project project : projectObjects.values()){
            List<Volunteer> volunteers = project.getProjectAssignedVolunteers();

            // Count assignments for each volunteer
            for(Volunteer volunteer : volunteers){
                int volunteerID = volunteer.getVolunteerID();
                volunteerAssignmentCount.put(volunteerID, volunteerAssignmentCount.getOrDefault(volunteerID, 0) + 1);
            }
        }

        // Find the volunteer assigned the most
        int mostAssignedVolunteerID = -1;
        int maxAssignments = 0;

        for(Map.Entry<Integer, Integer> entry : volunteerAssignmentCount.entrySet()){
            if(entry.getValue() > maxAssignments){
                maxAssignments = entry.getValue();
                mostAssignedVolunteerID = entry.getKey();
            }
        }

        // Display information about the most assigned volunteer
        if(mostAssignedVolunteerID != -1){

            System.out.println("Most Assigned Volunteer:");
            System.out.println("Volunteer ID: " + mostAssignedVolunteerID);
            System.out.println("Number of assigned projects: " + maxAssignments);
        } else {
            System.out.println("Information about the most assigned volunteer not found.");
        }
    }

    public void projectWithMostVolunteer() {
        Map<String, Integer> projectVolunteers = new HashMap<>();

        // Count volunteers per project
        for (Project project : projectObjects.values()) {
            String projectName = project.getProjectName();
            List<Volunteer> volunteers = project.getProjectAssignedVolunteers();

            // Count the number of volunteers for the project
            int numberOfVolunteers = volunteers.size();
            projectVolunteers.put(projectName, numberOfVolunteers);
        }

        String projectWithMostVolunteers = null;
        int maxVolunteers = 0;

        // Find the project with the most volunteers
        for (Map.Entry<String, Integer> entry : projectVolunteers.entrySet()) {
            if (entry.getValue() > maxVolunteers) {
                maxVolunteers = entry.getValue();
                projectWithMostVolunteers = entry.getKey();
            }
        }

        if (projectWithMostVolunteers != null) {
            System.out.println("Project with Most Volunteers:");
            System.out.println("Project Name: " + projectWithMostVolunteers);
            System.out.println("Total Volunteers: " + maxVolunteers);
        } else {
            System.out.println("No projects found with any volunteers.");
        }
    }






}
