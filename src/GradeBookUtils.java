import java.util.List;

public class GradeBookUtils {
   public static String formatGrades(List<Integer> grades) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < grades.size(); i++) {
         sb.append(grades.get(i));
         if (i < grades.size() - 1) {
            sb.append(", ");
         }
      }
      return sb.toString();
   }
}
