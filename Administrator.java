import java.util.*;

public class Administrator {
    protected String email;
    protected String password;


//    Constructor for Administrator
    public Administrator(String email, String password) {
        this.email = email;
        this.password = password;
    }

//     Method to check email and password
    public boolean authenticate(String email, String password) {
        if(Objects.equals(this.email, email) && Objects.equals(this.password, password)){
            return true;
        }
        else {
            return false;
        }
    }

//     Getter for the email field
    public String getEmail() {
        return this.email;
    }

//    Setter for the email field
    public String setEmail(String email){
        this.email=email;
        return email;
    }


//     Method to Manage Course
    public void manageCourseCatalog(List<Course> c) {
        System.out.println("Press 1 for View Courses");
        System.out.println("Press 2 for Add a Course");
        System.out.println("Press 3 for Delete a Course");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();
        scanner.nextLine();


        // Printing all courses
        if (option == 1) {
            System.out.println("Course Catalog:");

            for (int i = 0; i < c.size(); i++) {
                System.out.println((i+1) + ".) " + c.get(i).getcourseName());
            }
        }
        // Adding a new course
        else if (option == 2) {
            System.out.print("Enter Course Code-> ");
            String courseCode = scanner.nextLine();

            System.out.print("Enter Course Name-> ");
            String courseName = scanner.nextLine();


            System.out.print("Enter credits-> ");
            int credits = scanner.nextInt();

            System.out.print("Enter the maximum Cap of the Course-> ");
            int capacity=scanner.nextInt();


            Course newCourse = new Course(courseCode, courseName, credits, new ArrayList<>(), "8 AM -  9:30AM", capacity);
            c.add(newCourse);
            System.out.println("Course added successfully.");
            System.out.println();
        }
        // Deleting a course
        else if (option == 3) {
            System.out.println("Enter the course number to delete:");
            for (int i = 0; i < c.size(); i++) {
                System.out.println((i+1) + ".) " + c.get(i).getcourseName());
            }
            int courseNumber = scanner.nextInt() - 1;
            scanner.nextLine();

            c.remove(courseNumber);
            System.out.println("Course Deleted successfully.");
        }
        // Invalid option selected
        else {
            System.out.println("Please select valid options only.");
        }
    }



    // Manage students Record
    public void manageStudentRecords(Student stu) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. View student Info");
        System.out.println("2. Update student Grades");
        System.out.println("3. Update student Email");

        int option = scanner.nextInt();
        scanner.nextLine();


        if (option == 1) {
            System.out.println("Student Name -> " + stu.getName() + ", Student Email -> " + stu.getEmail());
            System.out.println();
        }
        else if (option == 2) {
            System.out.println("Enter the course number to update the grade:");
            List<Course> completedCourses = new ArrayList<>(stu.registeredCourses);
            for (int i = 0; i < completedCourses.size(); i++) {
                System.out.println((i + 1) + ".) " + completedCourses.get(i).getcourseName());
            }

            int courseNumber = scanner.nextInt() - 1;
            scanner.nextLine();

            if (courseNumber >= 0 && courseNumber < completedCourses.size()) {
                Course selectedCourse = completedCourses.get(courseNumber);
                System.out.print("Enter new grade (+A, -A, +B, -B, C, D, E, F) -> ");
                String newGrade = scanner.nextLine();

                stu.completeCourse(selectedCourse, newGrade);
                System.out.println("Grade successfully updated for " + selectedCourse.getcourseName());
            }
            else {
                System.out.println("Invalid course selection.");
            }
        }
        else if (option == 3) {
            System.out.print("Enter new email -> ");
            String newEmail = scanner.nextLine();
            scanner.nextLine();
            stu.setEmail(newEmail);

            System.out.println();
            System.out.println("Student email updated successfully.");
        }
        else {
            System.out.println("Please select a valid option.");
        }
    }

}