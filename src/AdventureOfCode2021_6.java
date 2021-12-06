import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventureOfCode2021_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\TL951AD\\OneDrive - EY\\Documents\\Desenvolvimento\\adventOfCode\\day6.txt"));

        String line;
        List<Long> fishs = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            
            String[] input = line.split(",");
            
            for (int i = 0; i < input.length; i++)
                fishs.add(Long.valueOf(input[i]));
        }

        print(fishs, 0);

        calculateDays(fishs, 256);

        System.out.println("The total of fishs: " + fishs.size());
    }

    private static void calculateDays(List<Long> fishs, int days) {
        int count = 1;
        for (int i = days; i > 0 ; i--) {
            for (int j = 0; j < fishs.size(); j++) {
                fishs.set(j, fishs.get(j) - 1);
            }

            for (int j = 0; j < fishs.size(); j++) {
                if (fishs.get(j) < 0){
                    fishs.set(j, 6L);
                    fishs.add(8L);
                }
            }
           // print(fishs, count++);
        }

    }

    private static void print(List<Long> fishs, int days) {
        if (days == 0)
            System.out.print("Initial State: ");
        else if (days > 0)
            System.out.print("After " + days + " days: ");
        for (int i = 0; i < fishs.size() - 1; i++) {
            System.out.print(fishs.get(i) + ",");
        }
        System.out.println(fishs.get(fishs.size() - 1));
    }
}
