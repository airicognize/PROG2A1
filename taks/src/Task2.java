import javafx.concurrent.Task;

/**
 * @author Jeremie Guerchon
 */

public class Task2 {

    /**
     * @param str String to count the total score
     * @return the final total score of the string.
     */

    public double countStringScore(String str) {

        if (str == null) {
            return 0;
        } else if (str == "") {
            return 0;
        }

        double countSpace;
        double countDigit = 0;
        double countChar = 0;
        double countSymbols = 0;
        double score = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                countChar += 2;
            } else if (Character.isDigit(str.charAt(i))) {
                countDigit += 1;
            } else if (Character.isWhitespace(str.charAt(i))) {
                countSpace = 0;
            } else {
                countSymbols += 3;
            }

        }

        score = (countChar + countDigit + countSymbols);
        double finalScore = score / str.length();

        return finalScore;
    }

}

