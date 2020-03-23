import java.util.*;

public class Main {

    public static void main(String[] args) {

        //System.out.println(bunnyEars(2));
        //System.out.println(bunnyEars2(3));
        //System.out.println(count7(717));
        //System.out.println(count8(81888));
        //System.out.println(powerN(2,3));
        //System.out.println(countX("xxhixx"));
        //System.out.println(countHi("hi"));
        int[] numbers = {1, 6, 4};
        //System.out.println(array6(numbers, 0));
        //System.out.println(parenBit("not really (possible)"));
        String a = "dsada(dddas)xx";
        //System.out.println(a.substring(0, a.length() - 1));
        System.out.println(strCount("cacatcowcat", "cat"));

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

    //The fibonacci sequence
    private static int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
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

    //Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
    private static String changePi(String str) {
        if(str.length() <= 1) return str;
        else if (str.substring(0, 2).equals("pi")) return "3.14".concat(changePi(str.substring(2)));
        return (str.charAt(0) + "").concat(changePi(str.substring(1)));
    }

    //Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index.
    //In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
    private static boolean array6(int[] nums, int index) {
        if (index >= nums.length) return false;
        else return (nums[index] == 6) || array6(nums, index + 1);
    }

    //Given an array of ints, compute recursively the number of times that the value 11 appears in the array.
    private static int array11(int[] nums, int index) {
        if (index >= nums.length) return 0;
        else if (nums[index] == 11) return 1 + array11(nums, index + 1);
        else return array11(nums, index + 1);
    }

    //Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10.
    private static boolean array220(int[] nums, int index) {
        if (index >= nums.length - 1) return false;
        else return nums[index + 1] == nums[index] * 10 || array220(nums, index + 1);
    }
    //nums.l = 3; index = 3;  3 >= 3-1 --> false | nums.l = 2; index = 3;  2>= 3 -1 --> false | nums.l = 3; index = 2; 2 >= 3 - 1 --> true

    //Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
    private static String allStar(String str) {
        if (str.length() <= 1) return str;
        else return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    //Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
    private static String pairStar(String str) {
        if (str.length() <= 1) return str;
        else if (str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + pairStar(str.substring(1));
        else return str.charAt(0) + pairStar(str.substring(1));
    }

    //Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
    private static String endX(String str) {
        if (str.length() <= 1) return str;
        else if (str.charAt(0) == 'x') return endX(str.substring(1)) + "x";
        else return str.charAt(0) + endX(str.substring(1));
    }

    //We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair.
    private static int countPairs(String str) {
        if (str.length() <= 2) return 0;
        else if (str.charAt(0) == str.charAt(2)) return 1 + countPairs(str.substring(1));
        else return countPairs(str.substring(1));
    }

    //Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
    private static int countAbc(String str) {
        if (str.length() <= 2) return 0;
        else if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba")) return 1 + countAbc(str.substring(1));
        else return countAbc(str.substring(1));
    }

    //Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
    private static int count11(String str) {
        if (str.length() <= 1) return 0;
        else if (str.substring(0, 2).equals("11")) return 1 + count11(str.substring(2));
        else return count11(str.substring(1));
    }

    //Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char.
    private static String stringClean(String str) {
        if (str.length() <= 1) return str;
        else if (str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
        else return str.charAt(0) + stringClean(str.substring(1));
    }

    //Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.
    private static int countHi2(String str) {
        if (str.length() <= 1) return 0;
        else if (str.length() >  2 && str.substring(0, 3).equals("xhi")) return countHi2(str.substring(3));
        else if (str.substring(0, 2).equals("hi")) return 1 + countHi2(str.substring(2));
        else return countHi2(str.substring(1));
    }

    //Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
    private static String parenBit(String str) {
        if (str.charAt(0) != '(') return parenBit(str.substring(1));
        else if (str.charAt(str.length() - 1) != ')') return parenBit(str.substring(0, str.length() - 1));
        return str;
    }

    //Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))".
    private static boolean nestParen(String str) {
        if (str.length() == 0) return true;
        else if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') return nestParen(str.substring(1, str.length() - 1));
        return false;
    }

    //Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.
    private static int strCount(String str, String sub) {
        if(str.length() < sub.length()) return 0;
        else if (str.substring(0, sub.length()).equals(sub)) return 1 + strCount(str.substring(sub.length()), sub);
        else return strCount(str.substring(1), sub);
    }

    //Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping.
    private static boolean strCopies(String str, String sub, int n) {
        if (n == 0) return true;
        else if (sub.length() > str.length()) return false;
        else if (str.substring(0, sub.length()).equals(sub)) return strCopies(str.substring(1), sub, n - 1);
        else return strCopies(str.substring(1), sub, n);
    }

    //Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
    private static int strDist(String str, String sub) {
        if (str.length() == 0) return 0;
        else if (sub.length() > str.length()) return 0;
        else if (!str.substring(0, sub.length()).equals(sub)) return strDist(str.substring(1), sub);
        else if (str.substring(str.length() - sub.length()).equals(sub)) return str.length();
        else return strDist(str.substring(0, str.length()-1), sub);
    }


}
