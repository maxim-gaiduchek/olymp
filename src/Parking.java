import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parking {

    private static int minLength(List<Integer> bCoords, List<Integer> pLens) {
        long sumLength = 0;
        for (int len : pLens) sumLength += len;

        int min = 0, last = bCoords.size() - 1;
        for (long c0 = bCoords.get(0); c0 <= bCoords.get(last) + sumLength; c0++) {
            List<Long> pCoords = getParkingsCoords(c0, pLens);

            int temp = getCurrMin(bCoords, pCoords);
            if (min > temp || min == 0) min = temp;
        }
        return min;
    }

    private static List<Long> getParkingsCoords(long c0, List<Integer> lens) {
        List<Long> coords = new ArrayList<>();
        coords.add(c0);
        int size = lens.size() - 1;
        for (int c = 0, l = size; c <= size; c++, l--) {
            coords.add(coords.get(c) - (long) lens.get(l));
        }
        return coords;
    }

    private static int getCurrMin(List<Integer> bCoords, List<Long> pCoords) {
        int min = 0, size = bCoords.size();
        for (int b = 0, p = size - 1; b < size; b++, p--) {
            min += Math.abs(bCoords.get(b) - pCoords.get(p));
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> bCoord = new ArrayList<>();
        List<Integer> pLens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bCoord.add(scanner.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            pLens.add(scanner.nextInt());
        }

        System.out.println(minLength(bCoord, pLens));
    }
}
