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
        final int numClusters = 4;
        ArrayList<Centroid> centroids;


        try {
            System.out.println("Starting Clustering Algorithm...");
            bufferedReader = new BufferedReader(new FileReader(args[0]));
            while((line = bufferedReader.readLine()) != null) {
                tokens = line.split(",");
                dataset.add(new SingleInstance(new DateEntry(tokens[0]), new Pollution(tokens[1], tokens[2], tokens[3]), new BikeData(tokens[4], tokens[5])));
            }
            System.out.println("Determining initial centroids...");
            centroids = calculateStartingCentroids(dataset, numClusters);
            ClusterChecker checker = new ClusterChecker(dataset,centroids);
            checker.recheckLoop();
            printTableToConsole(checker.initialDataset);


        } catch(Exception e) {
            System.out.println("Failure in Main - " + e);
        }
    }

    public static ArrayList<Centroid> calculateStartingCentroids(ArrayList<SingleInstance> data, int numClusters)
    {
        ArrayList<Centroid> centroidList = new ArrayList<>();
        while(centroidList.size() < numClusters){
            SingleInstance dataRow = data.get(randInt(0, data.size() - 1));
            Pollution pollutionData = dataRow.getPollution();
            centroidList.add(new Centroid(pollutionData.getNitricOxide(),pollutionData.getSulphurDioxide(),pollutionData.getOzone()));
        }
        System.out.println("Initial Centroids:");
        for(Centroid c : centroidList) {   //Test - Centroid
            System.out.println(c.getNitricOxide() + " " + c.getOzone() + " " + c.getSulphurDioxide());
        }
        return centroidList;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    public static void printTableToConsole(ArrayList<SingleInstance> dataset)
    {
        System.out.println("Clustering Completed:");
        System.out.println("---------------------------------------------------------------------");
        System.out.format("%10s%12s%12s%12s%5s%10s%2s%5s%2s%n", "Date", "NO", "SD", "O3", "HT", "TR", "|", "Cluster", "|");
        System.out.println("---------------------------------------------------------------------");
        for(SingleInstance sI : dataset) {
            System.out.format("%10s%12f%12f%12f%5d%10d%2s%5d%2s%n", sI.getDateEntry().getDate(), sI.getPollution().getNitricOxide(),sI.getPollution().getOzone(),sI.getPollution().getSulphurDioxide(),
                    sI.getBikeData().getHireTime(),sI.getBikeData().getBikeHires(),"|",sI.getClusterClass(),"|");
        }
    }
}