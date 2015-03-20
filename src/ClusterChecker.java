import java.util.ArrayList;
import java.util.Arrays;

class ClusterChecker {
    ArrayList<SingleInstance> initialDataset;
    ArrayList<Centroid> centroids;

    public ClusterChecker(ArrayList<SingleInstance> dataset, ArrayList<Centroid> centroids) {
        this.initialDataset = dataset;
        this.centroids = centroids;
    }

    /**
     * Find the closet cluster and set the cluster class to that cluster.
     *
     * @param singleInstance SingleInstance
     */
    private void findClosetCluster(SingleInstance singleInstance) {
        double[] distance = distance(singleInstance);

        for(int i = 0; i < 3; i++) {
            if(distance[i] <= singleInstance.getClusterClass()) {
                singleInstance.setClusterClass(((int) distance[i]));
            }
        }
    }

    /**
     * Loop through each element in the dataset and assign it to a cluster.
     */
    public void calculateClosestClustersToData() {
        for(SingleInstance s : initialDataset) {
            findClosetCluster(s);
            System.out.println(s.getClusterClass());
        }
    }

    /**
     * Check the distance from a point to the centroids.
     *
     * @param singleInstance SingleInstance
     * @return double
     */
    private double[] distance(SingleInstance singleInstance) {
        double[] results = new double[centroids.size()];
        int index = 0;
        for(Centroid centroid : centroids) {
            results[index] = Math.sqrt(Math.pow((singleInstance.getPollution().getNitricOxide() - centroid.getNitricOxide()), 2) + Math.pow((singleInstance.getPollution().getSulphurDioxide() - centroid.getSulphurDioxide()), 2) + Math.pow((singleInstance.getPollution().getOzone() - centroid.getOzone()), 2));
            index++;
        }
        return results;
    }

    /**
     * Updates the centroid with the average values from the points within the cluster.
     *
     * @param clusterClass int
     * @return Centroid
     */
    private Centroid updatedCentroid(int clusterClass) {
        double averageNitricOxide = 0.0;
        double averageSulphurDioxide = 0.0;
        double averageOzone = 0.0;
        int count = 0;

        for(SingleInstance singleInstance : initialDataset) {
            if(singleInstance.getClusterClass() == clusterClass) {
                averageNitricOxide = averageNitricOxide + singleInstance.getPollution().getNitricOxide();
                averageSulphurDioxide = averageSulphurDioxide + singleInstance.getPollution().getSulphurDioxide();
                averageOzone = averageOzone + singleInstance.getPollution().getOzone();
                count++;
            }
        }
        return new Centroid(averageNitricOxide / count, averageSulphurDioxide / count, averageOzone / count);
    }

    /**
     * Checks the elements in each cluster 10 times to ensure higher accuracy.
     */
    public void recheckLoop() {
        for(int i = 0; i < 10; i++) {
            calculateClosestClustersToData();
            centroids = new ArrayList<>(Arrays.asList(updatedCentroid(0), updatedCentroid(1), updatedCentroid(2)));
        }
    }
}