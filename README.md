# College-ERP-Portal
A user-friendly CLI based system where students register for courses, view grades, and give feedback; professors manage courses and review feedback; and admins handle student records and course details seamlessly.

Steps to Run this program:

(I have taken three students and two Professors and 2 TA with (ta1 assigned course1, ta2 assigned course2) and 1 Admin to demonstrate this Assignment).
Given in the above of the main function

Press any number given between 1 to 4 as given to login
Press 1 for Login as Student
Press 2 for Login as Professor
Press 3 for Login as Teaching Assistant
Press 4 for Login as Administrator
Press 5 for Exit

//STUDENT
If you pressed 1 then you have to fill one of students email id and password given in main class.
Example:
Enter student email-> swarit@iiitd.com
Enter password-> student1
Swarit logged in successfully.
Press 1 for View Courses
Press 2 for Register for a Course
Press 3 for View Schedule
Press 4 for Track Progress
Press 5 for Drop Course
Press 6 for Submit Complaint
Press 7 for giving any feedback
Press 8 for logout

Press 1 to view courses available
Press 2 to register from the courses given
After this Press 3 to view the schedule of your registered courses.
then Press 4 to get the CGPA
Press 5 to drop course from the registered one.
Press 6 if you have to register any complaint
Press 7 if you want to give any feedback
And Press 8 to Logout from student section.

//PROFESSOR
If you press 2 then you have to fill one of the professor email and password given in main class
Example:
Enter Professor email-> prof1@iiitd.com
Enter password-> prof1
Professor logged in successfully.
Press 1 for Manage Courses
Press 2 for View Enrolled Students
Press 3 for Logout

Press 1 and then select the course index from the course catalog and update the timings
Press 2 to see the list of enrolled students in the course (Note: First you have to register for the courses as a student).
Press 3 to view the students feedbacks
Press 4 to finally log out from Prof section.


//Teaching Assistant
If you press then you have to fill the TA email and password
For Example:
email->ta1@iiitd.com
password->ta1

After this:
Press 1 to view the enrolled students grades
Press 2 to update the student grades in that course
Press 3 to finally logout


//ADMIN
If you press 4 then you have to fill the admin email and password given below
email->admin@iiitd.com
password-> admin12345

After this:
Administrator logged in successfully.
Press 1 for Manage Courses
Press 2 for Manage Student Records
Press 3 for Logout


Press 1 to manage course like view all the courses or Add a new course to the catalog or Delete a course fromt the given catalog.
Press 2 to Manage student data like viewing their email and password ot updting the student grades or Updating the student email (Note:- If you update the student email then you have to login through the updated email.).
Finally Press 3 to log out from admin section.


#CONCEPTS I USED:-
I used the inheritance like TeachingAssistant class inherits from the student class.
I used the Encapsulation like in student class the name is private and password and email is protected and so on.
I defined the Constructors like in student class and Professor class etc.
I used the Access Modifiers
I used the getters and Setters like getName(), setName(name) etc.
I used the data Structure like ArrayList and HashMaps
I used String operations like equals() in the authenticate() methods
I used different methods
Fields like name are private and immutable without a setter, whereas fields like email have setters and are mutable.
I used the Generic programming to make the feedback class.
I use the Robust Exceptional handling for InvalidLoginException and for CourseFullException.

