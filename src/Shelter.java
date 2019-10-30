import java.util.Scanner;

public class Shelter {

    private static int shelters(int p, int n, int m) {
        return (int) Math.ceil((double) p / m) - n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(shelters(p, n, m));
    }
}
