import java.util.*;

public class Main {

    public static void main(String[] args) {

        //System.out.println(bunnyEars(2));
        //System.out.println(bunnyEars2(3));
        //System.out.println(count7(717));
        //System.out.println(count8(81888));
        //System.out.println(powerN(2,3));
        //System.out.println(countX("xxhixx"));
        System.out.println(countHi("hi"));

    }

    //Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
    private static int factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    //We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
    private static int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;
        else if (bunnies == 1) return 2;
        else return 2 + bunnyEars(bunnies - 1);
    }

    //We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
    //Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
    private static int bunnyEars2(int bunnies) {
        if (bunnies == 0) return 0;
        else if (bunnies == 1) return 2;
        else if (bunnies % 2 == 0) return 3 + bunnyEars2(bunnies - 1);
        else return 2 + bunnyEars2(bunnies - 1);
    }

    //We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on.
    //Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
    private static int triangle(int rows) {
        if (rows == 0) return 0;
        else return rows + triangle(rows - 1);
    }
    // rowns = 4 -> 4 + tr(3) --> 4 + 3 + tr(2) --> 4 + 3 + 2 + tr(1) --> 4 + 3 + 2 + 1 + tr(0) --> 4 + 3 + 2 + 1 + 0 = 10

    //Given a non-negative int n, return the sum of its digits recursively (no loops).
    //Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    private static int sumDigits(int n) {
        if (n == 0) return 0;
        //else if (n == 1) return 1;
        else return n % 10 + sumDigits(n / 10);
    }

    private static int sumDigitsV2(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    //Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
    //Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    private static int count7(int n) {
        if (n <= 0) return 0;
        //if (n == 7) return 1;
        else {
            if (n % 10 == 7) return 1 + count7(n / 10);
            else return count7(n / 10);
        }
    }

    //Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
    //except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
    private static int count8(int n) {
        if (n <= 0) return 0;
        else {
            if (n % 10 == 8 && n % 100 != 88) return 1 + count8(n / 10);
            else if (n % 10 == 8 && n % 100 == 88) return 2 + count8(n / 10);
            else return count8(n / 10);
        }
    }

    //Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
    private static int powerN(int base, int n) {
        if (n <= 0) return 1;
        else return base * powerN(base, n - 1);
    }

    //Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    private static int countX(String str) {
        if (str.length() == 0) return 0;
        if (str.charAt(0) == 'x') return 1 + countX(str.substring(1));
        return countX(str.substring(1));
    }

    //Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
    private static int countHi(String str) {
        if (str.length() <= 1) return 0;
        //else if (str.length() == 2 && str.charAt(0) == 'h' && str.charAt(1) == 'i') return 1;
        if (str.charAt(0) == 'h' && str.charAt(1) == 'i') return 1 + countHi(str.substring(2)); //(str.substring(0, 2).equals("hi"))
        else return countHi(str.substring(1));
    }

    //Given a string, compute recursively a new string where all the 'x' chars have been removed.
    private static String noX(String str) {
        if (!str.contains("x")) return str;
        else if (str.charAt(0) == 'x') return noX(str.substring(1));
        else return str.charAt(0) + noX(str.substring(1));
    }

    //Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
    private static String changeXY(String str) {
        if (str.length() == 0) return "";
        //else if (!str.contains("x")) return str;
        else if (str.charAt(0) == 'x') return "y".concat(changeXY(str.substring(1)));
        else return (str.charAt(0) + "").concat(changeXY(str.substring(1)));
    }


}
