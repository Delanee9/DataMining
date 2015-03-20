class SingleInstance {
    private final DateEntry dateEntry;
    private final Pollution pollution;
    private final BikeData bikeData;
    private int clusterClass = 10000000;
    private double distance = 1000000.0;

    public SingleInstance(DateEntry dateEntry, Pollution pollution, BikeData bikeData) {
        this.dateEntry = dateEntry;
        this.pollution = pollution;
        this.bikeData = bikeData;
    }

    public DateEntry getDateEntry() {
        return dateEntry;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public BikeData getBikeData() {
        return bikeData;
    }

    public void setClusterClass(int clusterClass) {
        this.clusterClass = clusterClass;
    }

    public int getClusterClass() {
        return clusterClass;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}