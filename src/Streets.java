import java.util.*;

public class Streets {

    private static Map<Integer, Square> squares = new HashMap<>();
    private static List<Integer> busySquares = new ArrayList<>();

    private static int streets(int n) {
        int streets = 0;
        for (int i = 1; i <= n; i++) {
            if (!busySquares.contains(i)) {
                Square square = squares.get(i);
                System.out.println(busySquares);
                if (square.hasSingleConnection()) {
                    busySquares.add(square.number);
                    System.out.print(square.number);
                    square.getStreetEnd();
                    System.out.println();
                    streets++;
                }
                System.out.println(busySquares);
            }
        }
        return streets;
    }

    private static class Square {

        private List<Square> connections = new ArrayList<>();
        private int number;

        private Square(int number) {
            this.number = number;
        }

        private void addConnection(int num) {
            connections.add(squares.get(num));
        }

        private boolean hasSingleConnection() {
            return connections.size() == 1;
        }

        private void getStreetEnd() {
            for (Square square : this.connections) {
                if (!busySquares.contains(square.number)) {
                    System.out.print("-" + square.number);
                    if (square.hasSingleConnection()) {
                        busySquares.add(square.number);
                        return;
                    } else {
                        List<Square> connections = square.connections;

                        connections.remove(this);
                        square.getStreetEnd();
                        connections.add(this);
                        return;
                    }
                }
            }
        }

        public String toString() {
            return "Square={" + connections.size() + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            squares.put(i, new Square(i));
        }
        for (int i = 0; i < m; i++) {
            int num0 = scanner.nextInt();
            int num1 = scanner.nextInt();
            squares.get(num0).addConnection(num1);
            squares.get(num1).addConnection(num0);
        }

        System.out.println(streets(n));
    }
}
