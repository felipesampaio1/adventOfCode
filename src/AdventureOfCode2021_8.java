import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventureOfCode2021_8 {
    private static int INDEX_NOT_FOUND = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day8.txt"));
        String line;
        Integer soma = 0;
        String result;
        while ((line = bufferedReader.readLine()) != null) {
            result = "";
            String[] digit = new String[10];
            String[] inputs = line.split(" \\| ")[0].split(" ");
            String[] outputs = line.split(" \\| ")[1].split(" ");

            ordernar(inputs);

            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i].length() == 2)
                    digit[1] = inputs[i];
                else if (inputs[i].length() == 3)
                    digit[7] = inputs[i];
                else if (inputs[i].length() == 4)
                    digit[4] = inputs[i];
                else if (inputs[i].length() == 7)
                    digit[8] = inputs[i];
            }

            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i].length() == 5)
                    if (diferenca(digit[7], inputs[i]).length() == 0)
                        digit[3] = inputs[i];
                    else if (diferenca(digit[4], inputs[i]).length() == 1)
                        digit[5] = inputs[i];
                    else if (diferenca(digit[4], inputs[i]).length() == 2)
                        digit[2] = inputs[i];
            }

            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i].length() == 6)
                    if ((diferenca(digit[5], inputs[i]).length() == 0) && diferenca(digit[1], inputs[i]).length() == 0)
                        digit[9] = inputs[i];
                    else if ((diferenca(inputs[i], digit[5]).length() == 1) && (diferenca(digit[1], inputs[i]).length() == 1))
                        digit[6] = inputs[i];
                    else if ((diferenca(inputs[i], digit[5]).length() == 2) && (diferenca(digit[5], inputs[i]).length() == 1))
                        digit[0] = inputs[i];
            }



            for (int i = 0; i < outputs.length; i++) {
                for (int j = 0; j < digit.length; j++) {
                    if ((diferenca(outputs[i], digit[j]).length() == 0) && (diferenca(digit[j], outputs[i]).length() == 0)) {
                        result += j;
                        break;
                    }
                }
            }
            soma += Integer.valueOf(result);
        }
        System.out.println("Soma: " + soma);
//        System.out.println("Result: " + result);

    }

    private static void ordernar(String[] signals) {
        String aux;
        for (int i = 0; i < signals.length; i++) {
            for (int j = 0; j < signals.length - 1; j++) {
                if (signals[j].length() > signals[j + 1].length()) {
                    aux = signals[j];
                    signals[j] = signals[j + 1];
                    signals[j + 1] = aux;
                }
            }
        }
    }


    public static String diferenca(CharSequence cs1, CharSequence cs2) {
        String result = "";
        boolean possui;
        for (int i = 0; i < cs1.length(); ++i) {
            possui = false;
            for (int j = 0; j < cs2.length(); j++) {
                if (cs1.charAt(i) == cs2.charAt(j)) {
                    possui = true;
                }
            }
            if (!possui)
                result = result + cs1.charAt(i);
        }
        return result;
    }
}
