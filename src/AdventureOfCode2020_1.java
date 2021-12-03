import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AdventureOfCode2020_1 {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day1.txt"));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day1.txt"));


        //bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
        String s;
        List<Integer> ints = new ArrayList<>();
        List<Integer> diffs = new ArrayList<>();
//        List<Integer> diff2 = new ArrayList<>();

        while ((s = bufferedReader.readLine()) != null){
            ints.add(Integer.valueOf(s));
            diffs.add(2020 - Integer.valueOf(s));
        }

        for (int i = 0; i < diffs.size(); i++) {
            for (int j = 0; j < ints.size(); j++) {
                Integer n3 = diffs.get(i) - ints.get(j);
                if ( n3 > 0 && ints.contains(n3) && (2020 - diffs.get(i) + ints.get(j) + n3 == 2020)) {
                    System.out.println("n1: " + (2020 - diffs.get(i)) + " n2: " + ints.get(j) + " n3: " + n3 + " total: " + ((2020 - diffs.get(i)) * ints.get(j) * n3));
                    break;
                }
            }
        }

//        for (int i = 0; i < diff2.size(); i++) {
//            if (ints.contains(diffs.get(i))) {
//                System.out.println("n1: " + diffs.get(i) + " n2: " + (2020 - diffs.get(i)) + " n1 * n2: " + (diffs.get(i) * (2020 - diffs.get(i))));
////                break;
//            }
//        }

//        Result.calculateSum(ints);

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
