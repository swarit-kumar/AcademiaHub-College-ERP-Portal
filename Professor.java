import java.util.*;

public class Professor {
    protected String email;
    protected String password;
    private List<Course> courses;

    public Professor(String email, String password) {
        this.email = email;
        this.password = password;
        this.courses = new ArrayList<>();
    }


//     Method to check email and password
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }


//     Getter for the email
    public String getEmail() {
        return this.email;
    }

//     Setter for the email
    public void setEmail(String email) {
        this.email = email;
    }


//     Method to Manage courses
    public void manageCourses() {
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println((i + 1) + ".) " + course.getcourseName() + " (Current timings: " + course.getTimings() + ")");
        }


        System.out.print("Enter the course number you want to update-> ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine();


        Course selectedCourse = courses.get(courseNumber - 1);


        System.out.print("Enter new timings-> ");
        String newTimings = scanner.nextLine();


        selectedCourse.setTimings(newTimings);


        System.out.println("Timings is successfully updated to-> " + newTimings);
    }

//     Add a course to professor's list
    public void addCourse(Course course) {
        courses.add(course);
    }


//     View enrolled students
    public void viewEnrolledStudents(Course course) {
        System.out.println("Students enrolled in " + course.getcourseName() + ":");
        List<Student> students = course.getEnrolledStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        }
        else {
            for (int i=0; i<students.size(); i++) {
                System.out.println("Name= "+students.get(i).getName() + ", email= (" + students.get(i).getEmail() + ")");
            }
        }
    }


//    Method to view feedback
    public void viewFeedback() {
        for (int i=0; i<courses.size(); i++) {
            System.out.println("Feedback for " + courses.get(i).getcourseName() + ":");
            courses.get(i).displayNumericFeedback();
            System.out.println();


            courses.get(i).displayTextualFeedback();
            System.out.println();
        }
    }
}
