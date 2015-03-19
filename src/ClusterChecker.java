import java.util.ArrayList;

class ClusterChecker {
    ArrayList<SingleInstance> initialDataset;
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

        for(int i = 0; i < 3; i++) {
//            if(i == 0) {
//                singleInstance.setClusterClass(i);
//            }
//            if(distance[i] < singleInstance.getClusterClass()) {
            if(distance[i] <= singleInstance.getClusterClass()) {
                singleInstance.setClusterClass(((int) distance[i]));
            }
//            }
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
            results[index] = Math.sqrt(Math.pow((singleInstance.getPollution().getNitricOxide() - centroid.getNitricOxide()), 2) + Math.pow((singleInstance.getPollution().getSulphurDioxide() - centroid.getSulphurDioxide()), 2) + Math.pow((singleInstance.getPollution().getOzone() - centroid.getOzone()), 2));
            index++;
        }
        return results;
    }
}