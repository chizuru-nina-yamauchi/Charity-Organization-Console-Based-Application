package information_input;

import information_organize.Donation;
import information_organize.DonationTracker;
import information_organize.Donor;
import information_organize.DonorTracker;
import information_organize.Project;
import information_organize.ProjectTracker;
import information_organize.Volunteer;
import information_organize.VolunteerTracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static int donorCounter = 0; // counter to generate unique donor IDs.
    private static int volunteerCounter = 0; // It is static to use in this whole across Main class
    private static int donationCounter = 0;
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner input = new Scanner(System.in);

        DonorTracker donorTracker = new DonorTracker();
        VolunteerTracker volunteerTracker = new VolunteerTracker();
        ProjectTracker projectTracker = new ProjectTracker();
        DonationTracker donationTracker = new DonationTracker();
        TreeMap<String, Project> projectObjects = new TreeMap<>();

        while(true){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Option: *Please add the information of option 1 - 4 before selecting option 5 - 28.");
            System.out.println("1. Add a donor's information.");
            System.out.println("2. Add a volunteer's information.");
            System.out.println("3. Add a project information.");
            System.out.println("4. Add a donation information.");
            System.out.println("5. Update a donor's information.");
            System.out.println("6. Update a volunteer's information.");
            System.out.println("7. Update a project information.");
            System.out.println("8. Update a donation information.");
            System.out.println("9. Delete a donor.");
            System.out.println("10. Delete a volunteer.");
            System.out.println("11. Delete a project.");
            System.out.println("12. Delete a donation.");
            System.out.println("13. Show all the donors.");
            System.out.println("14. Show all the volunteers.");
            System.out.println("15. Show all the projects.");
            System.out.println("16. Show all the donation.");
            System.out.println("17. Show the total amount of donations.");
            System.out.println("18. Show the total funds raised for a specific project.");
            System.out.println("19. Assign a volunteer to a project.");
            System.out.println("20. Show the top donor(the one that donated the most).");
            System.out.println("21. Show the most active Volunteer(the one that is assigned to the most projects.");
            System.out.println("22. Show the most funded project(the one that received the most donation).");
            System.out.println("23. Show the project with the most volunteer(the one that has the most volunteers assigned).");
            System.out.println("24. Show the average of the donation.");
            System.out.println("25. Calculate and show the total numbers of donors, volunteers, projects and donations.");
            System.out.println("26. Sort the donors, volunteers, projects and donations based on name, amount donated, number of projects.");
            System.out.println("27. Search a donor by ID or name / Search a volunteer by ID or name / Search a project by name / Search a donation by ID.");
            System.out.println("28. Export details of the donors, volunteers, projects, and donations to a CSV file.");
            System.out.println("29. Import the details of the donors, volunteers, projects, and donations from a CSV file.");
            System.out.println("30. Exist the system.");
            System.out.println("Choose your option: ");
            System.out.println("----------------------------------------------------------------------------------------");

            try {
                String optionInput = input.nextLine();
                int option = Integer.parseInt(optionInput);


                try {
                    switch (option) {
                        case 1:
                            System.out.println("Enter donor's name: ");
                            String donorName = input.nextLine();

                            System.out.println("Enter donor's contact number(Enter only numbers): ");
                            String donorContactNumberInput = input.nextLine();
                            int donorContactNumber = Integer.parseInt(donorContactNumberInput);

                            System.out.println("Enter donor's Email address: ");
                            String donorEmail = input.nextLine();

                            int uniqueDonorID = ++donorCounter; // generate donorID(key) for the new donor

                            Donor newDonor = new Donor(donorName, donorContactNumber, donorEmail);
                            newDonor.setDonorID(uniqueDonorID);
                            donorTracker.addDonorDetails(uniqueDonorID, newDonor);
                            System.out.println("Donor added successfully: " + newDonor);

                            break;

                        case 2:
                            System.out.println("Enter volunteer's name: ");
                            String volunteerName = input.nextLine();

                            System.out.println("Enter volunteer's contact number(Enter only numbers): ");
                            String volunteerContactNumberInput = input.nextLine();
                            int volunteerContactNumber = Integer.parseInt(volunteerContactNumberInput);

                            System.out.println("Enter volunteer's Email address: ");
                            String volunteerEmail = input.nextLine();

                            int uniqueVolunteerID = ++volunteerCounter;

                            Volunteer newVolunteer = new Volunteer(volunteerName, volunteerContactNumber, volunteerEmail);
                            newVolunteer.setVolunteerID(uniqueVolunteerID);
                            volunteerTracker.addVolunteerDetails(uniqueVolunteerID, newVolunteer);

                            System.out.println("Volunteer added successfully: " + newVolunteer);

                            break;

                        case 3:
                            System.out.println("Enter the project name.");
                            String projectName = input.nextLine();

                            System.out.println("Enter the project description.");
                            String projectDescription = input.nextLine();

                            System.out.println("Enter the target amount.");
                            String projectTargetAmountInput = input.nextLine();
                            double projectTargetAmount = Double.parseDouble(projectTargetAmountInput);

                            Project newProject = new Project(projectName, projectDescription, projectTargetAmount);
                            projectTracker.addProjectDetails(projectName, newProject);
                            System.out.println("Project added successfully: " + newProject);
                            break;

                        case 4:
                            System.out.println("Enter the Donor ID.");
                            String donorIDInput = input.nextLine();
                            int donorID = Integer.parseInt(donorIDInput);

                            if(donorTracker.hasDonorID(donorID)) {

                                System.out.println("Enter the project name for the donation.");
                                String projectNameForDonation = input.nextLine();

                                if(projectTracker.getProjectByName(projectNameForDonation) != null) {

                                    System.out.println("Enter the amount that the donor donated.");
                                    String donatedAmountInput = input.nextLine();
                                    double donatedAmount = Double.parseDouble(donatedAmountInput);

                                    System.out.println("Enter the date of donation with the format 'dd-mm-yyyy'.");
                                    String dateOfDonationInput = input.nextLine();
                                    LocalDate dateOfDonation = LocalDate.parse(dateOfDonationInput, formatter);

                                    int uniqueDonationID = ++donationCounter;

                                    Donation newDonation = new Donation(donorID, donatedAmount, dateOfDonation, projectNameForDonation);
                                    newDonation.setDonationID(uniqueDonationID);
                                    donationTracker.addDonationDetails(newDonation);
                                    System.out.println("Donation added successfully: " + newDonation);

                                }else{
                                    System.out.println("Project name not found." + "\n" + "Please make sure if you added the project name and information 'with option 3' first or make sure if the project name is correct.");
                                }
                            }else {
                                System.out.println("Donor ID not found." + "\n" + "Please make sure if you added the donor information first or make sure if the donor ID is correct.");
                            }

                            break;


                        case 5:
                            System.out.println("Enter the donor ID you want to update: ");
                            String donorIDToUpdateInput = input.nextLine();
                            int donorIDToUpdate = Integer.parseInt(donorIDToUpdateInput);
                            System.out.println("Current information for donor ID " + donorIDToUpdate + ": " + donorTracker.getDonorByID(donorIDToUpdate));

                            if (donorTracker.hasDonorID(donorIDToUpdate)) {
                                Donor donorToUpdate = donorTracker.getDonorByID(donorIDToUpdate);

                                boolean continueUpdatingDonor = true;

                                while (continueUpdatingDonor) {
                                    System.out.println("-------------------------------");
                                    System.out.println("Choose what you want to update:");
                                    System.out.println("1. Contact Number");
                                    System.out.println("2. Email Address");
                                    System.out.println("3. Exit");
                                    System.out.println("-------------------------------");
                                    int updateOptionDonor = Integer.parseInt(input.nextLine());

                                    switch (updateOptionDonor) {
                                        case 1:
                                            System.out.println("Enter the new contact number: ");
                                            String newContactNumberInput = input.nextLine();
                                            int newContactNumber = Integer.parseInt(newContactNumberInput);
                                            donorToUpdate.setDonorContactNumber(newContactNumber);
                                            System.out.println("Contact number updated successfully.");
                                            break;

                                        case 2:
                                            System.out.println("Enter the new email address: ");
                                            String newEmailAddress = input.nextLine();
                                            donorToUpdate.setDonorEmail(newEmailAddress);
                                            System.out.println("Email address updated successfully.");
                                            break;

                                        case 3:
                                            continueUpdatingDonor = false; // Exit the loop
                                            break;

                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }

                                System.out.println("Donor details updated successfully: " + donorToUpdate.toString());
                            } else {
                                System.out.println("Donor ID not found. Unable to update.");
                            }
                            break;


                        case 6:
                            System.out.println("Enter the volunteer ID you want to update: ");
                            String volunteerIDToUpdateInput = input.nextLine();
                            int volunteerIDToUpdate = Integer.parseInt(volunteerIDToUpdateInput);
                            System.out.println("Current information for volunteer ID " + volunteerIDToUpdate + ": " + volunteerTracker.getVolunteerByID(volunteerIDToUpdate));


                            if (volunteerTracker.hasVolunteerID(volunteerIDToUpdate)) {
                                Volunteer volunteerToUpdate = volunteerTracker.getVolunteerByID(volunteerIDToUpdate);

                                boolean continueUpdating = true;

                                while (continueUpdating) {
                                    System.out.println("-------------------------------");
                                    System.out.println("Choose what you want to update:");
                                    System.out.println("1. Contact Number");
                                    System.out.println("2. Email Address");
                                    System.out.println("3. Exit");
                                    System.out.println("-------------------------------");
                                    String updateOptionInput = input.nextLine();
                                    int updateOption = Integer.parseInt(updateOptionInput);

                                    switch (updateOption) {
                                        case 1:
                                            System.out.println("Enter the new contact number: ");
                                            String newContactNumberInput = input.nextLine();
                                            int newContactNumber = Integer.parseInt(newContactNumberInput);
                                            volunteerToUpdate.setVolunteerContactNumber(newContactNumber);
                                            System.out.println("Contact number updated successfully.");
                                            break;

                                        case 2:
                                            System.out.println("Enter the new email address: ");
                                            String newEmailAddress = input.nextLine();
                                            volunteerToUpdate.setVolunteerEmail(newEmailAddress);
                                            System.out.println("Email address updated successfully.");
                                            break;

                                        case 3:
                                            continueUpdating = false; // Exit the loop
                                            break;

                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }

                                System.out.println("Volunteer details updated successfully: " + volunteerToUpdate.toString());
                            } else {
                                System.out.println("Volunteer ID not found. Unable to update.");
                            }
                            break;

                        case 7:
                            System.out.println("Enter the project name you want to update: ");
                            String projectNameToUpdate = input.nextLine();
                            System.out.println("Current information for project " + projectNameToUpdate + ": " + projectTracker.getProjectByName(projectNameToUpdate));


                            if (projectTracker.hasProjectName(projectNameToUpdate)) {
                                Project projectToUpdate = projectTracker.getProjectByName(projectNameToUpdate);

                                boolean continueUpdatingProject = true;

                                while (continueUpdatingProject) {
                                    System.out.println("-------------------------------");
                                    System.out.println("Choose what you want to update:");
                                    System.out.println("1. Project Description");
                                    System.out.println("2. Target Amount");
                                    System.out.println("3. Exit");
                                    System.out.println("-------------------------------");
                                    int updateOptionProject = Integer.parseInt(input.nextLine());

                                    switch (updateOptionProject) {
                                        case 1:
                                            System.out.println("Enter the new project description: ");
                                            String newDescription = input.nextLine();
                                            projectToUpdate.setProjectDescription(newDescription);
                                            System.out.println("Project description updated successfully.");
                                            break;

                                        case 2:
                                            System.out.println("Enter the new target amount: ");
                                            String newTargetAmountInput = input.nextLine();
                                            double newTargetAmount = Double.parseDouble(newTargetAmountInput);
                                            projectToUpdate.setProjectTargetAmount(newTargetAmount);
                                            System.out.println("Target amount updated successfully.");
                                            break;

                                        case 3:
                                            continueUpdatingProject = false; // Exit the loop
                                            break;

                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }

                                System.out.println("Project details updated successfully: " + projectToUpdate.toString());
                            } else {
                                System.out.println("Project Name not found. Unable to update.");
                            }
                            break;


                        case 8:
                            System.out.println("Enter the donation ID you want to update: ");
                            String donationIDToUpdateInput = input.nextLine();
                            int donationIDToUpdate = Integer.parseInt(donationIDToUpdateInput);
                            System.out.println("Current information for donation ID " + donationIDToUpdate + ": " + donationTracker.getDonationByID(donationIDToUpdate));


                            if (donationTracker.hasDonationID(donationIDToUpdate)) {
                                Donation donationToUpdate = donationTracker.getDonationByID(donationIDToUpdate);

                                boolean continueUpdatingDonation = true;

                                while (continueUpdatingDonation) {
                                    System.out.println("-------------------------------");
                                    System.out.println("Choose what you want to update:");
                                    System.out.println("1. Donated Amount");
                                    System.out.println("2. Date of Donation");
                                    System.out.println("3. Exit");
                                    System.out.println("-------------------------------");
                                    int updateOptionDonation = Integer.parseInt(input.nextLine());

                                    switch (updateOptionDonation) {
                                        case 1:
                                            System.out.println("Enter the new donated amount: ");
                                            String newDonatedAmountInput = input.nextLine();
                                            double newDonatedAmount = Double.parseDouble(newDonatedAmountInput);
                                            donationToUpdate.setDonatedAmount(newDonatedAmount);
                                            System.out.println("Donated amount updated successfully.");
                                            break;

                                        case 2:
                                            System.out.println("Enter the new date of donation (dd-mm-yyyy): ");
                                            String newDateOfDonationInput = input.nextLine();
                                            LocalDate newDateOfDonation = LocalDate.parse(newDateOfDonationInput, formatter);
                                            donationToUpdate.setDateOfDonation(newDateOfDonation);
                                            System.out.println("Date of donation updated successfully.");
                                            break;

                                        case 3:
                                            continueUpdatingDonation = false; // Exit the loop
                                            break;

                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }

                                System.out.println("Donation details updated successfully: " + donationToUpdate.toString());
                            } else {
                                System.out.println("Donation ID not found. Unable to update.");
                            }
                            break;

                        case 9:
                            System.out.println("Enter the donor ID that you want to delete.");
                            int donorIDToDelete = Integer.parseInt(input.nextLine());
                            donorTracker.deleteDonorDetails(donorIDToDelete);
                            System.out.println("Donor (Donor ID: " + donorIDToDelete + ") deleted successfully.");

                            break;

                        case 10:
                            System.out.println("Enter the volunteer ID that you want to delete.");
                            String volunteerIDToDeleteInput = input.nextLine();
                            int volunteerIDToDelete = Integer.parseInt(volunteerIDToDeleteInput);
                            volunteerTracker.deleteVolunteer(volunteerIDToDelete);
                            System.out.println("Volunteer (Volunteer ID: " + volunteerIDToDelete+ ") deleted successfully.");
                            break;

                        case 11:
                            System.out.println("Enter the project name you want to delete.");
                            String projectNameToDelete = input.nextLine();
                            if (projectTracker.hasProjectName(projectNameToDelete)) {
                                projectTracker.deleteProject(projectNameToDelete);
                                System.out.println("Project '" + projectNameToDelete + "' deleted successfully.");
                            } else {
                                System.out.println("Project Name not found. Unable to delete.");
                            }
                            break;

                        case 12:
                            System.out.println("Enter the donation ID you want to delete: ");
                            String donationIDToDeleteInput = input.nextLine();
                            int donationIDToDelete = Integer.parseInt(donationIDToDeleteInput);

                            if (donationTracker.hasDonationID(donationIDToDelete)) {
                                donationTracker.deleteDonation(donationIDToDelete);
                                System.out.println("Donation ID " + donationIDToDelete + " deleted successfully.");
                            } else {
                                System.out.println("Donation ID not found. Unable to delete.");
                            }
                            break;

                        case 13:
                            System.out.println("Lists of all the donors and details.");
                            donorTracker.displayAllTheDonors();
                            break;

                        case 14:
                            System.out.println("Lists of all the volunteer and details.");
                            volunteerTracker.displayAllTheVolunteers();
                            break;

                        case 15:
                            System.out.println("List of all the projects and details.");
                            projectTracker.displayAllTheProjects();
                            break;

                        case 16 :
                            System.out.println("List of all the donations and details.");
                            donationTracker.displayAllTheDonations();
                            break;
                        case 17:
                            donationTracker.calculateTotalFund();
                            break;

                        case 18:
                            System.out.println("Enter the project name to calculate total funds: ");
                            String projectNameForTotalFund = input.nextLine();

                            double TotalFundForTheProject = donationTracker.calculateProjectFunds(projectNameForTotalFund);
                            System.out.println("Total funds raised for project " + projectNameForTotalFund + ": " + TotalFundForTheProject);

                            break;

                        case 19:
                            boolean continueAssigning = true;
                            while (continueAssigning) {
                                System.out.println("-------------------------------");
                                System.out.println("1. Assign Volunteer");
                                System.out.println("2. Exit");
                                System.out.println("Enter your choice: ");
                                System.out.println("-------------------------------");
                                String choiceForAssigningInput = input.nextLine();
                                int choiceForAssigning = Integer.parseInt(choiceForAssigningInput);

                                switch (choiceForAssigning) {
                                    case 1:
                                        System.out.println("Enter the Volunteer ID: ");
                                        String volunteerIDInput = input.nextLine();
                                        int volunteerID = Integer.parseInt(volunteerIDInput);

                                        System.out.println("Enter the Project Name: ");
                                        String projectNameToAssignVolunteer = input.nextLine();

                                        boolean isVolunteerFound = volunteerTracker.hasVolunteerID(volunteerID);
                                        boolean isProjectFound = projectTracker.hasProjectName(projectNameToAssignVolunteer);

                                        if (isVolunteerFound && isProjectFound) {
                                            Volunteer volunteer = volunteerTracker.getVolunteerByID(volunteerID);
                                            Project project = projectTracker.getProjectByName(projectNameToAssignVolunteer);
                                            List<Volunteer> assignedVolunteers = project.getProjectAssignedVolunteers();

                                            if (!assignedVolunteers.contains(volunteer)) {
                                                assignedVolunteers.add(volunteer);
                                                project.setProjectAssignedVolunteers(assignedVolunteers);
                                                System.out.println("Volunteer assigned successfully to " + projectNameToAssignVolunteer);
                                                System.out.println("Assigned Volunteer: " + volunteer.toString());
                                            } else {
                                                System.out.println("Volunteer is already assigned to " + projectNameToAssignVolunteer);
                                            }
                                        } else {
                                            if (!isVolunteerFound) {
                                                System.out.println("Volunteer ID not found. Unable to assign.");
                                            }
                                            if (!isProjectFound) {
                                                System.out.println("Project Name not found. Unable to assign.");
                                            }
                                        }
                                        break;
                                    case 2:
                                        continueAssigning = false;// Exit case 19
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please enter a valid option.");
                                        break;
                                }

                            }
                            break;

                        case 20:
                            donationTracker.topDonor();
                            break;

                        case 21:
                            projectTracker.mostAssignedVolunteer();
                            break;

                        case 22:
                            donationTracker.mostFundedProject();
                            break;

                        case 23:
                            projectTracker.projectWithMostVolunteer();
                            break;

                        case 24:
                            donationTracker.calculateAverageOfDonation();
                            break;

                        case 25:
                            int numberOfTotalDonors = donorTracker.numberOfTotalDonors();
                            System.out.println("Total number of donors: " + numberOfTotalDonors);

                            int numberOfTotalVolunteers = volunteerTracker.numberOfTotalVolunteers();
                            System.out.println("Total number of volunteers: " + numberOfTotalVolunteers);

                            int numberOfTotalProjects = projectTracker.numberOfTotalProjects();
                            System.out.println("Total number of projects: " + numberOfTotalProjects);

                            int numberOfTotalDonations = donationTracker.numberOfTotalDonations();
                            System.out.println("Total number of donations: " + numberOfTotalDonations);

                            break;

                        case 26:
                            System.out.println("Donors sorted by name(Alphabetically): " + "\n" + donorTracker.sortDonorsByName());
                            System.out.println("Volunteers sorted by name(Alphabetically): " + "\n" + volunteerTracker.sortVolunteersByName());
                            System.out.println("Projects sorted by name(Alphabetically):" + "\n" + projectTracker.sortProjectsByName());
                            System.out.println("Donation sorted by amount(from smaller amount to the bigger amount): " + "\n" + donationTracker.sortDonationsByAmount());
                            break;

                        case 27:
                            boolean continueSearching = true;
                            while (continueSearching) {
                                System.out.println("-------------------------------");
                                System.out.println("1. Search donor by ID");
                                System.out.println("2. Search volunteer by ID");
                                System.out.println("3. Search project by name");
                                System.out.println("4. Search donation by ID");
                                System.out.println("5. Exit");
                                System.out.println("Enter your choice: ");
                                System.out.println("-------------------------------");
                                String choiceForSearchingInput = input.nextLine();
                                int choiceForSearching = Integer.parseInt(choiceForSearchingInput);


                                switch (choiceForSearching) {
                                    case 1:
                                        System.out.println("Enter the donor ID: ");
                                        String donorIDToSearchInput = input.nextLine();
                                        int donorIDToSearch = Integer.parseInt(donorIDToSearchInput);

                                        boolean isDonorFound = donorTracker.hasDonorID(donorIDToSearch);
                                        if (isDonorFound) {
                                            System.out.println("Donor information for donor ID " + donorIDToSearch + "\n" + donorTracker.getDonorByID(donorIDToSearch));

                                        } else {
                                            System.out.println("Donor ID not found." + "\n" + "Please make sure if you added the donor information first or make sure if the donor ID is correct.");
                                        }

                                        break;

                                    case 2:
                                        System.out.println("Enter the volunteer ID: ");
                                        String volunteerIDToSearchInput = input.nextLine();
                                        int volunteerIDToSearch = Integer.parseInt(volunteerIDToSearchInput);

                                        boolean isVolunteerFound = volunteerTracker.hasVolunteerID(volunteerIDToSearch);
                                        if (isVolunteerFound) {
                                            System.out.println("Volunteer information for volunteer ID " + volunteerIDToSearch + "\n" + volunteerTracker.getVolunteerByID(volunteerIDToSearch));

                                        } else {
                                            System.out.println("Volunteer ID not found." + "\n" + "Please make sure if you added the volunteer information first or make sure if the volunteer ID is correct.");
                                        }

                                        break;

                                    case 3:
                                        System.out.println("Enter the project Name(*enter precisely ex:Lower case/Upper case/Space) : ");
                                        String projectNameToSearch = input.nextLine();

                                        boolean isProjectFound = projectTracker.hasProjectName(projectNameToSearch);
                                        if (isProjectFound) {
                                            System.out.println("Project information for project " + projectNameToSearch + "\n" + projectTracker.getProjectByName(projectNameToSearch));

                                        } else {
                                            System.out.println("Project name not found." + "\n" + "Please make sure if you added the project information first or make sure if the project name is correct.");
                                        }

                                        break;

                                    case 4:
                                        System.out.println("Enter the donation ID: ");
                                        String donationIDToSearchInput = input.nextLine();
                                        int donationIDToSearch = Integer.parseInt(donationIDToSearchInput);

                                        boolean isDonationFound = donationTracker.hasDonationID(donationIDToSearch);
                                        if (isDonationFound) {
                                            System.out.println("Donation information for donation ID " + donationIDToSearch + "\n" + donationTracker.getDonationByID(donationIDToSearch));

                                        } else {
                                            System.out.println("Donation ID not found." + "\n" + "Please make sure if you added the donation information first or make sure if the donation ID is correct.");
                                        }

                                        break;


                                    case 5:
                                        continueSearching = false;// Exit case 27
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please enter a valid option.");
                                        break;
                                }

                            }

                            break;

                        case 28:
                            System.out.println("Enter the file name to export donor details: ");
                            String donorFileName = input.nextLine();
                            donorTracker.exportDonorDetailsToCSV(donorFileName);

                            System.out.println("Enter the file name to export volunteer details: ");
                            String volunteerFileName = input.nextLine();
                            volunteerTracker.exportVolunteerDetailsToCSV(volunteerFileName);

                            System.out.println("Enter the file name to export project details: ");
                            String projectFileName = input.nextLine();
                            projectTracker.exportProjectDetailsToCSV(projectFileName);

                            System.out.println("Enter the file name to export donation details: ");
                            String donationFileName = input.nextLine();
                            donationTracker.exportDonationDetailsToCSV(donationFileName);
                            break;

                        case 29:
                            System.out.println("Enter the file name to import donors' information: ");
                            String fileNameToImportDonors = input.nextLine();
                            donorTracker.importDonorDetailsFromCSV(fileNameToImportDonors);

                            System.out.println("Enter the file name to import volunteers' information: ");
                            String fileNameToImportVolunteers = input.nextLine();
                            volunteerTracker.importVolunteerDetailsFromCSV(fileNameToImportVolunteers);

                            System.out.println("Enter the file name to import projects' information: ");
                            String fileNameToImportProjects = input.nextLine();
                            projectTracker.importProjectDetailsFromCSV(fileNameToImportProjects);

                            System.out.println("Enter the file name to import donations' information: ");
                            String fileNameToImportDonations = input.nextLine();
                            donationTracker.importDonationDetailsFromCSV(fileNameToImportDonations);
                            break;
                        case 30:
                            System.out.println("Exiting the system.");
                            System.exit(0);

                        default:
                            System.out.println("Enter tha valid number. Try again.");

                    }
                }catch(DateTimeParseException e){
                    System.out.println("Please enter the date with the right format 'dd-mm-yyyy'.");
                }

            }catch (NumberFormatException e){
                System.out.println("Invalid format. Try again with valid NUMBER.");
            }

        }
    }

}
