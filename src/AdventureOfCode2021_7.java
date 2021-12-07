import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AdventureOfCode2021_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day7.txt"));

        String line;
        List<Integer> lista = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] numeros = line.split(",");
            for (int i = 0; i < numeros.length; i++) {
                lista.add(Integer.valueOf(numeros[i]));
            }
        }

        Integer fuel = Integer.MAX_VALUE;
        Integer menorDist;
        for (int i = 0; i < lista.size(); i++) {
            menorDist = 0;
            for (int j = 0; j < lista.size(); j++) {
//                if ( i != j){
//                    menorDist += Math.abs(lista.get(i) - lista.get(j));
                    menorDist += consumo(Math.abs(lista.get(j) - i));
//                }
            }
            if (fuel > menorDist)
                fuel = menorDist;
        }

        System.out.println("Menor fuel: " + fuel);
    }

    private static Integer consumo(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += i;
        }
        return result;
    }
}
