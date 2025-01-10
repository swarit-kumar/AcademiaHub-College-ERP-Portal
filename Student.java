import java.util.*;

public class Student {
    private String name;
    protected String email;
    protected String password;
    List<Course> registeredCourses;
    protected Map<Course, String> completedCourses;

//    Constructor for Student
    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new HashMap<>();
    }

//     Method for login
    public void login() {
        System.out.println(this.name + " logged in successfully.");
    }

//     Getter for student name
    public String getName() {
        return name;
    }


//     Getter for the email field
    public String getEmail() {
        return this.email;
    }

//     Setter for the email field
    public void setEmail(String email) {
        this.email = email;
    }

//     Method for authentication
    public boolean authenticate(String email, String password) {
        if((this.email.equals(email)) && (this.password.equals(password))){
            return true;
        }
        else{
            return false;
        }
    }


//     View all available courses
    public void viewAvailableCourses(List<Course> courses) {
        System.out.println("Available Courses are:");
        for (int i=0;i <courses.size(); i++) {
            System.out.println(courses.get(i).getCourseCode() + " - " + courses.get(i).getcourseName() + " -> " + courses.get(i).getCredits() + " credits");
        }
        System.out.println();
    }


//     Register for course
    public void registerCourse(Course c) throws CourseFullException {
        if (registeredCourses.contains(c)) {
            System.out.println("You have already registered for this course.");
            return;
        }
        else{
            c.registerStudent(this);
            registeredCourses.add(c);
            System.out.println("Successfully registered for " + c.getcourseName() + " having " + c.getCredits() + " credits");
            System.out.println();
        }
    }


//     View schedule
    public void viewSchedule() {
        if (registeredCourses.isEmpty()) {
            System.out.println("Not registered for any courses.");
            System.out.println();
        }
        else {
            System.out.println("Your schedule is:");
            for (int i=0; i<registeredCourses.size(); i++) {
                System.out.println(registeredCourses.get(i).getcourseName() + " -> " + registeredCourses.get(i).getTimings());
            }
        }
        System.out.println();
    }


//    For printing the registered courses wherever required
    public void printRegisteredCourses(){
        System.out.println("Your Registered courses are:");
        for(int i=0; i<registeredCourses.size(); i++){
            System.out.println((i+1)+".) "+ registeredCourses.get(i).getcourseName());
        }
    }

//     Drop a course
    public void dropCourse(Course c) {
        if (registeredCourses.contains(c)) {
            registeredCourses.remove(c);
            System.out.println("Successfully dropped " + c.getcourseName());
        }
        else {
            System.out.println("You are not enrolled in " + c.getcourseName());
        }
        System.out.println();
    }

    // Method to convert from grade to cgpa
    public double getGradePoints(String grade) {
        if(grade=="+A"){
            return 10;
        }
        else if(grade=="-A"){
            return 9;
        }
        else if(grade=="+B"){
            return 8;
        }
        else if(grade=="-B"){
            return 7;
        }
        else if (grade=="C") {
            return 6;
        }
        else if(grade=="D"){
            return 5;
        }
        else if(grade=="E"){
            return 4;
        }
        else if(grade=="F"){
            return 3;
        }
        return 0;
    }


//     Track progress
    public void trackProgress() {
        double totalCredits = 0;
        double totalPoints = 0;

//        calculating the CGPA
        for (Map.Entry<Course, String> entry : completedCourses.entrySet()) {
            Course course = entry.getKey();
            String grade = entry.getValue();

            double credits = course.getCredits();
            double gradePoints = getGradePoints(grade);

            totalCredits += credits;
            totalPoints += credits * gradePoints;
        }

        double cgpa;

        if (totalCredits == 0) {
            cgpa = 0;
        }
        else {
            cgpa = totalPoints / totalCredits;
        }

        System.out.printf("Your CGPA is: %.2f%n", cgpa);
    }


//     Assigning the grade
    public void completeCourse(Course course, String grade) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            completedCourses.put(course, grade);
            System.out.println("Course " + course.getcourseName() + " completed with grade " + grade);
        }
        else {
            System.out.println("You are not registered for " + course.getcourseName());
        }
    }

//    Giving Feedback
    public void provideFeedback(Course c) {
        if (registeredCourses.contains(c)) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a numeric rating (1-5) for " + c.getcourseName() + "-> ");
            int rating = scanner.nextInt();
            scanner.nextLine();

            c.addNumericFeedback(rating);


            System.out.print("Write review for " + c.getcourseName() + "-> ");
            String review = scanner.nextLine();
            c.addTextualFeedback(review);

            System.out.println("Thank you for giving your feedback!");
            System.out.println();
        }
        else {
            System.out.println("Not registered for this course.");
            System.out.println();
        }
    }
}
