import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventureOfCode2021_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day5.txt"));

        String line;

        Integer[][] board = new Integer[1000][1000];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }

        while ((line = bufferedReader.readLine()) != null) {
            String[] points = line.split(" -> ");
            String[] p1 = points[0].split(",");
            String[] p2 = points[1].split(",");

            printBoard(p1, p2, board);
//            print(board);
        }

        System.out.println("Result of most is: " + calulateMost(board));

    }

    private static void print(Integer[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }


    private static int calulateMost(Integer[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 1)
                    result++;
            }
        }
        return result;
    }

    private static void printBoard(String[] p1, String[] p2, Integer[][] board) {
        int x1 = Integer.valueOf(p1[0]);
        int y1 = Integer.valueOf(p1[1]);
        int x2 = Integer.valueOf(p2[0]);
        int y2 = Integer.valueOf(p2[1]);

        if (x1 == x2) {
            if (y2 < y1){
                int aux = y1;
                y1 = y2;
                y2 = aux;
            }
            for (int i = y1; i <= y2; i++)
                board[i][x1] += 1;

        } else if (y1 == y2) {
            if (x2 < x1) {
                int aux = x1;
                x1 = x2;
                x2 = aux;
            }
            for (int i = x1; i <= x2; i++)
                board[y1][i] += 1;
        }
        else {
            if (x1 > x2) {
                int aux1 = x1;
                int aux2 = y1;
                x1 = x2;
                y1 = y2;
                x2 = aux1;
                y2 = aux2;
            }
            // diagonal descendo
            if (y1 < y2)
                for (int i = 0; i <= x2 - x1; i++)
                    board[y1 + i][x1 + i] += 1;
            // diagonal subindo
            else
                for (int i = 0; i <= x2 - x1; i++)
                    board[y1 - i][x1 + i] += 1;

        }
    }
}