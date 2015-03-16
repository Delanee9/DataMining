import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class DataHandler {
    public static void main(String [] args) {
        List<SingleInstance> dataset = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while((line = bufferedReader.readLine()) != null) {
               dataset.add(new SingleInstance(new DateEntry(), new Pollution(), new BikeData()));
            }
        } catch(Exception e) {
            System.out.println("Failure in Main - " + e);
        }
    }
}