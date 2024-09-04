import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeBook {
   private static final String HEADER = "| Student | Grades               | Avg  |";
   private static final String SEPARATOR = "-----------------------------------------";
   private static final String STUDENT_FORMAT = "| %-7s | %-20s | %.1f |";
   private static final String CLASS_AVERAGE_FORMAT = "Class Average: %.2f";
   private List<Student> students;
   private InputHandler inputHandler;
   private GradeCalculator gradeCalculator;

   public GradeBook() {
      this.students = new ArrayList<>();
      this.inputHandler = new ConsoleInputHandler(new Scanner(System.in));
      this.gradeCalculator = new SimpleGradeCalculator();
   }

   public void run() {
      enterStudentNames();
      enterStudentGrades();
      calculateAverages();
      printGradeBook();
   }

   private void enterStudentNames() {
      System.out.print("Enter the number of students: ");
      int numStudents = Integer.parseInt(new Scanner(System.in).nextLine());

      for (int i = 0; i < numStudents; i++) {
         String name = inputHandler.getStudentName();
         students.add(new Student(name));
      }
   }

   private void enterStudentGrades() {
      for (Student student : students) {
         System.out.println("Entering grades for " + student.getName() + ":");
         List<Integer> grades = inputHandler.getStudentGrades();
         for (int grade : grades) {
            student.addGrade(grade);
         }
      }
   }

   private void calculateAverages() {
      for (Student student : students) {
         double average = gradeCalculator.calculateAverage(student);
         student.setAverage(average);
      }
   }

   private void printGradeBook() {
      System.out.println(SEPARATOR);
      System.out.println(HEADER);
      System.out.println(SEPARATOR);

      for (Student student : students) {
         System.out.printf(STUDENT_FORMAT, student.getName(), student.getGradesAsString(), student.getAverage());
         System.out.println();
      }

      System.out.println(SEPARATOR);
      System.out.printf(CLASS_AVERAGE_FORMAT, calculateClassAverage());
      System.out.println();
   }

   private double calculateClassAverage() {
      double total = 0;
      for (Student student : students) {
         total += student.getAverage();
      }
      return total / students.size();
   }
}
