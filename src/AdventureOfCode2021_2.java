import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventureOfCode2021_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MDM\\IdeaProjects\\HackerRank\\day2.txt"));

        String line;

        Integer horizontal = 0 , depth = 0, aim = 0;

        while ((line = bufferedReader.readLine()) != null) {
            String[] direction = line.split(" ");
            if (direction[0].equals("forward")){
                horizontal += Integer.valueOf(direction[1]);
                depth += aim * Integer.valueOf(direction[1]);
            }
            else if (direction[0].equals("up")){
//                depth -= Integer.valueOf(direction[1]);
                aim -= Integer.valueOf(direction[1]);
            }
            else{
//                depth += Integer.valueOf(direction[1]);
                aim += Integer.valueOf(direction[1]);
            }

        }

        System.out.println("depth: " + depth);
        System.out.println("horizontal: " + horizontal);
        System.out.println("total " + (depth * horizontal));

    }

}
