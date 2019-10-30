import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poles {

    private static int avgPole(List<Integer> poles) {
        int length = poles.size();
        for (int i = 0; i < length; i++) {
            List<Integer> sec = new ArrayList<>(poles);
            int num = sec.remove(i);
            if (num == avg(sec)) {
                return num;
            }
        }
        return -1;
    }

    private static double avg(List<Integer> list) {
        long total = 0;
        for (int num : list) total += num;
        return total / list.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> poles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            poles.add(scanner.nextInt());
        }

        System.out.println(avgPole(poles));
    }
}
