import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventureOfCode2021_1 {

// 2021 1.1
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day1.txt"));
//
//        int previous = Integer.valueOf(bufferedReader.readLine());
//        String read;
//
//        int count = 0;
//
//        while ((read = bufferedReader.readLine()) != null) {
//            int actual = Integer.valueOf(read);
//            if (actual > previous) {
//                count++;
//            }
//            previous = actual;
//        }
//
//        System.out.println("Increased: " + count);
//    }

// 2021.1.2
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day1.txt"));

        String read;
        List<Integer> values = new ArrayList<>();
        while ((read = bufferedReader.readLine()) != null) {
             values.add(Integer.valueOf(read));
        }

        List<Integer> measurements = new ArrayList<>();

        for (int i = 0; i < values.size() - 2; i++) {
            measurements.add(values.get(i) + values.get(i+1) + values.get(i+2));
        }

        int previous = measurements.get(0);
        int count = 0;

        for (int i = 1; i < measurements.size(); i++) {
            if (measurements.get(i) > previous) {
                count++;
            }
            previous = measurements.get(i);
        }

        System.out.println("Increased: " + count);
    }
}
