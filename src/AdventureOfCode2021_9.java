import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventureOfCode2021_9 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day9.txt"));
        String line;
        Integer[][] matriz = new Integer[100][100];
        Integer linha = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] numeros = line.split("");
            for (int i = 0; i < numeros.length; i++) {
                matriz[linha][i] = Integer.valueOf(numeros[i]);
            }
            linha++;
        }

//        Integer risk = 0;
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[0].length ; j++) {
//                //UP
//                int up = verifica(i-1,j, matriz);
//                //DOWN
//                int down = verifica(i+1,j, matriz);
//                //LEFT
//                int left = verifica(i,j-1, matriz);
//                //RIGHT
//                int right = verifica(i,j+1, matriz);
//                if (checkSmaller(up,down,left,right, matriz[i][j]))
//                    risk += matriz[i][j] + 1;
//            }
//        }
//        System.out.println("Risk Level: " + risk);

        String basin = calculateBasin(0, 0, matriz, "");
        System.out.println("Basin: " + basin);
    }

    private static String calculateBasin(int i, int j, Integer[][] matriz, String result) {
        if (i < 0 || j < 0 || i >= matriz.length || j >= matriz[0].length)
            return result;

        if (matriz[i][j] < 9) {
            calculateBasin(i,j+1, matriz, result);
            calculateBasin(i,j-1, matriz, result);
            calculateBasin(i-1,j, matriz, result);
            calculateBasin(i+1,j, matriz, result);

        }

        return String.valueOf(matriz[i][j]) + result;

    }

    private static boolean checkSmaller(int up, int down, int left, int right, int matriz) {
        if (matriz < up && matriz < down && matriz < left && matriz < right)
            return true;
        return false;
    }

    private static Integer verifica(Integer i, Integer j, Integer[][] matriz) {
        if (i < 0 || j < 0 || i >= matriz.length || j >= matriz[0].length)
            return Integer.MAX_VALUE;
        return matriz[i][j];
    }
}
