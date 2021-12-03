import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventureOfCode2021_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day3.txt"));

        String line;
        int[] zeros = new int[12];
        int[] uns = new int[12];

        while ((line = bufferedReader.readLine()) != null) {
            String[] bits = line.split("");

            for (int i = 0; i < 12; i++) {
                if (bits[i].equals("0"))
                    zeros[i] += 1;
                else
                    uns[i] += 1;
            }
        }

        String gamma = "", y = "";
        for (int i = 0; i < 12; i++) {
            if (zeros[i] > uns[i]) {
                gamma += "0";
                y += "1";
            } else {
                gamma += "1";
                y += "0";
            }
        }

        Double n1 = 0d, n2 = 0d;
        String[] binary = gamma.split("");
        String[] binary2 = y.split("");
        int pow = 0;

        for (int i = 11; i >= 0; i--) {
            n1 += Math.pow(2, pow) * Integer.valueOf(binary[i]);
            n2 += Math.pow(2, pow++) * Integer.valueOf(binary2[i]);
        }

        System.out.println("gamma: " + gamma);
        System.out.println("y: " + y);
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
        System.out.println("n1 * n2: " + (n1 * n2));
    }

    static class AdventureOfCode2021_3_2 {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day3.txt"));

            String line;
            List<String[]> input = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                input.add(line.split(""));
            }

            List<String[]> oxygen = oxygen(input, 0);
            List<String[]> co2 = co2(input, 0);


            Double n1 = 0d, n2 = 0d;
            String[] binary = oxygen.get(0);
            String[] binary2 = co2.get(0);
            int pow = 0;

            for (int i = 11; i >= 0; i--) {
                n1 += Math.pow(2, pow) * Integer.valueOf(binary[i]);
                n2 += Math.pow(2, pow++) * Integer.valueOf(binary2[i]);
            }

            System.out.println("n1: " + n1);
            System.out.println("n2: " + n2);
            System.out.println("n1 * n2: " + (n1 * n2));
        }
    }

    public static List<String[]> oxygen(List<String[]> input, int column) {
        if (input.size() > 1)
            return oxygen(splitArray(input, column, "oxygen", true), ++column);
        return input;
    }

    public static List<String[]> co2(List<String[]> input, int column) {
        if (input.size() > 1)
            return co2(splitArray(input, column, "co2", false), ++column);
        return input;
    }


    public static List<String[]> splitArray(List<String[]> input, int column, String spliter, boolean most) {

        List<String[]> zeros = new ArrayList<>();
        List<String[]> ones = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i)[column].equals("0"))
                zeros.add(input.get(i));
            else ones.add(input.get(i));
        }

        if (zeros.size() > ones.size())
            if (most)
                return zeros;
            else return ones;
        else if (zeros.size() < ones.size())
            if (most)
                return ones;
            else return zeros;
        else if (spliter.equals("oxygen"))
            return ones;
        else return zeros;

    }
}