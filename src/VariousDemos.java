import java.util.Arrays;

public class VariousDemos {
    public static void main(String[] args) {
        System.out.println("" + average());
        System.out.println("" + average(1, 2, 3));
        System.out.println("" + average(1, 0.5, 0.25, 0.125));

        double[] data = {1, 2, 3, 4};
        System.out.println("" + average(data));

        String[] words = {"Hello", "World", "testing", "one", "two", "3.1415"};
        System.out.println(join(",", words));

        System.out.println(join(" ", "My", "name", "is", "Bond"));

        int[] ages = {10, 19, 20, 23, 42};
        int age = (int) (Math.random() * 100);

        if (find(ages, age) != -1) {
            System.out.println("found a match!");
        } else {
            System.out.println("no match found");
        }


        int[] values = new int[1000_000_000];
        for (int i = 0; i < data.length; ++i) {
            values[i] = (int) (Math.random() * 100) + 1; // random number 1 to 100
        }

        double start = System.nanoTime();
        find(values, 42);
        double end = System.nanoTime();
        System.out.printf("find execution time: %1.10f sec\n", (end - start) / 1e9);

        Arrays.sort(values);
        start = System.nanoTime();
        binaryFind(values, 42);
        end = System.nanoTime();
        System.out.printf("binary find execution time: %1.10f sec\n", (end - start) / 1e9);

    }

    private static double average(double... numbers) {
        var sum = 0.0;
        for (var number : numbers) sum += number;
        return sum / numbers.length;
    }

    private static String join(String separator, String... words) {
        StringBuilder builder = new StringBuilder();

        builder.append(words[0]);
        for (int i = 1; i < words.length; ++i) {
            builder.append(separator).append(words[i]);
        }

        return builder.toString();
    }

    private static int find(int[] list, int value) {
        for (var i = 0; i < list.length; ++i) {
            if (list[i] == value) return i;
        }
        return -1; // search failed return sentinel
    }

    private static int binaryFind(int[] sortedList, int value) {
        int lowestPossibleLoc = 0;
        int highestPossibleLoc = sortedList.length - 1;
        while (highestPossibleLoc >= lowestPossibleLoc) {
            int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
            if (sortedList[middle] == value) {
                return middle;
            } else if (sortedList[middle] > value) {
                highestPossibleLoc = middle - 1;
            } else {
                lowestPossibleLoc = middle + 1;
            }
        }
        return -1;
    }
}
