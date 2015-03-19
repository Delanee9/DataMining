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

    /**
     * Check the distance from a point to a centroid.
     * @param singleInstance SingleInstance
     * @param centroid Centroid
     * @return double
     */
    public double distance(SingleInstance singleInstance, Centroid centroid) {
        return Math.sqrt((singleInstance.getPollution().getNitricOxide() - centroid.getNitricOxide()) * (singleInstance.getPollution().getSulphurDioxide() - centroid.getSulphurDioxide()) * (singleInstance
        .getPollution().getOzone() - centroid.getOzone()));
    }
}