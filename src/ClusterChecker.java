import java.util.ArrayList;

class ClusterChecker {
    ArrayList<SingleInstance> initialDataset;
    ArrayList<SingleInstance> clusterOne;
    ArrayList<SingleInstance> clusterTwo;
    ArrayList<SingleInstance> clusterThree;
    ArrayList<Centroid> centroids;

    public ClusterChecker(ArrayList<SingleInstance> dataset, ArrayList<Centroid> centroids) {
        this.initialDataset = dataset;
        this.centroids = centroids;
    }

    /**
     * Find the closet cluster and set the cluster class to that cluster.
     * @param singleInstance SingleInstance
     */
    private void findClosetCluster(SingleInstance singleInstance) {
        double [] distance = distance(singleInstance);

        for(int i = 0; i < distance.length; i++) {
            if(distance[i] < singleInstance.getClusterClass()) {
                singleInstance.setClusterClass(i);
            }
        }
    }

    public void calculateClosestClustersToData(){
        for(SingleInstance s : initialDataset)
        {
            findClosetCluster(s);
            System.out.println(s.getClusterClass());
        }
    }

    /**
     * Check the distance from a point to the centroids.
     * @param singleInstance SingleInstance
     * @return double
     */
    public double[] distance(SingleInstance singleInstance) {
        double [] results = new double[centroids.size()];
        int index = 0;
        for(Centroid centroid : centroids) {
            results[index] = Math.sqrt((singleInstance.getPollution().getNitricOxide() - centroid.getNitricOxide()) * (singleInstance.getPollution().getSulphurDioxide() - centroid.getSulphurDioxide()) * (singleInstance.getPollution().getOzone() - centroid.getOzone()));
            index++;
        }
        return results;
    }
}