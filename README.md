## First
This was my solution for my assignment in online Java course. My original repository for this assignment is private in organization group on GitHub and I imported my code to this repository.
This was a big assignment for me and I had to fix and improved my code many times including handling the cases when the users enter with the wrong format, the ID doesn't exist.
But git histories of methods, code related to case 1 - case 24 in each file are in an original private repository.
The result photos and what I used to build the application is at the end of this README.

---
### Level of Difficulty: Hard
### Title: Comprehensive Charity Organization Campaign Management System
### Overview:

In this assignment, you are tasked with creating a comprehensive Java application for a charity organization named "Helping Hands". The application will be used to manage a campaign to raise funds for various projects. The application should be able to track the details of the donors, the amount of donations received, the total funds raised, the specific projects that the donations are allocated to, and the volunteers who are working on these projects. The application should be console-based and should not have a user interface.

The application should be designed in a way that it can handle a large number of donors, volunteers, projects, and donations. It should also be able to perform various operations like adding, updating, deleting, and viewing the details of the donors, volunteers, projects, and donations. The application should also be able to calculate the total funds raised, the total funds raised for a specific project, and the average donation amount. It should also be able to find the top donor, the most active volunteer, the project that has received the most donations, and the project that has the most volunteers assigned.

The assignment is divided into three milestones: Bronze Achievement, Silver Achievement, and Golden Achievement. Each milestone has its own set of tasks and deadline.

### Bronze Achievement (Deadline: 2023/11/14)
1. **Donor Class:** Create a `Donor` class with attributes like name, contact number, and email address. This class will represent a donor in the system. Each donor should have a unique ID. The class should have methods to get and set the values of these attributes.

**Example:**:
*Input:* Add Donor: Name: John Doe, Contact Number: 1234567890, Email: johndoe@gmail.com
*Output:* Donor added successfully.

3. **Volunteer Class:** Create a `Volunteer` class with attributes like name, contact number, and email address. This class will represent a volunteer in the system. Each volunteer should have a unique ID. The class should have methods to get and set the values of these attributes.

**Example:**
*Input:* Add Volunteer: Name: Jane Smith, Contact Number: 0987654321, Email: janesmith@gmail.com
*Output:* Volunteer added successfully.

4. **Project Class:** Create a `Project` class with attributes like project name, project description, target amount, and assigned volunteers. This class will represent a project in the system. Each project should have a unique name. The class should have methods to get and set the values of these attributes.

**Example:**
*Input:* Add Project: Name: Clean Water Project, Description: Providing clean water to remote areas, Target Amount: $50000
*Output:* Project added successfully.

5. **Donation Class:** Create a `Donation` class with attributes like the donor's ID, the amount donated, the date of donation, and the project name. This class will represent a donation in the system. Each donation should have a unique ID. The class should have methods to get and set the values of these attributes.

**Example:**
*Input:* Add Donation: Donor ID: 1, Amount: $1000, Date: 2023/11/01, Project Name: Clean Water Project
*Output:* Donation added successfully.

### Silver Achievement (Deadline: 2023/11/16)
5. **Donors:** Create a `HashMap` to store the details of the donors with the donor's ID as the key and the donor object as the value. This will allow you to quickly access donor details using the donor's ID.

**Example:**
*Input:* Get Donor: ID: 1
*Output:* Donor Details: Name: John Doe, Contact Number: 1234567890, Email: johndoe@gmail.com


6. **Volunteers:** Create a `HashSet` to store the details of the volunteers. This will allow you to quickly access volunteer details and ensure that there are no duplicate volunteers.

**Example:**
*Input:* Get Volunteer: ID: 1
*Output:* Volunteer Details: Name: Jane Smith, Contact Number: 0987654321, Email: janesmith@gmail.com

7. **Projects:** Create a `TreeMap` to store the details of the projects with the project's name as the key and the project object as the value. This will allow you to quickly access project details using the project's name and keep the projects sorted.

**Example:**
*Input:* Get Project: Name: Clean Water Project
*Output:* Project Details: Description: Providing clean water to remote areas, Target Amount: $50000

8. **Donations:** Create a `LinkedList` to store the details of the donations. This will allow you to easily add and remove donations.

**Example:**
*Input:* Get Donation: ID: 1
*Output:* Donation Details: Donor ID: 1, Amount: $1000, Date: 2023/11/01, Project Name: Clean Water Project


### Golden Achievement (Deadline: 2023/11/20)
9. **Methods for Managing Details:** Implement methods to add, update, and delete donors, volunteers, projects, and donations. These methods will allow you to manage the details of the donors, volunteers, projects, and donations.

**Example:**
*Input:* Update Donor: ID: 1, New Contact Number: 1111111111
*Output:* Donor updated successfully.

10. **Methods for Viewing Details:** Implement methods to view all donors, volunteers, projects, and donations. These methods will allow you to display the details of the donors, volunteers, projects, and donations.

**Example:**
*Input:* View All Donors
*Output:* List of all donors.


11. **Method for Calculating Total Funds:** Implement a method to calculate the total funds raised. This method will allow you to calculate the total amount of donations.

**Example:**
*Input:* Calculate Total Funds
*Output:* Total funds raised: $1000

12. **Method for Calculating Project-Specific Funds:** Implement a method to calculate the total funds raised for a specific project. This method will allow you to calculate the total amount of donations for a specific project.

**Example:**
*Input:* Calculate Funds for Project: Clean Water Project
*Output:* Total funds raised for Clean Water Project: $1000

13. **Method for Assigning Volunteers:** Implement a method to assign volunteers to a specific project. This method will allow you to assign volunteers to a project.

**Example:**
*Input:* Assign Volunteer: Volunteer ID: 1, Project Name: Clean Water Project
*Output:* Volunteer assigned successfully.

14. **Method for Finding Top Donor:** Implement a method to find the top donor (the one who has donated the most). This method will allow you to identify the donor who has made the highest total donations.

**Example:**
*Input:* Find Top Donor
*Output:* Top Donor: John Doe


15. **Method for Finding Most Active Volunteer:** Implement a method to find the most active volunteer (the one who is assigned to the most projects). This method will allow you to identify the volunteer who is assigned to the most number of projects.

**Example:**
*Input:* Find Most Active Volunteer
*Output:* Most Active Volunteer: Jane Smith

16. **Method for Finding Most Funded Project:** Implement a method to find the project that has received the most donations. This method will allow you to identify the project that has received the highest total donations.

**Example:**
*Input:* Find Most Funded Project
*Output:* Most Funded Project: Clean Water Project

17. **Method for Finding Project with Most Volunteers:** Implement a method to find the project that has the most volunteers assigned. This method will allow you to identify the project that has the most number of volunteers assigned.

**Example:**
*Input:* Find Project with Most Volunteers
*Output:* Project with Most Volunteers: Clean Water Project

18. **Method for Calculating Average Donation:** Implement a method to find the average donation amount. This method will allow you to calculate the average amount of donations.

**Example:**
*Input:* Calculate Average Donation
*Output:* Average Donation: $1000

19. **Method for Calculating Total Numbers:** Implement a method to find the total number of donors, volunteers, projects, and donations. This method will allow you to calculate the total number of donors, volunteers, projects, and donations.

**Example:**
*Input:* Calculate Total Numbers
*Output:* Total Donors: 1, Total Volunteers: 1, Total Projects: 1, Total Donations: 1

20. **Method for Sorting Details:** Implement a method to sort the donors, volunteers, projects, and donations based on various attributes like name, amount donated, number of projects, etc. This method will allow you to sort the donors, volunteers, projects, and donations based on different attributes.

**Example:**
*Input:* Sort Donors by Name
*Output:* Sorted list of donors by name.

**Bonus (First Class Honors):**
- Implement a method to search for a donor, volunteer, project, or donation by their respective ID or name.
  **Example:**
  *Input:* Search for Donor: Name: John Doe
  *Output:* Donor Details: Name: John Doe, Contact Number: 1234567890, Email: johndoe@gmail.com

- Implement a method to export the details of the donors, volunteers, projects, and donations to a CSV file.
  **Example:**
  *Input:* Export Details to CSV
  *Output:* Details exported successfully.

- Implement a method to import the details of the donors, volunteers, projects, and donations from a CSV file.
  **Example:**
  *Input:* Import Details from CSV
  *Output:* Details imported successfully.

**Notes:**
- Make sure to validate the input data and handle exceptions appropriately.
- Use object-oriented programming concepts to develop the application.
- The application should not have a user interface. It should be a console-based application.

### Git Steps and Assignment Deadline
> 1.  Once you have completed your solution, commit your changes using the command  `git commit -m "Completed assignment"`.
> 2.  Push your changes to the repository using the command  `git push origin master`.
> 3.  Make sure to complete these steps before Wednesday, 21st November.



### Overview of Essential Java Collections for Assignment Implementation:

1. **HashMap:** HashMap is a part of the Java collections framework. It uses a technique called Hashing. HashMap contains values based on the key. It contains only unique elements. It may have one null key and multiple null values. It maintains no order. HashMap is non synchronized. It is not thread safe and can't be shared between many threads without proper synchronization code. HashMap is a good choice when we have to search, update or delete elements based on the key.

   **Example:**
   ```java
   HashMap<Integer, String> map = new HashMap<Integer, String>();
   map.put(1, "John Doe");
   map.put(2, "Jane Smith");
   System.out.println("Value for key 1 is: " + map.get(1));
   ```
   **Use Case:** In this assignment, HashMap is used to store the details of the donors with the donor's ID as the key and the donor object as the value. This allows quick access to donor details using the donor's ID.

2. **HashSet:** HashSet is a Set implementation that uses a hash table for storage. A HashSet is a collection of items where every item is unique, and it is found in the java.util package. It inherits the AbstractSet class and implements the Set interface.

   **Example:**
   ```java
   HashSet<String> set = new HashSet<String>();
   set.add("John Doe");
   set.add("Jane Smith");
   System.out.println("Set contains John Doe: " + set.contains("John Doe"));
   ```
   **Use Case:** In this assignment, HashSet is used to store the details of the volunteers. This allows quick access to volunteer details and ensures that there are no duplicate volunteers.

3. **TreeMap:** TreeMap in Java is a part of the Java Collection framework. It implements the NavigableMap interface and extends AbstractMap class. It is a Red-Black tree based NavigableMap implementation. In TreeMap, the elements are sorted in ascending order.

   **Example:**
   ```java
   TreeMap<String, String> map = new TreeMap<String, String>();
   map.put("Clean Water Project", "Providing clean water to remote areas");
   map.put("Education Project", "Providing education to underprivileged children");
   System.out.println("Project details for Clean Water Project: " + map.get("Clean Water Project"));
   ```
   **Use Case:** In this assignment, TreeMap is used to store the details of the projects with the project's name as the key and the project object as the value. This allows quick access to project details using the project's name and keeps the projects sorted.

4. **LinkedList:** LinkedList is a linear data structure which allows to insert and remove elements at the front and rear in constant time. LinkedList elements are not stored in contiguous locations like arrays, they are linked with each other using pointers.

   **Example:**
   ```java
   LinkedList<String> list = new LinkedList<String>();
   list.add("Donation1");
   list.add("Donation2");
   System.out.println("First donation in the list: " + list.get(0));
   ```
   **Use Case:** In this assignment, LinkedList is used to store the details of the donations. This allows easy addition and removal of donations.

Each of these collections has its own advantages and use cases, and they are chosen in this assignment based on the specific requirements of each task. For example, HashMap is chosen to store donor details because it allows quick access to elements using the key, HashSet is chosen to store volunteer details because it ensures that there are no duplicate volunteers, TreeMap is chosen to store project details because it keeps the elements sorted, and LinkedList is chosen to store donation details because it allows easy addition and removal of elements.


---

### The Result


### What I used


### What I used in Java    System.out.println("Volunteer Name: " + volunteer.getVolunteerName());
Access modifiers, Encapsulation, Constructor, Override, toString method, Static method, Static modifier