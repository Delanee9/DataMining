import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

class DataHandler {
    public static void main(String[] args) {
        ArrayList<SingleInstance> dataset = new ArrayList<>();
        BufferedReader bufferedReader;
        String line;
        String [] tokens;
        final int numClusters = 3;
        ArrayList<Centroid> centroids = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while((line = bufferedReader.readLine()) != null) {
                tokens = line.split(",");
                dataset.add(new SingleInstance(new DateEntry(tokens[0]), new Pollution(tokens[1], tokens[2], tokens[3]), new BikeData(tokens[4], tokens[5])));
            }
            //just a test to see if all elements fo into the list
            System.out.println("size of list - " + dataset.size());

            centroids = calculateStartingCentroids(dataset, numClusters);

            //have dataset, have initial centroids

            ClusterChecker checker = new ClusterChecker(dataset,centroids);
            checker.calculateClosestClustersToData();


        } catch(Exception e) {
            System.out.println("Failure in Main - " + e);
        }
    }

    public static ArrayList<Centroid> calculateStartingCentroids(ArrayList<SingleInstance> data, int numClusters)
    {
        ArrayList<Centroid> centroidList = new ArrayList<>();
        while(centroidList.size()< numClusters){
            SingleInstance dataRow = data.get(randInt(0, data.size() - 1));
            Pollution pollutionData = dataRow.getPollution();
            centroidList.add(new Centroid(pollutionData.getNitricOxide(),pollutionData.getSulphurDioxide(),pollutionData.getOzone()));
        }
        for(Centroid c : centroidList) {   //Test - Centroid
            System.out.println(c.getNitricOxide() + " " + c.getOzone() + " " + c.getSulphurDioxide());
        }
        return centroidList;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;

    }
}