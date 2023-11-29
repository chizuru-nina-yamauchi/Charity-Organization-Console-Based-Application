package information_organize;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private String projectDescription;
    private double projectTargetAmount;
    private List<Volunteer> projectAssignedVolunteers; // Store multiple volunteers in a list

    //constructor

    public Project(String projectName, String projectDescription, double projectTargetAmount) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectTargetAmount = projectTargetAmount;
        this.projectAssignedVolunteers = new ArrayList<>(); // Initialize the list
    }




    //getter and setter

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public double getProjectTargetAmount() {
        return projectTargetAmount;
    }

    public void setProjectTargetAmount(double projectTargetAmount) {
        this.projectTargetAmount = projectTargetAmount;
    }
    public List<Volunteer> getProjectAssignedVolunteers() {
        return projectAssignedVolunteers;
    }

    public void setProjectAssignedVolunteers(List<Volunteer> projectAssignedVolunteers) {
        this.projectAssignedVolunteers = projectAssignedVolunteers;
    }

    //toString


    @Override
    public String toString() {
        return "Project added successfully{" +
                "projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectTargetAmount=" + projectTargetAmount +
                ", projectAssignedVolunteers='" + projectAssignedVolunteers  + '\'' +
                '}';
    }
}
