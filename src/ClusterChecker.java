import java.util.ArrayList;

class ClusterChecker {
    ArrayList<SingleInstance> initialDataset;
    ArrayList<SingleInstance> clusterOne;
    ArrayList<SingleInstance> clusterTwo;
    ArrayList<SingleInstance> clusterThree;
    ArrayList<SingleInstance> clusterFour;
    ArrayList<Centroid> centroids;

    public ClusterChecker(ArrayList<SingleInstance> dataset, ArrayList<Centroid> centroids) {
        this.initialDataset = dataset;
        this.centroids = centroids;
    }

    private int findClosetCluster(SingleInstance singleInstance) {
        return 0;
    }

    private int distanceChecker(SingleInstance singleInstance) {
        return 0;
    }
}