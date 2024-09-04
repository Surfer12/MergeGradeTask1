import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
   private final Scanner scanner;

   public ConsoleInputHandler(Scanner scanner) {
      this.scanner = scanner;
   }

   @Override
   public String getStudentName() {
      String input;
      do {
         System.out.print("Enter student's name: ");
         input = scanner.nextLine();
      } while (!InputValidator.isValidName(input));
      return input;
   }

   @Override
   public List<Integer> getStudentGrades() {
      List<Integer> grades = new ArrayList<>();
      System.out.print("Enter assignment score (or type 'STOP' to finish inputting scores): ");
      while (scanner.hasNextLine()) {
         String input = scanner.nextLine();
         if (input.equalsIgnoreCase("STOP")) {
            break;
         }
         if (InputValidator.isValidScore(input)) {
            grades.add(Integer.parseInt(input));
            System.out.println("Valid score entry recorded.");
         }
         System.out.print("Enter assignment score (or type 'STOP' to finish inputting scores): ");
      }
      return grades;
   }
}
