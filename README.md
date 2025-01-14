# **College ERP System (CLI-based)**

Welcome to the **College ERP System**, a command-line interface (CLI) application designed to manage the daily operations of a college. This system provides distinct functionalities for **Students**, **Professors**, and **Admins**, helping them efficiently manage academic records, course registration, grades, attendance, and more.

---

## **✨ Key Features**

### For **Students**:
- 🎓 **View Academic Profile**: Check your personal details, grades, and attendance records.
- 📚 **Register for Courses**: Register for available courses based on your program requirements.
- 📅 **Course Management**: View detailed information about courses including schedules and instructor details.
- 📝 **Track Performance**: Easily view your grades and track attendance for all enrolled courses.

### For **Professors**:
- 📖 **Course Management**: Manage courses you're teaching by adding/removing students, and tracking performance.
- 📝 **Enter Grades & Attendance**: Record and update student grades and attendance for the courses you teach.
- 📅 **Teaching Schedule**: Stay organized with your detailed teaching schedule and assignments.

### For **Admins**:
- 👨‍💼 **User Management**: Manage student and professor accounts. Add, remove, or update their profiles and roles.
- 📚 **Course Management**: Create, update, or delete courses. Assign professors to relevant courses.
- 🔎 **Records Oversight**: Have full access to student grades, attendance, and academic records to ensure smooth operations.

---

## **🚀 Technologies Used**

- **Programming Language**: Java
- **Storage**: Simple file-based or in-memory database for storing user and academic data.
- **CLI Framework**: Built with Java's native libraries (Scanner, System.out) for a straightforward and efficient command-line experience.

---

## **📁 Project Structure**

The project is built using Object-Oriented Principles (OOP) to ensure scalability and maintainability. Key components include:

- **Main Class**: Entry point of the system that initializes the core operations and provides the user menu interface.
- **User Class**: A common base class for students, professors, and admins with shared properties such as user ID, name, and login credentials.
- **Student Class**: Extends `User` to allow students to register for courses, view grades, and attendance.
- **Professor Class**: Extends `User` to allow professors to manage courses and enter grades/attendance.
- **Admin Class**: Extends `User` and provides access to full administrative controls, such as user and course management.
- **Course Class**: Stores course-specific details like the course name, schedule, professor, and student enrollment.
- **Portal/Database Class**: Manages the system's data storage, including users, courses, grades, and attendance records.

---

## **⚙️ How to Run the Project**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/college-erp-system.git
