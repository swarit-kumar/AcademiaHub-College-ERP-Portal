import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        // Administrator Sample
        Administrator admin = new Administrator("admin@iiitd.com", "admin12345");

        // Professors Sample
        Professor prof1 = new Professor("prof1@iiitd.com", "prof1");
        Professor prof2 = new Professor("prof2@iiitd.com", "prof2");

        // Students Sample
        Student student1 = new Student("Swarit", "swarit@iiitd.com", "student1");
        Student student2 = new Student("Naman", "naman@iiitd.com", "student2");
        Student student3 = new Student("Rahul", "rahul@iiitd.com", "student3");

        // Courses Sample
        Course course1 = new Course("CSE101", "Introduction to Programming", 4, new ArrayList<>(), "8 AM - 9:30 AM",2);
        courses.add(course1);

        Course course2 = new Course("MATHS101", "Linear-Algebra", 3, new ArrayList<>(), "9:30 AM - 11 PM",3);
        courses.add(course2);

        Course course3 = new Course("DDV101", "Design Drawing & Visualisation", 4, new ArrayList<>(), "11 PM - 12:30 PM",3);
        courses.add(course3);

        Course course4 = new Course("VDC101", "Visual Design & Communication", 2, new ArrayList<>(), "1:30 PM - 3 PM",2);
        courses.add(course4);

        Course course5 = new Course("CO101", "Computer Organisation", 3, new ArrayList<>(), "3 PM - 4:30 PM",2);
        courses.add(course5);

        //TA Sample
        TeachingAssistant ta1 = new TeachingAssistant("TA1", "ta1@iiitd.com", "ta1", prof1);
        TeachingAssistant ta2 = new TeachingAssistant("TA2", "ta2@iiitd.com", "ta2", prof2);

        ta1.assignToCourse(course1);
        ta2.assignToCourse(course2);

        // Assign professors to courses
        prof1.addCourse(course1);
        prof1.addCourse(course2);
        prof1.addCourse(course3);
        prof2.addCourse(course4);
        prof2.addCourse(course5);

        
        boolean running = true;
        while (running) {
            System.out.println("<<Welcome to the iiitd Portal>>");
            System.out.println("Press 1 for Login as Student");
            System.out.println("Press 2 for Login as Professor");
            System.out.println("Press 3 for Login as TA");
            System.out.println("Press 4 for Login as Administrator");
            System.out.println("Press 5 for Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            // Login as a student
            if (option == 1) {
                System.out.print("Enter student email-> ");
                String email = scanner.nextLine();

                System.out.print("Enter password-> ");
                String password = scanner.nextLine();

                Student currentStudent = null;
                try {
                    if (student1.authenticate(email, password)) {
                        currentStudent = student1;
                    } else if (student2.authenticate(email, password)) {
                        currentStudent = student2;
                    } else if (student3.authenticate(email, password)) {
                        currentStudent = student3;
                    }

                    if (currentStudent == null) {
                        throw new InvalidLoginException("Wrong email or password.");
                    }

                    System.out.println(currentStudent.getName() + " logged in successfully.");
                    boolean studentRunning = true;

                    while (studentRunning) {
                        System.out.println("Press 1 for View Courses");
                        System.out.println("Press 2 for Register for a Course");
                        System.out.println("Press 3 for View Schedule");
                        System.out.println("Press 4 for Track Progress");
                        System.out.println("Press 5 for Drop Course");
                        System.out.println("Press 6 for Submit Complaint");
                        System.out.println("Press 7 for giving any feedback");
                        System.out.println("Press 8 for Logout");

                        int studoption = scanner.nextInt();
                        scanner.nextLine();  // Consume the leftover newline

                        if (studoption == 1) {
                            currentStudent.viewAvailableCourses(courses);
                        }
                        else if (studoption == 2) {
                            System.out.println("Select a course to register-> ");
                            for (int i = 0; i < courses.size(); i++) {
                                System.out.println((i + 1) + ".) " + courses.get(i).getcourseName());
                            }

                            int courseIndex = scanner.nextInt() - 1;
                            scanner.nextLine();

                            try {
                                currentStudent.registerCourse(courses.get(courseIndex));
                            } catch (CourseFullException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (studoption == 3) {
                            currentStudent.viewSchedule();
                        }
                        else if (studoption == 4) {
                            currentStudent.trackProgress();
                        }
                        else if (studoption == 5) {
                            System.out.println("Select a course to drop-> ");
                            for (int i = 0; i < courses.size(); i++) {
                                System.out.println((i + 1) + ".) " + courses.get(i).getcourseName());
                            }
                            int dropIndex = scanner.nextInt() - 1;
                            scanner.nextLine();

                            currentStudent.dropCourse(courses.get(dropIndex));
                        }
                        else if (studoption == 6) {
                            System.out.println("Enter your complaint:");
                            String description = scanner.nextLine();

                            System.out.println("Complaint submitted.");
                            System.out.println();
                        }
                        else if (studoption == 7) {
                            if (currentStudent.registeredCourses.isEmpty()) {
                                System.out.println("You have not registered for any course to give feedback.");
                                System.out.println();
                            }
                            else {
                                System.out.println("Select a registered course to give feedback:");
                                currentStudent.printRegisteredCourses();

                                int feedbackCourseIndex = scanner.nextInt() - 1;
                                scanner.nextLine();
                                Course feedbackCourse = courses.get(feedbackCourseIndex);
                                currentStudent.provideFeedback(feedbackCourse);
                            }
                        }
                        else if (studoption == 8) {
                            studentRunning = false;
                            System.out.println(currentStudent.getName() + " logged out.");
                        }
                    }
                } catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                }

            }
            // Login as a Professor
            else if (option == 2) {
                System.out.print("Enter professor email-> ");
                String email = scanner.nextLine();

                System.out.print("Enter password-> ");
                String password = scanner.nextLine();

                Professor currProfessor = null;


                try{
                    if (prof1.authenticate(email, password)) {
                        currProfessor = prof1;
                    }
                    else if (prof2.authenticate(email, password)) {
                        currProfessor = prof2;
                    }
                    if (currProfessor == null) {
                        throw new InvalidLoginException("Wrong email or password.");
                    }
                    System.out.println("Professor logged in successfully.");
                    boolean professorRunning = true;
                    while (professorRunning) {
                        System.out.println("Press 1 for Manage Courses");
                        System.out.println("Press 2 for View Enrolled Students");
                        System.out.println("Press 3 for view Feedback");
                        System.out.println("Press 4 for Logout");

                        int professoroption = scanner.nextInt();
                        scanner.nextLine();

                        if (professoroption == 1) {
                            currProfessor.manageCourses();
                        }
                        else if (professoroption == 2) {
                            System.out.println("Select a course to view students:");
                            for (int i = 0; i < courses.size(); i++) {
                                System.out.println((i + 1) + ".) " + courses.get(i).getcourseName());
                            }
                            int courseIndex = scanner.nextInt() - 1;
                            scanner.nextLine();  // Consume the leftover newline

                            currProfessor.viewEnrolledStudents(courses.get(courseIndex));
                        }
                        else if (professoroption == 3) {
                            currProfessor.viewFeedback();
                        }
                        else if (professoroption == 4){
                            professorRunning = false;
                            System.out.println("Professor logged out.");
                        }
                    }
                }
                catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                }


            }
            //Login as a TA
            else if(option == 3){
                System.out.print("Enter TA email-> ");
                String email = scanner.nextLine();

                System.out.print("Enter password-> ");
                String password = scanner.nextLine();

                TeachingAssistant currentTA = null;
                try{
                    if (ta1.authenticate(email, password)) {
                        currentTA = ta1;
                    }
                    else if (ta2.authenticate(email, password)) {
                        currentTA = ta2;
                    }
                    if (currentTA == null) {
                        throw new InvalidLoginException("Wrong email or password.");
                    }
                    System.out.println(currentTA.getName() + " logged in successfully as TA.");
                    boolean taRunning = true;

                    while (taRunning) {
                        System.out.println("Press 1 for View enrolled students");
                        System.out.println("Press 2 for Update Student Grades");
                        System.out.println("Press 3 for Logout");

                        int taOption = scanner.nextInt();
                        scanner.nextLine();

                        if (taOption == 1) {
                            System.out.println("Select a course to view enrolled students:");
                            for (int i = 0; i < courses.size(); i++) {
                                System.out.println((i + 1) + ".) " + courses.get(i).getcourseName());
                            }
                            int courseIndex = scanner.nextInt() - 1;
                            scanner.nextLine();
                            Course selectedCourse = courses.get(courseIndex);

                            currentTA.viewEnrolledStudentsGrades(selectedCourse);
                        }
                        else if (taOption == 2) {
                            System.out.println("Select a course to update grades:");
                            for (int i = 0; i < courses.size(); i++) {
                                System.out.println((i + 1) + ".) " + courses.get(i).getcourseName());
                            }

                            int courseIndex = scanner.nextInt() - 1;
                            scanner.nextLine();
                            Course selectedCourse = courses.get(courseIndex);

                            // Get list of registered students for the selected course
                            List<Student> registeredStudents = selectedCourse.getEnrolledStudents();

                            if (registeredStudents.isEmpty()) {
                                System.out.println("No students are enrolled in this course.");
                            }
                            else {
                                System.out.println("Select a student to update grade:");
                                for (int i = 0; i < registeredStudents.size(); i++) {
                                    System.out.println((i + 1) + ".) " + registeredStudents.get(i).getName());
                                }

                                int studentIndex = scanner.nextInt() - 1;
                                scanner.nextLine();
                                Student selectedStudent = registeredStudents.get(studentIndex);

                                System.out.print("Enter new grade for " + selectedStudent.getName() + ": ");
                                int grade = scanner.nextInt();
                                scanner.nextLine();

                                currentTA.manageStudentGrades(selectedCourse, selectedStudent, grade);
                            }
                        }
                        else if (taOption == 3) {
                            taRunning = false;
                            System.out.println(currentTA.getName() + " logged out.");
                        }
                    }
                }
                catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                }
            }
            // Login as an Admin
            else if (option == 4) {
                System.out.print("Enter admin email-> ");
                String email = scanner.nextLine();

                System.out.print("Enter password-> ");
                String password = scanner.nextLine();

                Administrator currAdmin = null;
                try{
                    if (admin.authenticate(email, password)) {
                        currAdmin = admin;
                    }
                    if (currAdmin == null) {
                        throw new InvalidLoginException("Wrong email or password.");
                    }
                    System.out.println("Administrator logged in successfully.");
                    boolean adminRunning = true;

                    while (adminRunning) {
                        System.out.println("Press 1 for Manage Courses");
                        System.out.println("Press 2 for Manage Student Records");
                        System.out.println("Press 3 for Logout");

                        int adminoption = scanner.nextInt();
                        scanner.nextLine();

                        if (adminoption == 1) {
                            admin.manageCourseCatalog(courses);
                        }
                        else if (adminoption == 2) {
                            System.out.println("Select a student:");
                            System.out.println("Press 1 for " + student1.getName());
                            System.out.println("Press 2 for " + student2.getName());
                            System.out.println("Press 3 for " + student3.getName());

                            int studentIndex = scanner.nextInt();
                            scanner.nextLine();

                            if (studentIndex == 1) {
                                admin.manageStudentRecords(student1);
                            } else if (studentIndex == 2) {
                                admin.manageStudentRecords(student2);
                            } else if (studentIndex == 3) {
                                admin.manageStudentRecords(student3);
                            } else {
                                System.out.println("Invalid student selection.");
                            }
                        }
                        else if (adminoption == 3) {
                            adminRunning = false;
                            System.out.println("Administrator logged out.");
                        }
                    }
                }
                catch (InvalidLoginException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (option == 5) {
                running = false;
                System.out.println("Exiting from System...");
            }
        }

        scanner.close();
    }
}
