import java.util.*;

enum StringCommand {ADD, SORT, REMOVE, CLEAN, QUIT, INVALID}
public class StringSetManager {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] stringSet = new String[100];
        while (true) {
            final StringCommand command = getCommand(scanner);
            if (command == StringCommand.QUIT) {
                System.out.println("BYE!"); break;
            }
            switch (command) {
                case ADD:
                    final String str = getString(scanner);
                    add(stringSet, str);
                    break;
                case SORT:
                    final String order = getString(scanner);
                    sort(stringSet, order);
                    break;
                case REMOVE:
                    final String string = getString(scanner);
                    remove(stringSet, string);
                    break;
                case CLEAN:
                    clean(stringSet);
                    break;
                case INVALID:
                default:
                    System.out.println("Invalid");
                    break;
            }
            print(stringSet);
        }
        scanner.close();
    }

    public static StringCommand getCommand(final Scanner scanner) {
        final String commandName = scanner.next();
        StringCommand command;
        try {
            command = StringCommand.valueOf(commandName.toUpperCase());
        }
        catch (IllegalArgumentException e) {command = StringCommand.INVALID;}

        return command;
    }

    public static String getString(final Scanner scanner) {
        return scanner.next();
    }

    public static void add(String[] stringSet, final String str) {
        int cnt;
        for (cnt = 0; stringSet[cnt] != null; cnt++) {
            if (stringSet[cnt].equals(str)) return;
        }
        stringSet[cnt] = str;
    }

    public static void sort(String[] stringSet, final String order) {
        int cnt= 0;
        while (stringSet[cnt] != null) {
            cnt++;
        }
        if ("ASC".equals(order)) Arrays.sort(stringSet, 0, cnt);
        else if ("DESC".equals(order)) Arrays.sort(stringSet, 0, cnt, Collections.reverseOrder());
        /*for (cnt = 0; stringSet[cnt] != null; cnt++) {
            stringSet[cnt] = stringSet[cnt];
        }*/
    }

    public static void remove(String[] stringSet, final String str) {
        int i;
        for (i = 0; stringSet[i] != null; i++) {
            if (str.equals(stringSet[i])) break;
        }
        
        for (int j = i; stringSet[j] != null; j++) {
            stringSet[j] = stringSet[j+1];
        }
    }

    public static void clean(String[] stringSet) {
        for (int i = 0; stringSet[i] != null; i++) {
            stringSet[i] = null;
        }
    }

    public static void print(String[] stringSet) {
        int cnt= 0;
        while (stringSet[cnt] != null) {
            cnt++;
        }
        System.out.printf("Element Size: %d, Values = [",cnt);
        for (int i = 0; stringSet[i] != null; i++) {
            if (stringSet[i+1] == null) System.out.printf("%s", stringSet[i]);
            else System.out.printf("%s, ", stringSet[i]);
        }
        System.out.println("]");
    }
}
