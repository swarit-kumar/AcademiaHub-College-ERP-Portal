import java.util.*;

public class TeachingAssistant extends Student{
    private Professor assignedProf;
    private List<Course> taCourses;

    public TeachingAssistant(String name, String email, String password, Professor assignedProf) {
        super(name, email, password);
        this.assignedProf = assignedProf;
        this.taCourses = new ArrayList<>();
    }

    // Assigning TA to a course
    public void assignToCourse(Course c) {
        taCourses.add(c);
    }


    //     View enrolled students grades
    public void viewEnrolledStudentsGrades(Course c) {
        System.out.println("Students enrolled in " + c.getcourseName() + ":");
        List<Student> students = c.getEnrolledStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        }
        else {
            c.viewGrades();
        }
    }


//    Updating grades for Students
    public void manageStudentGrades(Course c, Student student, int grade) {
        if (taCourses.contains(c)) {
            c.updateGrade(student, grade);
        }
        else {
            System.out.println("You are not assigned to this course.");
        }
    }
}
