public class SimpleGradeCalculator implements GradeCalculator {
   @Override
   public double calculateAverage(Student student) {
      if (student.getNumAssignments() == 0) {
         return 0;
      }
      return (double) student.getTotalScore() / student.getNumAssignments();
   }
}
