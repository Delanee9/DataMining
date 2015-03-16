import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class DataHandler {
    public static void main(String[] args) {
        List<SingleInstance> dataset = new ArrayList<>();
        BufferedReader bufferedReader;
        String line;
        String [] tokens;

        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while((line = bufferedReader.readLine()) != null) {
                tokens = line.split(",");
                dataset.add(new SingleInstance(new DateEntry(tokens[0]), new Pollution(tokens[1], tokens[2], tokens[3]), new BikeData(tokens[4], tokens[5])));
            }


            //just a test to see if all elements fo into the list
            System.out.println("size of list - " + dataset.size());

        } catch(Exception e) {
            System.out.println("Failure in Main - " + e);
        }
    }
}