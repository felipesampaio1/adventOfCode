import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventureOfCode2021_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day4.txt"));

        String line = bufferedReader.readLine();
        List<String> numeros = Arrays.asList(line.split(","));
        List<String[][]> cartelas = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String[][] cartela = new String[5][5];
            for (int i = 0; i < 5; i++) {
                String[] read = normalizer(bufferedReader.readLine().split(" "));
                for (int j = 0; j < 5; j++) {
                    cartela[i][j] = read[j];
                }
            }
            cartelas.add(cartela);
        }

        String[] cartelasBatidas = new String[cartelas.size()];
        for (int i = 0; i < cartelasBatidas.length; i++) {
            cartelasBatidas[i] = "";
        }

        for (int i = 0; i < numeros.size(); i++) {

            for (int z = 0; z < cartelas.size(); z++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        String numero = numeros.get(i);
                        String numCartela = cartelas.get(z)[j][k];
                        if (numero.equals(numCartela)) {
                            cartelas.get(z)[j][k] = cartelas.get(z)[j][k] + "*";
                            if (checkBatida(cartelas.get(z), j, k)) {
                                if (checkUltimaCartela(cartelasBatidas, z) && cartelasBatidas[z].equals(""))
                                    calulaSoma(cartelas.get(z), cartelas.get(z)[j][k]);
                                cartelasBatidas[z] = "*";
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean checkUltimaCartela(String[] cartelasBatidas, int z) {
        int resta = 0;
        for (int i = 0; i < cartelasBatidas.length; i++) {
            if (!cartelasBatidas[i].equals("*"))
                resta++;
        }

        if (resta > 1)
            return false;

        return true;

    }

    private static boolean checkBatida(String[][] cartela, int j, int k) {
        int count = 0, soma = 0;
        for (int i = 0; i < 5 ; i++) {
            if (cartela[j][i].contains("*"))
                count++;
        }
        if (count == 5){
//            calulaSoma(cartela, cartela[j][k]);
            return true;
        }

        count = 0;
        for (int i = 0; i < 5 ; i++) {

            if (cartela[i][k].contains("*"))
                count++;
        }
        if (count == 5){
//            calulaSoma(cartela, cartela[j][k]);
            return true;
        }

        return false;
    }

    private static void calulaSoma(String[][] cartela, String numBatida) {
        int soma = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!cartela[j][i].contains("*"))
                    soma += Integer.valueOf(cartela[j][i]);
            }
        }
        System.out.println("Soma da cartela batida: " + soma );
        System.out.println("Mult. da cartela batida: " + (soma * Integer.valueOf(numBatida.split("\\*")[0])));
    }

    private static String[] normalizer (String[] array){
        String[] normalizer = new String[5];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(""))
                continue;
            normalizer[j++] = array[i];
        }
        return normalizer;
    }
}