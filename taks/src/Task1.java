/**
 * This is task 1 of the assignment.
 *
 * @author Jeremie Guerchon
 */

public class Task1 {

    /**
     * A method to reverse an integer number i.e: 12345 -> 54321
     *
     * @param num integer we will use to reverse the numbers.
     * @return the integer in reverse.
     */

    public int reverseNum(int num) {
        int result = 0;

        while (num > 0) { // 123 // 12 // 1
            result = result * 10 + num % 10; // 3 // 32 // 321
            num = num / 10; // 12 // 1 // 0
        }
        return result;
    }
}
