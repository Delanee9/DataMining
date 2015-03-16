class SingleInstance {
    private final DateEntry dateEntry;
    private final Pollution pollution;
    private final BikeData bikeData;

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
}