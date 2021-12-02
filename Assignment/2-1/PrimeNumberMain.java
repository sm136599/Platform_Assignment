import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        final int num = scanner.nextInt();

        for ( int i = 2; i <= num; i++) {
            System.out.println("Prime Numbers less than or equal to " + i + " = " + Arrays.toString(getPrimeNumber(i)));
        }
        scanner.close();
    }

    private static Integer[] getPrimeNumber (final int n) {
        int j=0;
        for ( int i = 2; i <= n; i++) {
            if ( isPrimeNUmber(i) ) {
                j++;
            }
        }
        Integer[] a = new Integer[j];
        j=0;
        for ( int i = 2; i <= n; i++) {
            if ( isPrimeNUmber(i) ) {
                a[j] = i;
                j++;
            }
        }
        return a;
    }
    private static boolean isPrimeNUmber (final int x) {
        for ( int i = 2; i*i <= x; i++ ) {
            if ( x % i == 0 ) return false;
        }
        return true;
    }
}
