public class InputValidator {
   public static boolean isValidName(String input) {
      return input != null && !input.trim().isEmpty();
   }

   public static boolean isValidScore(String input) {
      try {
         int score = Integer.parseInt(input);
         return score >= 0 && score <= 100;
      } catch (NumberFormatException e) {
         return false;
      }
   }
}
