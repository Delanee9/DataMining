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
    private boolean findClosetCluster(SingleInstance singleInstance, boolean isFinished) {
        double[] distance = distance(singleInstance);

        for(int i = 0; i < 3; i++) {
            if(distance[i] < singleInstance.getDistance()) {
                singleInstance.setClusterClass(i);
                singleInstance.setDistance(distance[i]);
                isFinished = true;
            }
        }
        return isFinished;
    }

    /**
     * Loop through each element in the dataset and assign it to a cluster.
     */
    private boolean calculateClosestClustersToData(boolean isFinished) {
        for(SingleInstance s : initialDataset) {
             isFinished = findClosetCluster(s,isFinished);
            //System.out.println(s.getClusterClass());
        }
        return isFinished;
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
        Centroid c = new Centroid(averageNitricOxide / count, averageSulphurDioxide / count, averageOzone / count);
        return c;
    }

    /**
     * Checks the elements in each cluster 10 times to ensure higher accuracy.
     */
    public void recheckLoop() {
        boolean isFinished = true;
        int count = 0;
        while(isFinished) {
            isFinished = false;
            isFinished = calculateClosestClustersToData(isFinished);
            centroids = new ArrayList<>(Arrays.asList(updatedCentroid(0), updatedCentroid(1), updatedCentroid(2)));
            count++;
            System.out.println(count);
        }
        System.out.println("Times Run: " + count);
    }
}