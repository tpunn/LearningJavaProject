package learningjava;

public class App {
    // main() is the central function of a Java program. This function
    // will run all of the code that you write to solve the problems
    // in functions problem1, problem2, etc.

    public static void main(String[] args) {
        System.out.println("Problem 1");
        problem1();
        System.out.println("Problem 2");
        problem2();
        System.out.println("Problem 3");
        problem3();
        System.out.println("Problem 4");
        problem4();
        System.out.println("Problem 5");
        problem5();
        System.out.println("Problem 6");
        problem6();
        System.out.println("Problem 7");
        problem7();
        System.out.println("Problem 8");
        problem8();

        
    }

    /*
     * 1. Hello World Write a method that prints out "Hello World", and make it run.
     */
    static void problem1() {
        System.out.println("Hello World");
    }

    /*
     * 2. Counting Write a method that prints the numbers from 1 to 10, each on a
     * separate line.
     */
    static void problem2() {
        int x = 1;
        while (x <= 100)
            System.out.println(x++);
    }

    /*
     * 3. More complex counting
     * 
     * Write a program that prints the numbers from 1 to 100, with ten numbers on
     * each line, like this:
     * 1 2 3 4 5 6 7 8 9 10
     * 11 12 13 14 15 16 17 18 19 20
     * 21 22 23 24 25 26 27 28 29 30
     * ...
     * 91 92 93 94 95 96 97 98 99 100
     */
    static void problem3() {
        int x = 1;
        while (x <= 100)
            System.out.print(x + (x++ % 10 == 0 ? "\n" : " "));
    }

    /*
     * 4. Write a "power" method. This method computes x to the y power.
     */
    static int power(int x, int y) {
        return y-- == 0 ? 1 : x * power(x, y);
    }

    static void problem4() {
        System.out.println("2 to the 8th power is: " + power(2, 8));
        System.out.println("3 to the 4th power is: " + power(3, 4));
        System.out.println("5 to the 3rd power is: " + power(5, 3));
        System.out.println("2 to the 16th power is: " + power(2, 16));
    }

    /*
     * 5. Power table method to print out a table of x to the
     * power of y. In this table, "x" counts the numbers as you go from left to
     * right in the table, and "y" counts the numbers as you go from top to bottom
     * in the table. Each number in the table is calculated using the "power" method
     * that you wrote for problem 4.
     * 
     * The result should look like this:
     * 
     * 1 1 1 1 1 1 1 1 1 1
     * 2 4 8 16 32 64 128 256 512 1024
     * 3 9 27 81 273 729 2187 6561 19683 59049
     * 4 16 64 256 1024 4096 16384 65536 262144 1048576
     * 5 25 125 625 3125 15625 78125 390625 1953125 9765625
     * ...
     */
    static void problem5() {
        int x = 1, y = 1;
        while (x <= 5) {
            String values = "";
            while (y <= 10)
                values += power(x, y++) + " ";
            System.out.println(values);
            x++;
            y = 0;
        }
    }

    /* 6. Booleans and if statements
     *    In the for-loop, print "fizz" if a number is divisible by 2, "buzz" if it is divisible
     *    by 3, and "fizzbuzz" if it is divisible by both. If none of these is true, print "nope".
     * 
     *    The first few entries (starting with the number 0) should be:
     *    fizzbuzz
     *    nope
     *    fizz
     *    buzz
     *    fizz
     *    nope
     *    fizzbuzz
     *    ...
     */
    static void problem6() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0 && i % 3 == 0)
                System.out.println("fizzbuzz");
            else if (i % 2 == 0)
                System.out.println("fizz");
            else if (i % 3 == 0)
                System.out.println("buzz");
            else
                System.out.println("nope");
        }
    }

    /* 7. Arrays
        Write a method that returns an array containing all of the integers from
        0 to a value n that is specified by the caller.
    */
    static int[] numbersUpToN(int n) {
        int[] integers = new int[n+1];
        
        for (int i = 0; i < integers.length; i++)
            integers[i] = i;
            
        return integers;
    }

    static void problem7() {
        int[] upTo9 = numbersUpToN(9);
        for (int number : upTo9) {
            System.out.println(""+number);
        }
    }


    /* 8. let's use arrays to solve a problem!
        Implement the Sieve of Eratosthenes
    */
    static int[] findPrimesLessThanN(int n)
    {

        boolean[] possiblePrimes = new boolean[n];
        
        for (int i = 0; i < possiblePrimes.length; i++)
            possiblePrimes[i] = true;

        possiblePrimes[0] = false;
        possiblePrimes[1] = false;
	
        for (int i = 2; i < n; i++) {
            for (int j = i * 2; j < n; j += i)
                possiblePrimes[j] = false;
        }
	
        int count = 0;
        for (boolean possible : possiblePrimes) {
            if (possible)
                count++;
        }
        
        int[] primes = new int[count];

        int currentPrimeIndex = 0;

        for (int i = 0; i < possiblePrimes.length; i++) {
            if (possiblePrimes[i]) {
                primes[currentPrimeIndex] = i;
                currentPrimeIndex++;
            }
        }
	
        return primes;
    }

    static void problem8() {
        int[] primesUpTo100 = findPrimesLessThanN(100);
        for (int prime : primesUpTo100) {
            System.out.println(""+prime);
        }

    }

}
