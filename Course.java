import java.util.*;

public class Course {
    private String courseCode;
    private String courseName;
    private Professor professor;
    private int credits;
    private List<Course> prerequisites;
    private String timings;
    private List<Student> enrolledStudents;
    private Feedback<Integer> rating;
    private Feedback<String> textFeedback;
    private Map<Student, Integer> studentGrades;
    private int courseCapacity;

    public Course(String code, String courseName, int credits, List<Course> prerequisites, String timings, int courseCapacity) {
        this.courseCode = code;
        this.courseName = courseName;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.timings = timings;
        this.enrolledStudents = new ArrayList<>();
        this.rating=new Feedback<>();
        this.textFeedback=new Feedback<>();
        this.studentGrades = new HashMap<>();
        this.courseCapacity=courseCapacity;
    }

    // Getter for course name
    public String getcourseName() {
        return courseName;
    }

    public String getCourseCode(){
        return courseCode;
    }
    // Getter for Credits
    public int getCredits() {
        return credits;
    }


    // Getter for Timings
    public String getTimings() {
        return timings;
    }

    // Setter for professor
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }



    //Enrolling the students within the capacity
    public void registerStudent(Student stu) throws CourseFullException{
        if (enrolledStudents.size() >= courseCapacity) {
            throw new CourseFullException("The course " + courseName + " is full.");
        }
        else{
            enrolledStudents.add(stu);
            studentGrades.put(stu, 0);
        }
    }

//    Updating the grades
    public void updateGrade(Student stu, int grade) {
        if(studentGrades.containsKey(stu)){
            studentGrades.put(stu, grade);
            System.out.println("Grade updated for " + stu.getName());
            System.out.println();
        }
        else{
            System.out.println(stu.getName() + " is not registered for this course.");
            System.out.println();
        }
    }

//     Method to view grades of all students
    public void viewGrades() {
        System.out.println("Grades for " + courseName + "are :");
        for(Map.Entry<Student, Integer> entry : studentGrades.entrySet()){
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    public void addNumericFeedback(int rate) {
        rating.addFeedback(rate);
    }

    public void addTextualFeedback(String review) {
        textFeedback.addFeedback(review);
    }

//    TO print the numeric feedback
    public void displayNumericFeedback() {
        System.out.println("Numeric Feedback for " + courseName + ":");
        rating.displayFeedback();
    }

//    To print the textual feedback
    public void displayTextualFeedback() {
        System.out.println("Textual Feedback for " + courseName + ":");
        textFeedback.displayFeedback();
    }



    // Getter for enrolled students
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return courseName + " (" + courseCode + ") -> " + credits + " credits";
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }
}
