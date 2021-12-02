import javax.swing.*;
import java.util.Scanner;

public class ArrayEnum {
    enum Command {ADD, LIST, SRTA, SRTD, SUM, QUIT, NOT_COMMAND};

    public static void main(String[] args) {
        int[] values = new int[100];
        int index = 0;
        final Scanner scanner = new Scanner(System.in);

        while ( true ) {
            final Command command = getCommand(scanner);
            if ( command == Command.QUIT ) {
                System.out.println("Bye!");
                break;
            }
            switch ( command ) {
                case ADD:
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    index++;
                    break;
                case LIST:
                    printList(values, index);
                    break;
                case SRTA:
                    printList(sort(values, index, SortOrder.ASCENDING), index);
                    break;
                case SRTD:
                    printList(sort(values, index, SortOrder.DESCENDING), index);
                    break;
                case SUM:
                    final int sum = getSum(values, index);
                    System.out.println(sum);
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }

        scanner.close();
    }

    private static Command getCommand(final Scanner scanner) {
        final String commandName = scanner.next();
        Command command;
        switch (commandName.toUpperCase()) {
            case "ADD":
            case "LIST":
            case "SRTA":
            case "SRTD":
            case "SUM":
            case "QUIT":
                command = Command.valueOf(commandName.toUpperCase());
                break;
            default:
                command = Command.NOT_COMMAND;
                break;
        }
        return command;
    }

    private static int getValue(final Scanner scanner) {
        final int num = scanner.nextInt();
        return num;
    }

    private static void printList(final int[] arr, final int idx) {
        for ( int i = 0; i < idx; i++ ) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    private static int getSum(final int[] arr, final int idx) {
        int sum = 0;
        for ( int i : arr ) sum += i;
        return sum;
    }

    private static int[] sort(final int[] arr, final int idx, SortOrder order) {
        int[] returnArr = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) returnArr[i] = arr[i];

        mergeSort(returnArr, 0, idx - 1);
        switch ( order ) {
            case ASCENDING:
                break;
            case DESCENDING:
                reverseArr(returnArr, idx);
                break;
            default:
                break;
        }
        return returnArr;
    }

    public static int[] sorted = new int[100];
    public static void mergeSort(int[] arr, int start, int end) {
        if ( start < end ) {
            int mid = (start+end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            int i = start;
            int j = mid + 1;
            int idx = start;

            while ( i <= mid && j <= end ) {
                if ( arr[i] < arr[j] ) sorted[idx++] = arr[i++];
                else sorted[idx++] = arr[j++];
            }

            while ( i <= mid ) sorted[idx++] = arr[i++];
            while ( j <= end ) sorted[idx++] = arr[j++];

            for ( int k = start; k < idx; k++ )
                arr[k] = sorted[k];
        }
    }

    public static void reverseArr(int[] arr, final int idx) {
        for ( int i = 0; i <= idx/2; i++ ) {
            int temp = arr[i];
            arr[i] = arr[idx - i - 1];
            arr[idx - i - 1] = temp;
        }
    }
}
